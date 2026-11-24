package dev.gridmind;

import java.io.*;
import java.net.Socket;

public class TCPClient {

    // Constructor that establishes a connection with the server
    TCPClient() throws IOException {

        // Create a socket to connect to the server running on localhost and port 2020
        Socket socket = new Socket("localhost", 2020);
        System.out.println("Sucessfully connected to the server");

        // Input stream to receive messages from server
        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Output stream to send messages to the server
        PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        String message = inSocket.readLine();
        System.out.println("Server says: " + message);

        // Send a message back to the server to acknowledge the message
        outSocket.println("Thanks!");

        // Close the socket connection after communication
        socket.close();
        System.out.println("Port 2020 closed successfully");
    }

    public static void main(String[] args) {
        try {
            new TCPClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
