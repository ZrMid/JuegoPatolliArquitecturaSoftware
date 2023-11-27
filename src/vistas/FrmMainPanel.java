package vistas;

import conexiones.Cliente;
import conexiones.Server;
import datosPartida.ConfiguracionPartida;
import datosPartida.Ficha;
import datosPartida.Jugador;
import java.util.List;
import javax.swing.JOptionPane;

public class FrmMainPanel extends javax.swing.JFrame {

    InternalFrmMenu objMenu;
    InternalFrmCrearPartida objCrearPartida;
    InternalFrmTablero objTablero;
    InternalFrmUnirsePartida objUnirsePartida;

    Server objServer;
    Cliente objCliente;
    ConfiguracionPartida objConfPartida;
    Jugador objJugador;
    List<Ficha[]> objFichas;

    public FrmMainPanel() {
        initComponents();
        this.setTitle("Patolli");
        this.setLocationRelativeTo(null);
        agregarInternalFrmMenu();
    }

    public void agregarInternalFrmMenu() {
        objMenu = new InternalFrmMenu(this);
        objMenu.setVisible(true);
        jdesk.removeAll();
        jdesk.add(objMenu);
    }

    public void agregarInternalFrmCrearPartida() {
        objCrearPartida = new InternalFrmCrearPartida(this);
        objCrearPartida.setVisible(true);
        jdesk.removeAll();
        jdesk.add(objCrearPartida);
    }

    public void agregarInternalFrmUnirsePartida(String rango) {
        objUnirsePartida = new InternalFrmUnirsePartida(this, rango);
        objUnirsePartida.setVisible(true);
        jdesk.removeAll();
        jdesk.add(objUnirsePartida);
    }

    public void agregarInternalFrmTablero() {
        objTablero = new InternalFrmTablero(this);
        objTablero.setVisible(true);
        jdesk.removeAll();
        jdesk.add(objTablero);

    }

    public void crearConfiguracionPartida(int noJugadores, int noCasillasAspa, int noFichas, int noFrijoles) {
        objConfPartida = new ConfiguracionPartida(noJugadores, noCasillasAspa, noFichas, noFrijoles);
    }

    public void crearServer(int puerto) {

        String confPart = "CP," + objConfPartida.getNoJugadores() + "," + objConfPartida.getNoCasillasAspa() + "," + objConfPartida.getNoFichas() + "," + objConfPartida.getNoFrijoles();

        objServer = new Server(puerto, confPart);

        if (objServer.isPortAvailable()) {
            Thread server = new Thread(objServer);
            server.start();
            //
        } else {
            JOptionPane.showMessageDialog(this, "Ya se encuentra una sala creada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void agregarFichas(int noFichas) {
//        objFichas = new Ficha[noFichas];
//        for (Ficha objFicha : objFichas) {
//            if (objFicha.getNoFicha() == null) {
//                System.out.println("null");
//            }
//        }
    }

    public void crearJugador(String rango, String nombre, String color) {
        objJugador = new Jugador(rango, nombre, color);
    }

    public boolean ingresarServer(String ip) {
        String datosJugador = "CJ," + objJugador.getRango() + "," + objJugador.getNombre() + "," + objJugador.getColor() + ",ACTIVO";
        objCliente = new Cliente(datosJugador, ip, objTablero);

        if (objCliente.puedeEstablecerConexion()) {
            Thread cliente = new Thread(objCliente);
            cliente.start();
            return true;
        } else {
            return false;
        }
    }
    
    public void enviarPaquete(String paquete){
        objCliente.enviarPaquete(paquete);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdesk = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(904, 600));
        setMinimumSize(new java.awt.Dimension(904, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(904, 600));

        jdesk.setMaximumSize(new java.awt.Dimension(904, 600));
        jdesk.setMinimumSize(new java.awt.Dimension(904, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdesk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdesk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMainPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jdesk;
    // End of variables declaration//GEN-END:variables
}
