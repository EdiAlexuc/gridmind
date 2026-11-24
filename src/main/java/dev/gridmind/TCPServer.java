package dev.gridmind;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public TCPServer() throws IOException {

        //Create a ServerSocket to listen on port 2020
        ServerSocket serverSocket = new ServerSocket(2020);
        System.out.println("Port 2020 is open");

        while (true) {
            // Accept an incoming client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client " + socket.getInetAddress() + ":" + socket.getPort() + " has connected");

            // Input stream for receiving data from the client
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader inSocket = new BufferedReader(inputStreamReader);

            //Output stream for sending data to the client
            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            PrintStream outSocket =  new PrintStream(outputStream, true);

            // Send a welcome message to the client
            outSocket.println("Welcome to TCP Server!");

            // Close the socket connection
            socket.close();
            System.out.println("Socket closed");
        }
    }


    public static void main(String[] args) {
        try {
            // Create a new instance of the TCPServer to start the server
            new TCPServer();
        } catch (Exception e) {
            // Print the stack trace in case of an exception
            e.printStackTrace();
        }
    }
}
