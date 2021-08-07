package Kap3.client;

import Kap3.Message;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.time.LocalDateTime;

public class SendMessage {
    private static final int BUFSIZE = 508;

    public static void main(String[] args) {
        int port = 6969;
        String host = "localhost";

        String message = createMessage();

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName(host);
            DatagramPacket packet = new DatagramPacket(new byte[BUFSIZE], BUFSIZE, address, port);
            byte[] data = message.getBytes();
            packet.setData(data);
            packet.setLength(data.length);
            socket.send(packet);
            System.out.println("Packet was sent to " + address.getHostAddress() + " | " + address.getHostName());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String createMessage() {
        Message message = new Message("Tommy", LocalDateTime.now(), "hello mtfk");
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(message);
    }
}
