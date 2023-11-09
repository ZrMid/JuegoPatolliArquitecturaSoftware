package conexiones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server implements Runnable {

    private static List<Socket> clientSockets = new ArrayList<>();
    private static List<String> clientUserInfo = new ArrayList<>();
    
    static int port; 
    
    public Server(int puerto){
        this.port = puerto;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("El servidor está escuchando en el puerto " + port);
            
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado desde " + clientSocket.getInetAddress());
                
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String userInfo = in.readLine();
                clientUserInfo.add(userInfo);

                clientSockets.add(clientSocket);
                
                Thread clientHandler = new Thread(new ClientHandler(clientSocket, userInfo));
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {

        private Socket socket;
        private PrintWriter out;
        private String userInfo;
        private String color;

        public ClientHandler(Socket socket, String userInfo) {
            this.socket = socket;
            this.userInfo = userInfo;
            broadcastMessage(userInfo + " se ha unido.");
        }

        @Override
        public void run() {
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String message;
                while ((message = in.readLine()) != null) {
                    broadcastMessage(userInfo + ": " + message);
                }
            } catch (IOException e) {
                
            } finally {
                clientSockets.remove(socket);
                clientUserInfo.remove(userInfo);
                out.println(userInfo + "se ha desconectado");
            }
        }

        private void broadcastMessage(String message) {
            for (Socket clientSocket : clientSockets) {
                if (clientSocket != socket) {
                    try {
                        PrintWriter clientOut = new PrintWriter(clientSocket.getOutputStream(), true);
                        clientOut.println(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    
    public static boolean isPortAvailable() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
