package Kap3.client;


import Kap3.Message;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.sql.DataSource;
import java.io.IOException;
import java.net.*;
import java.time.LocalDateTime;

public class SendMessageMultiCast {
    private static final int BUFSIZE = 508;

    public static void main(String[] args) {
        String host = "228.5.6.7";
        int port = 6969;

        byte[] data = createMessage().getBytes();
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName(host);
            DatagramPacket packet = new DatagramPacket(new byte[BUFSIZE], BUFSIZE, address, port);
            packet.setData(data);
            packet.setLength(data.length);
            socket.send(packet);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        private static String createMessage () {
            Message message = new Message("Tommy", LocalDateTime.now(), "Hello Multicast");
            Jsonb jsonb = JsonbBuilder.create();
            return jsonb.toJson(message);
        }
    }
