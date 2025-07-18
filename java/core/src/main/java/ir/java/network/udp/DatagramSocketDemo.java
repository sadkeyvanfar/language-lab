package ir.java.network.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * A simple UDP server example in Java.
 * This class listens for incoming UDP packets, processes the received message,
 * and sends a response back to the client.
 */
public class DatagramSocketDemo {
    public static void main(String[] args) {
        try (DatagramSocket serverSocket = new DatagramSocket(9876)) {
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            System.out.println("UDP server is running...");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from client: " + message);

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                String response = "Hello from UDP server!";
                sendData = response.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);
            }
        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}
