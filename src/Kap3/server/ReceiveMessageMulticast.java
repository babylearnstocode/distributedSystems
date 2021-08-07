package Kap3.server;

import Kap2.Bestellung;
import Kap3.Message;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ReceiveMessageMulticast {
    private static final int BUFSIZE = 508;

    public static void main(String[] args) {
        String multicastAddress = "228.5.6.7";
        int port = 6969;

        try (MulticastSocket socket = new MulticastSocket(port)) {
            socket.setTimeToLive(1);
            InetAddress group = InetAddress.getByName(multicastAddress);
            socket.joinGroup(group);

            DatagramPacket packet = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);

            while (true) {
                System.out.println("Multicast...");
                socket.receive(packet);
                String json = new String(packet.getData(), 0, packet.getLength());
                Message message = deserialize(json);
                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Message deserialize(String data) {
        Jsonb jsonb = JsonbBuilder.create();
        return ((Jsonb) jsonb).fromJson(data, Message.class);
    }
}
