package ir.java.network.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A simple server socket example in Java.
 * This class listens for incoming connections on a specified port,
 * accepts a connection, reads a message from the client, and sends a response
 * back.
 */
public class ServerSocketDemo {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345");

            // Accept a connection from a client
            try (Socket clientSocket = serverSocket.accept();
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                System.out.println("Client connected");

                // Read a message from the client
                String message = in.readLine();
                System.out.println("Received from client: " + message);

                // Send a response back to the client
                out.println("Hello, Client!");

            } catch (IOException e) {
                System.err.println("Error handling client connection: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Could not start server: " + e.getMessage());
        }
        System.out.println("Server stopped");
    }
}
