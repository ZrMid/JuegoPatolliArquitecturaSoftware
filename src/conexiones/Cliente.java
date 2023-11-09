package conexiones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente implements Runnable{

    private Socket socket;
    private PrintWriter out;
    private String paquete;
    private String ipServer;
    
    public Cliente(String paquete, String ipServer){
        this.paquete = paquete;
        this.ipServer = ipServer;
    }
    
    @Override
    public void run() {
        String serverAddress = ipServer;
        int serverPort = 12345;

        try {
            socket = new Socket(serverAddress, serverPort);
            System.out.println("Conectado al servidor en " + serverAddress + ":" + serverPort);

            out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            out.println(paquete);

            Thread messageReceiver = new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        //aqui se reciben los mensajes
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            messageReceiver.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void enviar(String msg){
        out.println(msg);
    }
    
}
