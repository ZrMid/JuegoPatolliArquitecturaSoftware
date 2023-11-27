package conexiones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import vistas.InternalFrmTablero;

public class Cliente implements Runnable {

    private Socket socket;
    private PrintWriter out;
    private String datosJugador;
    private String ipServer;
    
    InternalFrmTablero objFrmTablero;

    public Cliente(String paquete, String ipServer, InternalFrmTablero objFrmTablero) {
        this.datosJugador = paquete;
        this.ipServer = ipServer;
        this.objFrmTablero = objFrmTablero;
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

            out.println(datosJugador);

            Thread messageReceiver = new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        objFrmTablero.txtArea.append(message+"\n");
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
    
    public boolean puedeEstablecerConexion() {
        String serverAddress = ipServer;
        int serverPort = 12345;
        try {
            socket = new Socket(serverAddress, serverPort);
            out = new PrintWriter(socket.getOutputStream(), true);
            cerrarConexion();
            return true;
        } catch (IOException e) {
            return false;
        } finally {
            cerrarConexion();
        }
    }
    
    public void cerrarConexion() {
        try {
            if (out != null) {
                out.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enviarPaquete(String msg) {
        out.println(msg);
    }

}
