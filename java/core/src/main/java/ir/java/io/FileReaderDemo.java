package ir.java.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This class demonstrates how to read a file from the resources directory in a
 * Java application.
 * It uses InputStream to read the file and BufferedReader to process it line by
 * line.
 */
public class FileReaderDemo {
    public static void main(String[] args) {
        // Get the resource as a stream
        InputStream inputStream = FileReaderDemo.class.getClassLoader().getResourceAsStream("input.txt");

        if (inputStream == null) {
            System.out.println("Resource not found!");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (Exception e) {
            System.out.println("Error reading resource: " + e.getMessage());
        }
    }
}
