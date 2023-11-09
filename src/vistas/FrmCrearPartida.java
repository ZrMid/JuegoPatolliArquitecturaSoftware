
package vistas;

import conexiones.Server;
import javax.swing.JOptionPane;

public class FrmCrearPartida extends javax.swing.JInternalFrame {

    FrmMainPanel objMainPanel;
    
    public FrmCrearPartida(FrmMainPanel objMainPanel) {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        
        this.objMainPanel = objMainPanel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnMenosJugador = new javax.swing.JLabel();
        btnMasJugador = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblNoJugadores = new javax.swing.JLabel();
        btnMenosAspa = new javax.swing.JLabel();
        btnMasAspa = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblNoCasillasAspa = new javax.swing.JLabel();
        btnMenosFrijol = new javax.swing.JLabel();
        btnMasFrijol = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblNoFrijoles = new javax.swing.JLabel();
        btnCrearPartida = new recursos.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        btnMenosFichas = new javax.swing.JLabel();
        lblNoFichas = new javax.swing.JLabel();
        btnMasFichas = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel1.setLayout(null);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/regresar.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 40, 32, 40);

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Crear Partida");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(220, 20, 450, 80);

        btnMenosJugador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMenosJugador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/menos.png"))); // NOI18N
        btnMenosJugador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenosJugador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMenosJugadorMousePressed(evt);
            }
        });
        jPanel1.add(btnMenosJugador);
        btnMenosJugador.setBounds(150, 200, 40, 40);

        btnMasJugador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMasJugador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/mas.png"))); // NOI18N
        btnMasJugador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMasJugador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMasJugadorMousePressed(evt);
            }
        });
        jPanel1.add(btnMasJugador);
        btnMasJugador.setBounds(270, 200, 40, 40);

        jLabel4.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Jugadores");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(150, 130, 160, 90);

        lblNoJugadores.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        lblNoJugadores.setForeground(new java.awt.Color(255, 255, 255));
        lblNoJugadores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNoJugadores.setText("2");
        jPanel1.add(lblNoJugadores);
        lblNoJugadores.setBounds(190, 200, 80, 40);

        btnMenosAspa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMenosAspa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/menos.png"))); // NOI18N
        btnMenosAspa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenosAspa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMenosAspaMousePressed(evt);
            }
        });
        jPanel1.add(btnMenosAspa);
        btnMenosAspa.setBounds(550, 200, 40, 40);

        btnMasAspa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMasAspa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/mas.png"))); // NOI18N
        btnMasAspa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMasAspa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMasAspaMousePressed(evt);
            }
        });
        jPanel1.add(btnMasAspa);
        btnMasAspa.setBounds(670, 200, 40, 40);

        jLabel8.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Casillas por Aspa");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(520, 130, 220, 90);

        lblNoCasillasAspa.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        lblNoCasillasAspa.setForeground(new java.awt.Color(255, 255, 255));
        lblNoCasillasAspa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNoCasillasAspa.setText("8");
        jPanel1.add(lblNoCasillasAspa);
        lblNoCasillasAspa.setBounds(590, 200, 80, 40);

        btnMenosFrijol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMenosFrijol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/menos.png"))); // NOI18N
        btnMenosFrijol.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenosFrijol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMenosFrijolMousePressed(evt);
            }
        });
        jPanel1.add(btnMenosFrijol);
        btnMenosFrijol.setBounds(150, 350, 40, 40);

        btnMasFrijol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMasFrijol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/mas.png"))); // NOI18N
        btnMasFrijol.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMasFrijol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMasFrijolMousePressed(evt);
            }
        });
        jPanel1.add(btnMasFrijol);
        btnMasFrijol.setBounds(270, 350, 40, 40);

        jLabel14.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Frijoles");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(150, 280, 160, 90);

        lblNoFrijoles.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        lblNoFrijoles.setForeground(new java.awt.Color(255, 255, 255));
        lblNoFrijoles.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNoFrijoles.setText("1400");
        jPanel1.add(lblNoFrijoles);
        lblNoFrijoles.setBounds(190, 350, 80, 40);

        btnCrearPartida.setBackground(new java.awt.Color(252, 252, 252));
        btnCrearPartida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearPartidaMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Crear");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearPartida.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.add(btnCrearPartida);
        btnCrearPartida.setBounds(320, 440, 230, 60);

        btnMenosFichas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMenosFichas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/menos.png"))); // NOI18N
        btnMenosFichas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenosFichas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMenosFichasMousePressed(evt);
            }
        });
        jPanel1.add(btnMenosFichas);
        btnMenosFichas.setBounds(550, 350, 40, 40);

        lblNoFichas.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        lblNoFichas.setForeground(new java.awt.Color(255, 255, 255));
        lblNoFichas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNoFichas.setText("4");
        jPanel1.add(lblNoFichas);
        lblNoFichas.setBounds(600, 350, 80, 40);

        btnMasFichas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMasFichas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/mas.png"))); // NOI18N
        btnMasFichas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMasFichas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMasFichasMousePressed(evt);
            }
        });
        jPanel1.add(btnMasFichas);
        btnMasFichas.setBounds(680, 350, 40, 40);

        jLabel15.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Fichas");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(560, 280, 160, 90);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/fondo2.jpg"))); // NOI18N
        jPanel1.add(fondo);
        fondo.setBounds(0, 0, 904, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMasJugadorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMasJugadorMousePressed
        int noJugadores = Integer.parseInt(lblNoJugadores.getText());
        if (noJugadores<4) {
            lblNoJugadores.setText("" + (noJugadores+1));
        }
    }//GEN-LAST:event_btnMasJugadorMousePressed

    private void btnCrearPartidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearPartidaMouseClicked

    }//GEN-LAST:event_btnCrearPartidaMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        objMainPanel.agregarFrmMenu();
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btnMenosJugadorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenosJugadorMousePressed
        int noJugadores = Integer.parseInt(lblNoJugadores.getText());
        if (noJugadores>2) {
            lblNoJugadores.setText("" + (noJugadores-1));
        }
    }//GEN-LAST:event_btnMenosJugadorMousePressed

    private void btnMenosAspaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenosAspaMousePressed
        int noCasillasAspa = Integer.parseInt(lblNoCasillasAspa.getText());
        if (noCasillasAspa>8) {
            lblNoCasillasAspa.setText("" + (noCasillasAspa-2));
            lblNoFrijoles.setText(""+getFrijolesMinMax()[1]);
        }
    }//GEN-LAST:event_btnMenosAspaMousePressed

    private void btnMasAspaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMasAspaMousePressed
        int noCasillasAspa = Integer.parseInt(lblNoCasillasAspa.getText());
        if (noCasillasAspa<14) {
            lblNoCasillasAspa.setText("" + (noCasillasAspa+2));
            lblNoFrijoles.setText(""+getFrijolesMinMax()[1]);
        }
    }//GEN-LAST:event_btnMasAspaMousePressed

    private void btnMenosFrijolMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenosFrijolMousePressed
        int noFrijoles = Integer.parseInt(lblNoFrijoles.getText());
        if(noFrijoles > getFrijolesMinMax()[0]){
            lblNoFrijoles.setText(""+(noFrijoles - 100));
        }
    }//GEN-LAST:event_btnMenosFrijolMousePressed

    private void btnMasFrijolMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMasFrijolMousePressed
        int noFrijoles = Integer.parseInt(lblNoFrijoles.getText());
        if(noFrijoles < getFrijolesMinMax()[2]){
            lblNoFrijoles.setText(""+(noFrijoles + 100));
        }
    }//GEN-LAST:event_btnMasFrijolMousePressed

    private void btnMenosFichasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenosFichasMousePressed
        int noFichas = Integer.parseInt(lblNoFichas.getText());
        if (noFichas > 2) {
            lblNoFichas.setText(""+(noFichas-1));
            lblNoFrijoles.setText(""+getFrijolesMinMax()[1]);
        }
    }//GEN-LAST:event_btnMenosFichasMousePressed

    private void btnMasFichasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMasFichasMousePressed
        int noFichas = Integer.parseInt(lblNoFichas.getText());
        if (noFichas < 6) {
            lblNoFichas.setText(""+(noFichas+1));
            lblNoFrijoles.setText(""+getFrijolesMinMax()[1]);
        }
    }//GEN-LAST:event_btnMasFichasMousePressed

    public void iniciarServer(){
        Server objServer = new Server(12345);

        if (objServer.isPortAvailable()) {
            Thread server = new Thread(objServer);
            server.start();
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Ya se encuentra una sala creada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public int[] getFrijolesMinMax(){
        int noCasillasTot = Integer.parseInt(lblNoCasillasAspa.getText()) * 4 + 4;
        int noFichas = Integer.parseInt(lblNoFichas.getText())+1;
        int variable = 100*noFichas;
        int extra = 400;                 
        int min = (noCasillasTot / 3 * variable) + extra;
        int med = ((int)Math.floor(noCasillasTot / 2.5) * variable) + extra;
        int max = (noCasillasTot / 2 * variable) + extra;
        int[] vals = {min, med, max};
        return vals;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private recursos.PanelBorder btnCrearPartida;
    private javax.swing.JLabel btnMasAspa;
    private javax.swing.JLabel btnMasFichas;
    private javax.swing.JLabel btnMasFrijol;
    private javax.swing.JLabel btnMasJugador;
    private javax.swing.JLabel btnMenosAspa;
    private javax.swing.JLabel btnMenosFichas;
    private javax.swing.JLabel btnMenosFrijol;
    private javax.swing.JLabel btnMenosJugador;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNoCasillasAspa;
    private javax.swing.JLabel lblNoFichas;
    private javax.swing.JLabel lblNoFrijoles;
    private javax.swing.JLabel lblNoJugadores;
    // End of variables declaration//GEN-END:variables
}
