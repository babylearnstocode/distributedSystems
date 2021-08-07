package Kap4.server;

import Kap4.Artikel;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;

public class IterativeServer {
    private int port;
    private Map<Integer, Artikel> map;

    public IterativeServer(int port) {
        this.port = port;
        load();

    }

    private void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server Socket starts");
            process(serverSocket);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void process(ServerSocket serverSocket) {
        while (true) {
            SocketAddress socketAddress = null;
            try (Socket socket = serverSocket.accept();
                 ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                 ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {


                socketAddress = socket.getRemoteSocketAddress();
                System.out.println("Connected to " + socketAddress);
                out.flush();
                while (true) {
                    int id = in.readInt();
                    Artikel artikel = map.get(id);
                    out.writeObject(artikel);
                    out.flush();
                }


            } catch (IOException e) {
                System.err.println(e);
            } finally {
                System.out.println("Verbindung zu " + socketAddress + " beendet");
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
        new IterativeServer(6969).start();
    }
}
