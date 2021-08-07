package Kap1;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class CreateSocketAddress {
    public static void main(String[] args) {
        InetSocketAddress local = new InetSocketAddress(80);
        print(local);

        InetSocketAddress socket = new InetSocketAddress("www.google.de", 80);
        print(socket);

        socket = new InetSocketAddress("localhost", 80);
        print(socket);

    }

    private static void print(InetSocketAddress socket) {
        InetAddress inetAddress = socket.getAddress();
        System.out.printf("Socket IP Address: %s\nSocket Host name: %s | %s\nSocket port: %d\n\n", inetAddress.getHostAddress(),
                socket.getHostName(), inetAddress.getHostName(), socket.getPort());
    }

}
