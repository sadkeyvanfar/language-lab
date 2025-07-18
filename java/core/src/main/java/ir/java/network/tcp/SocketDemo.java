package ir.java.network.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * A simple client socket example in Java.
 * This class connects to a server socket, sends a message, and reads the
 * response.
 */
public class SocketDemo {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Send a message to the server
            out.println("Hello, Server!");

            // Read the response from the server
            String response = in.readLine();
            System.out.println("Server response: " + response);

        } catch (Exception e) {
            System.err.println("Error connecting to the server: " + e.getMessage());
        }
    }
}
