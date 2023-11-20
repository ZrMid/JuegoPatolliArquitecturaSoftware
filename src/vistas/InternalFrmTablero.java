package vistas;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class InternalFrmTablero extends javax.swing.JInternalFrame implements Runnable {

    FrmMainPanel objMainPanel;
    JPanel objCasilla;
    JPanel objCasilla2;

    int tamCasillaW;
    int tamCasillaH;

    Color clrEx;
    Color clrCen;
    Color clrTra;
    Color clrDef;

    String[] config;
    List<String[]> jugadores = new ArrayList<>();

    public InternalFrmTablero(FrmMainPanel objMainPanel) {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

        this.objMainPanel = objMainPanel;

        clrEx = new Color(29, 98, 120);
        clrTra = new Color(120, 35, 29);
        clrCen = new Color(89, 78, 73);
        clrDef = new Color(185, 133, 107);

        txtArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String[] datosPartida = txtArea.getText().split("\n");
                String ultimalineaStr = datosPartida[datosPartida.length - 1];
                String[] ultimalinea = ultimalineaStr.split(",");
                switch (ultimalinea[0]) {
                    case "CP":
                        configPartida(ultimalinea);
                        pintarTablero();
                        break;
                    case "CJ":
                        agregaJugador(ultimalinea);
                        break;
                    case "SALA-LLENA":
                        salaLlena();
                        break;
                    default:
                        System.out.println("defaultSwitch----------------");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Método llamado cuando se elimina texto
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Este método se llama cuando se cambian atributos del documento (por ejemplo, estilos)
            }
        });
    }

    public void configPartida(String[] ultimaLinea) {
        config = ultimaLinea;
        if (config[1].equals("3")) {
            lbl3.setText("Esperando Jugador...");
        } else if (config[1].equals("4")) {
            lbl3.setText("Esperando Jugador...");
            lbl4.setText("Esperando Jugador...");
        }
    }

    public void agregaJugador(String[] ultimaLinea) {
        jugadores.add(ultimaLinea);
        String nombre = ultimaLinea[2];
        int turno = Integer.parseInt(ultimaLinea[ultimaLinea.length - 1]);
        switch (turno) {
            case 1:
                lbl1.setText(nombre);
                break;
            case 2:
                lbl2.setText(nombre);
                break;
            case 3:
                lbl3.setText(nombre);
                break;
            case 4:
                lbl4.setText(nombre);
                break;
        }
    }

    public void salaLlena() {
        JOptionPane.showMessageDialog(null, "La sala se encuentra llena");
        objMainPanel.agregarInternalFrmMenu();
    }

    public void pintarTablero() {
        int casillasAspa = Integer.parseInt(config[2]);
        int casillaTot = casillasAspa * 4 + 2;

        tamCasillaH = 550 / (casillasAspa * 2 + 2) - 2;
        tamCasillaW = 750 / (casillasAspa * 2 + 2) - 2;

        int posX = (904 / 2);
        int posX2 = (904 / 2) - tamCasillaW - 2;
        int posY = (600 / 2 + (tamCasillaH + 2) * casillasAspa);

        String vertHor = "y";

        for (int i = 1; i <= casillasAspa * 4 + 2; i++) {
            objCasilla = new JPanel();
            objCasilla.setBounds(posX, posY, tamCasillaW, tamCasillaH);
            objCasilla.setVisible(true);
            jPanTab.add(objCasilla);

            objCasilla2 = new JPanel();
            objCasilla2.setBounds(posX2, posY, tamCasillaW, tamCasillaH);
            objCasilla2.setVisible(true);
            jPanTab.add(objCasilla2);

            if (i == 1 || i == casillasAspa * 2 + 1 || i == casillasAspa * 2 + 2 || i == casillasAspa * 4 + 2) {
                objCasilla.setBackground(clrEx);
                objCasilla2.setBackground(clrEx);
            } else if (i == 4 || i == 5 || i == casillasAspa * 2 - 2 || i == casillasAspa * 2 - 3
                    || i == casillasAspa * 2 + 5 || i == casillasAspa * 2 + 6 || i == casillasAspa * 4 - 1 || i == casillasAspa * 4 - 2) {
                objCasilla.setBackground(clrTra);
                objCasilla2.setBackground(clrTra);
            } else if (i == casillasAspa + 1 || i == casillasAspa * 3 + 2) {
                objCasilla.setBackground(clrCen);
                objCasilla2.setBackground(clrCen);
            } else {
                objCasilla.setBackground(clrDef);
                objCasilla2.setBackground(clrDef);
            }

            if (i == casillasAspa + 1) {
                vertHor = "x";
            } else if (i == casillasAspa * 2 + 1) {
                vertHor = "y2";
            } else if (i == casillasAspa * 2 + 2) {
                vertHor = "x2";
            } else if (i == casillasAspa * 3 + 2) {
                vertHor = "y";
            }

            if (vertHor.equals("y")) {
                posY -= tamCasillaH + 2;
            } else if (vertHor.equals("x")) {
                posX += tamCasillaW + 2;
                posX2 -= tamCasillaW + 2;
            } else if (vertHor.equals("y2")) {
                posY -= tamCasillaH + 2;
                vertHor = "x2";
            } else if (vertHor.equals("x2")) {
                posX -= tamCasillaW + 2;
                posX2 += tamCasillaW + 2;
            }

            try {
                Thread.sleep(2000 / casillaTot);
            } catch (InterruptedException ex) {
                Logger.getLogger(InternalFrmTablero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanelJuego = new javax.swing.JPanel();
        jPanTab = new javax.swing.JPanel();
        jscroll = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        txtFondo = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setMaximumSize(new java.awt.Dimension(904, 600));
        setMinimumSize(new java.awt.Dimension(904, 600));
        setPreferredSize(new java.awt.Dimension(904, 600));

        jpanelJuego.setMaximumSize(new java.awt.Dimension(904, 600));
        jpanelJuego.setMinimumSize(new java.awt.Dimension(904, 600));
        jpanelJuego.setLayout(null);

        jPanTab.setBackground(new java.awt.Color(204, 255, 204));
        jPanTab.setMaximumSize(new java.awt.Dimension(904, 600));
        jPanTab.setMinimumSize(new java.awt.Dimension(904, 600));
        jPanTab.setOpaque(false);

        jscroll.setEnabled(false);
        jscroll.setMaximumSize(new java.awt.Dimension(64, 20));
        jscroll.setMinimumSize(new java.awt.Dimension(64, 20));

        txtArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtArea.setEnabled(false);
        txtArea.setOpaque(false);
        jscroll.setViewportView(txtArea);

        lbl3.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        lbl3.setForeground(new java.awt.Color(255, 255, 255));
        lbl3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl3.setText("Sin Jugador...");

        lbl4.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        lbl4.setForeground(new java.awt.Color(255, 255, 255));
        lbl4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl4.setText("Sin Jugador...");

        lbl2.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        lbl2.setForeground(new java.awt.Color(255, 255, 255));
        lbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl2.setText("Esperando Jugador...");

        lbl1.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        lbl1.setForeground(new java.awt.Color(255, 255, 255));
        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl1.setText("Esperando Admin...");

        javax.swing.GroupLayout jPanTabLayout = new javax.swing.GroupLayout(jPanTab);
        jPanTab.setLayout(jPanTabLayout);
        jPanTabLayout.setHorizontalGroup(
            jPanTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanTabLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jscroll, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(jPanTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl2, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addComponent(lbl4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanTabLayout.setVerticalGroup(
            jPanTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanTabLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
                .addGroup(jPanTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addComponent(jscroll, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jpanelJuego.add(jPanTab);
        jPanTab.setBounds(0, 0, 904, 600);

        txtFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/fondo2.jpg"))); // NOI18N
        txtFondo.setMaximumSize(new java.awt.Dimension(904, 600));
        txtFondo.setMinimumSize(new java.awt.Dimension(904, 600));
        txtFondo.setPreferredSize(new java.awt.Dimension(904, 600));
        jpanelJuego.add(txtFondo);
        txtFondo.setBounds(0, 0, 904, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanTab;
    private javax.swing.JPanel jpanelJuego;
    private javax.swing.JScrollPane jscroll;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    public static javax.swing.JTextArea txtArea;
    private javax.swing.JLabel txtFondo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {

    }
}
