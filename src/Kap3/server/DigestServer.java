package Kap3.server;

import Kap3.Digest;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestServer {
    private static final int BUFSIZE = 508;

    public static void main(String[] args) {
        int port = 6969;
        String remoteHost = "localhost";
        int remotePort = 9696;

        try (DatagramSocket socket = new DatagramSocket(port)) {
            DatagramPacket inPaket = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);
            DatagramPacket outPaket = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);
            socket.connect(InetAddress.getByName(remoteHost), remotePort);
            System.out.printf("Server port: %d | Connected to port: %d\n", port, remotePort);
            while (true) {
                socket.receive(inPaket);
                System.out.println("Received: " + inPaket.getLength() + " bytes");
                String json = new String(inPaket.getData(), 0, inPaket.getLength());
                Digest digest = deserialize(json);

                String hashValue = digest(digest.getText());
                digest.setHashValue(hashValue);

                byte[] data = serialize(digest).getBytes();

                outPaket.setData(data);
                outPaket.setLength(data.length);
                outPaket.setSocketAddress(inPaket.getSocketAddress());
                socket.send(outPaket);
            }
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    private static Digest deserialize(String data) {
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.fromJson(data, Digest.class);
    }

    private static String serialize(Digest digest) {
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(digest);
    }

    //Hash text
    private static String digest(String data) throws NoSuchAlgorithmException {
        MessageDigest msg = MessageDigest.getInstance("SHA-256");
        msg.update(data.getBytes());
        byte[] digest = msg.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();

    }
}
