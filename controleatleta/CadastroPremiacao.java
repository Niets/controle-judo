package controleatleta;

import javax.swing.JOptionPane;

public class CadastroPremiacao extends javax.swing.JDialog {

    private Premiacao premiacao;

    public Premiacao getPremiacao() {
        return premiacao;
    }

    public CadastroPremiacao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCancelar = new javax.swing.JButton();
        jButtonAdicionar = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jLabelAno = new javax.swing.JLabel();
        jTextFieldAno = new javax.swing.JTextField();
        jLabelFaixa = new javax.swing.JLabel();
        jLabelMedalha = new javax.swing.JLabel();
        jComboBoxMedalha = new javax.swing.JComboBox();
        jComboBoxFaixa = new javax.swing.JComboBox();

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jLabelTitulo.setText("Titulo:");

        jLabelAno.setText("Ano:");

        jLabelFaixa.setText("Faixa:");

        jLabelMedalha.setText("Medalha:");

        jComboBoxMedalha.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ouro", "Prata", "Bronze"}));

        jComboBoxFaixa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Branca", "Cinza", "Azul", "Amarela", "Laranja", "Verde", "Roxa", "Marrom", "Preta"}));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo)
                    .addComponent(jLabelAno)
                    .addComponent(jLabelFaixa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabelMedalha))
                            .addComponent(jComboBoxFaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jButtonAdicionar)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonCancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxMedalha, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldTitulo)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitulo)
                    .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAno)
                    .addComponent(jTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedalha)
                    .addComponent(jComboBoxMedalha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFaixa)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonAdicionar)
                    .addComponent(jComboBoxFaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
    try {
        Integer.parseInt(jTextFieldAno.getText());
    } catch (Exception e) {
        this.exibirInformacao("O valor do campo 'Ano' é inválido.");
        jTextFieldAno.requestFocus();
        return;
    }
    
    premiacao = new Premiacao(jTextFieldTitulo.getText(), Integer.parseInt(jTextFieldAno.getText()));
    this.setVisible(false);
    
    switch (jComboBoxMedalha.getSelectedIndex()) {
            case 0:
                premiacao.setMedalha("Ouro");
                break;
                
            case 1:
                premiacao.setMedalha("Prata");
                break;
                
            case 2:
                premiacao.setMedalha("Bronze");
                break;
    }   
    
    switch (jComboBoxFaixa.getSelectedIndex()) {
            case 0:
                premiacao.setFaixa("Branca");
                break;
                
            case 1:
                premiacao.setFaixa("Cinza");
                break;
                
            case 2:
                premiacao.setFaixa("Azul");
                break;
                
            case 3:
                premiacao.setFaixa("Amarela");
                break;
                
            case 4:
                premiacao.setFaixa("Laranja");
                break;
                
            case 5:
                premiacao.setFaixa("Verde");
                break;
                
            case 6:
                premiacao.setFaixa("Roxa");
                break;
                
            case 7:
                premiacao.setFaixa("Marrom");
                break;
            
            case 8:
                premiacao.setFaixa("Preta");
            break;
    }
}//GEN-LAST:event_jButtonAdicionarActionPerformed

private void exibirInformacao(String info) {
    JOptionPane.showMessageDialog(this, info, "Atenção", JOptionPane.INFORMATION_MESSAGE);
}

private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
    this.setVisible(false);
}//GEN-LAST:event_jButtonCancelarActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(CadastroPremiacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroPremiacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroPremiacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroPremiacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                
                CadastroPremiacao dialog = new CadastroPremiacao(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JComboBox jComboBoxFaixa;
    private javax.swing.JComboBox jComboBoxMedalha;
    private javax.swing.JLabel jLabelAno;
    private javax.swing.JLabel jLabelFaixa;
    private javax.swing.JLabel jLabelMedalha;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JTextField jTextFieldAno;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables
}
