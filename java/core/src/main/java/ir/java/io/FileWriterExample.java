package ir.java.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * This class demonstrates how to write to a file character by character in Java.
 * It creates a file in the 'target' directory and writes a message to it.
 */
public class FileWriterExample {
    public static void main(String[] args) {
        String message = "Hello, Java!\nThis is written character by character.";

        // Define and create target directory if missing
        File outputFile = Paths.get("target", "output.txt").toFile();
        outputFile.getParentFile().mkdirs();  // Ensure 'target/' exists

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (int i = 0; i < message.length(); i++) {
                writer.write(message.charAt(i));
            }
            System.out.println("File successfully written to target/output.txt");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
