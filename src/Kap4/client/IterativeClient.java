package Kap4.client;

import Kap4.Artikel;
import org.glassfish.json.JsonUtil;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class IterativeClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 6969;

        try (Socket socket = new Socket(host, port);
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()))
        {

            System.out.println("test");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print(">>");
                int id = 0;
                try {
                    id = Integer.parseInt(scanner.next());

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                if (id == 0) {
                    break;
                }
                out.writeInt(id);
                out.flush();

                Artikel artikel = (Artikel) in.readObject();
                if (artikel != null) {
                    System.out.println(artikel);
                } else {
                    System.out.printf("Artikel: %d nicht vorhanden", id);
                }

            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }

}
