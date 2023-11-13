package conexiones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server implements Runnable {

    private static List<Socket> clientSockets = new ArrayList<>();
    private static List<String> clientUserInfo = new ArrayList<>();

    static String[] configuracionPartida;
    static String configuracionPartidaStr;
    static int port;

    public int turno = 2;
    public boolean esperandoJugadores = true;
    public String totUserInfo = "";

    public Server(int puerto, String configuracionPartida) {
        this.port = puerto;
        this.configuracionPartida = configuracionPartida.split(",");
        this.configuracionPartidaStr = configuracionPartida;
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

                if (userInfo != null) {
                    if (userInfo.split(",")[0].equals("ADMIN")) {
                        userInfo += ",1";
                    } else {
                        userInfo += "," + turno;
                        turno++;
                    }

                    clientUserInfo.add(userInfo);
                    clientSockets.add(clientSocket);

                    Thread clientHandler = new Thread(new ClientHandler(clientSocket, userInfo));
                    clientHandler.start();

                    if (esperandoJugadores && configuracionPartida[0].equals("" + clientUserInfo.size())) {
                        Thread.sleep(5000);
                        for (Socket clientSockets : clientSockets) {
                            try {

                                PrintWriter clientOut = new PrintWriter(clientSockets.getOutputStream(), true);
                                clientOut.println("CP," + configuracionPartidaStr);

                                for (int i = 0; i < clientUserInfo.size(); i++) {
                                    String jugador = "CJ," + clientUserInfo.get(i);
                                    clientOut.println(jugador);
                                }
                                esperandoJugadores = false;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
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

        }

        @Override
        public void run() {
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                if (clientUserInfo.size() > Integer.parseInt(configuracionPartida[0])) {
                    Thread.sleep(5000);
                    out.println("SALA-LLENA");
                }

                String message;
                while ((message = in.readLine()) != null) {
                    broadcastMessage(userInfo + ": " + message);
                }

            } catch (IOException e) {

            } catch (InterruptedException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
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
