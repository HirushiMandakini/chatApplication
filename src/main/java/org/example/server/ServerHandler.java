package org.example.server;

import org.example.Client.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ServerHandler {
    private ServerSocket serverSocket;
    private Socket socket;
    private static ServerHandler server;
    private List<ClientHandler> clients = new ArrayList<>();

    private ServerHandler() throws IOException {
        serverSocket = new ServerSocket(3004);
    }

    public static ServerHandler getInstance() throws IOException {
        return server!=null? server:(server=new ServerHandler());
    }

    public void makeSocket(){
        while (!serverSocket.isClosed()){
            try{
                socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket,clients);
                clients.add(clientHandler);
                System.out.println("client socket accepted "+socket.toString());
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
