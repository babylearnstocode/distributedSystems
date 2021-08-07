package Kap3.server;

import Kap3.Message;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveMessage {
    public static void main(String[] args) {
        int port = 6969;
        int byteSize = 300;

        try (DatagramSocket socket = new DatagramSocket(port)) {
            DatagramPacket packet = new DatagramPacket(new byte[byteSize], byteSize);
            System.out.println("Listening to port "  + port);
            while (true) {

                socket.receive(packet);
                String data = new String(packet.getData(), 0, packet.getLength());
                Message message = deserialize(data);
                System.out.println(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static Message deserialize(String data) {
        Jsonb jsonb = JsonbBuilder.create();

        return jsonb.fromJson(data, Message.class);
    }
}
