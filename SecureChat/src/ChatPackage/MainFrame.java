package ChatPackage;

import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import UtilsPackage.*;

public class MainFrame extends javax.swing.JFrame {
    private Connection conn;
    private int maxid;
    

    public MainFrame() {
        initComponents();
        conn = DBConnection.openConnection("certificates", "root", "");
        maxid = CertificatesQueries.getMaxId(conn);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleLabel = new javax.swing.JLabel();
        ServerButton = new javax.swing.JButton();
        ClientButton = new javax.swing.JButton();
        AddressTextField = new javax.swing.JTextField();
        PortTextField = new javax.swing.JTextField();
        IPLabel = new javax.swing.JLabel();
        PortLabel = new javax.swing.JLabel();
        MyCertLabel = new javax.swing.JLabel();
        SenderTextField = new javax.swing.JTextField();
        RecCertLabel = new javax.swing.JLabel();
        ReciverTextField = new javax.swing.JTextField();
        ErrorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleLabel.setText("Setup menu");

        ServerButton.setText("SERVER");
        ServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServerButtonActionPerformed(evt);
            }
        });

        ClientButton.setText("CLIENT");
        ClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientButtonActionPerformed(evt);
            }
        });

        AddressTextField.setText("127.0.0.1");

        PortTextField.setText("5000");
        PortTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PortTextFieldActionPerformed(evt);
            }
        });

        IPLabel.setText("Insert IP address");

        PortLabel.setText("Insert port number");

        MyCertLabel.setText("My certificate ID");

        SenderTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SenderTextFieldActionPerformed(evt);
            }
        });

        RecCertLabel.setText("Reciver certificate ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(IPLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RecCertLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ErrorLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ReciverTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddressTextField)
                            .addComponent(PortTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ServerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(TitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(SenderTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(MyCertLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PortLabel, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(67, 67, 67))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ServerButton)
                    .addComponent(ClientButton))
                .addGap(3, 3, 3)
                .addComponent(IPLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PortLabel)
                .addGap(8, 8, 8)
                .addComponent(PortTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MyCertLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SenderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RecCertLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ReciverTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ServerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServerButtonActionPerformed

        try {
            if (!AddressTextField.getText().isEmpty() && !PortTextField.getText().isEmpty() && validIP(AddressTextField.getText()) && !SenderTextField.getText().isEmpty() && !ReciverTextField.getText().isEmpty() && Integer.parseInt(SenderTextField.getText())<maxid+1 && Integer.parseInt(ReciverTextField.getText())<maxid+1){
                ErrorLabel.setText("");
            new ChatFrame(true, AddressTextField.getText(), Integer.parseInt(PortTextField.getText()),SenderTextField.getText(),ReciverTextField.getText()).setVisible(true);
            this.dispose();
            }
            else {
            ErrorLabel.setText("ALL OF THE PARAMETERS HAVE TO BE INSERTED AND HAVE TO BE VALID");
        }
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_ServerButtonActionPerformed

    private void ClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientButtonActionPerformed
        // TODO add your handling code here:
        try {
            if (!AddressTextField.getText().isEmpty() && !PortTextField.getText().isEmpty() && validIP(AddressTextField.getText())&& !SenderTextField.getText().isEmpty() && !ReciverTextField.getText().isEmpty() && Integer.parseInt(SenderTextField.getText())<maxid+1 && Integer.parseInt(ReciverTextField.getText())<maxid+1){
                ErrorLabel.setText("");
            new ChatFrame(false, AddressTextField.getText(), Integer.parseInt(PortTextField.getText()),SenderTextField.getText(),ReciverTextField.getText()).setVisible(true);
             this.dispose();
            }
            else {
            ErrorLabel.setText("ALL OF THE PARAMETERS HAVE TO BE INSERTED AND HAVE TO BE VALID");
        }
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ClientButtonActionPerformed

    private void PortTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PortTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PortTextFieldActionPerformed

    private void SenderTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SenderTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SenderTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
     public static boolean validIP(String ip) {
        try {
            if (ip == null || ip.isEmpty()) {
                return false;
            }

            String[] parts = ip.split("\\.");
            if (parts.length != 4) {
                return false;
            }

            for (String s : parts) {
                int i = Integer.parseInt(s);
                if ((i < 0) || (i > 255)) {
                    return false;
                }
            }
            if (ip.endsWith(".")) {
                return false;
            }

            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddressTextField;
    private javax.swing.JButton ClientButton;
    private javax.swing.JLabel ErrorLabel;
    private javax.swing.JLabel IPLabel;
    private javax.swing.JLabel MyCertLabel;
    private javax.swing.JLabel PortLabel;
    private javax.swing.JTextField PortTextField;
    private javax.swing.JLabel RecCertLabel;
    private javax.swing.JTextField ReciverTextField;
    private javax.swing.JTextField SenderTextField;
    private javax.swing.JButton ServerButton;
    private javax.swing.JLabel TitleLabel;
    // End of variables declaration//GEN-END:variables
}
