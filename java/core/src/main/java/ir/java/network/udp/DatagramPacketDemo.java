package ir.java.network.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * This class demonstrates a simple UDP client that sends a message to a UDP
 * server
 * and receives a response.
 */
public class DatagramPacketDemo {
    public static void main(String[] args) {
        try (DatagramSocket clientSocket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9876;

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter message to send: ");
            String message = scanner.nextLine();

            byte[] sendData = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            clientSocket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received from server: " + response);
        } catch (Exception e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
