package Kap3.client;

import Kap3.Digest;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.IOException;
import java.net.*;

public class DigestClient {
    private static final int BUFSIZE = 508;
    private static final int TIMEOUT = 10000;

    public static void main(String[] args) {
        int localPort = 9696;
        String host = "localhost";
        int port = 6969;
        String text = args[0];

        try (DatagramSocket socket = new DatagramSocket(localPort)) {
            DatagramPacket outPacket = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);
            DatagramPacket inPacket = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);
            socket.setSoTimeout(TIMEOUT);
            byte[] data = serialize(new Digest(text)).getBytes();

            // Paket an Server senden
            outPacket.setAddress(InetAddress.getByName(host));
            outPacket.setPort(port);
            outPacket.setData(data);
            outPacket.setLength(data.length);
            socket.send(outPacket);
            System.out.println("Packet sent!\nMessage: " + text);

            // Antwortpaket empfangen
            socket.receive(inPacket);
            String json = new String(inPacket.getData(), 0, inPacket.getLength());
            Digest digest = deserialize(json);
            System.out.println("Packet received!\nMessage: " + digest.getText() + "\nHash value: " + digest.getHashValue());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String serialize(Digest digest) {
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(digest);
    }

    private static Digest deserialize(String data) {
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.fromJson(data, Digest.class);
    }


}
