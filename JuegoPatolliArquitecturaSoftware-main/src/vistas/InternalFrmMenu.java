package vistas;

public class InternalFrmMenu extends javax.swing.JInternalFrame {

    FrmMainPanel objMainPanel;

    public InternalFrmMenu(FrmMainPanel objMainPanel) {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

        this.objMainPanel = objMainPanel;

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnFrmCrearPartida = new recursos.PanelBorder();
        jLabel5 = new javax.swing.JLabel();
        panelBorder2 = new recursos.PanelBorder();
        jLabel4 = new javax.swing.JLabel();
        panelBorder3 = new recursos.PanelBorder();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setMaximumSize(new java.awt.Dimension(904, 600));
        setMinimumSize(new java.awt.Dimension(904, 600));
        setPreferredSize(new java.awt.Dimension(904, 600));

        jPanel1.setMaximumSize(new java.awt.Dimension(904, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(904, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(904, 600));
        jPanel1.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/patolli.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(310, 20, 264, 216);

        btnFrmCrearPartida.setBackground(new java.awt.Color(255, 204, 153));
        btnFrmCrearPartida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFrmCrearPartidaMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Crear Partida");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFrmCrearPartida.add(jLabel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(btnFrmCrearPartida);
        btnFrmCrearPartida.setBounds(370, 260, 174, 66);

        panelBorder2.setBackground(new java.awt.Color(255, 204, 153));
        panelBorder2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBorder2MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Unirse a Partida");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelBorder2.add(jLabel4, java.awt.BorderLayout.CENTER);

        jPanel1.add(panelBorder2);
        panelBorder2.setBounds(370, 350, 174, 66);

        panelBorder3.setBackground(new java.awt.Color(255, 204, 153));
        panelBorder3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBorder3MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Salir del Juego");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelBorder3.add(jLabel3, java.awt.BorderLayout.CENTER);

        jPanel1.add(panelBorder3);
        panelBorder3.setBounds(370, 440, 174, 66);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 904, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFrmCrearPartidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFrmCrearPartidaMouseClicked
        objMainPanel.agregarInternalFrmCrearPartida();
    }//GEN-LAST:event_btnFrmCrearPartidaMouseClicked

    private void panelBorder3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBorder3MouseClicked
        objMainPanel.dispose();
    }//GEN-LAST:event_panelBorder3MouseClicked

    private void panelBorder2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBorder2MouseClicked
        objMainPanel.agregarInternalFrmUnirsePartida("Player");
    }//GEN-LAST:event_panelBorder2MouseClicked

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private recursos.PanelBorder btnFrmCrearPartida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private recursos.PanelBorder panelBorder2;
    private recursos.PanelBorder panelBorder3;
    // End of variables declaration//GEN-END:variables
}
