package Kap4.server;

import Kap4.Artikel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;

public class ParallelServer {
    private int port;
    private Map<Integer, Artikel> map;

    public ParallelServer() {

    }

    public ParallelServer(int port) {
        this.port = port;
        load();
    }
    private void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server Socket starts");
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new Handler(socket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private class Handler implements Runnable {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            SocketAddress socketAddress = null;

            try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                 ObjectInputStream in = new ObjectInputStream(socket.getInputStream())
            ) {
                socketAddress = socket.getRemoteSocketAddress();
                System.out.println("Conneced to" + socketAddress);

                out.flush();
                while (true) {
                    int id = in.readInt();
                    Artikel artikel = map.get(id);
                    out.writeObject(artikel);
                    out.flush();
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("Connection to" + socketAddress + " end");
            }


        }
    }

    private void load() {
        map = new HashMap<>();
        map.put(4711, new Artikel(4711, "Hammer", 2.99));
        map.put(4712, new Artikel(4712, "Zange", 3.99));
        map.put(4713, new Artikel(4713, "Schraubendreher", 1.50));
    }

    public static void main(String[] args) {
        new ParallelServer(6969).start();
    }
}
