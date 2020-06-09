package ChatPackage;

import ServerPackage.Server;
import ClientPackage.Client;
import RSAPackage.RSAKey;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Timer;
import java.util.TimerTask;
import UtilsPackage.*;
import java.io.UnsupportedEncodingException;

public class ChatFrame extends javax.swing.JFrame implements Runnable {

    Server Server = null;
    Client Client = null;
    RSAKey Sender = null;
    RSAKey Reciver = null;
    Connection conn;

    boolean isServer = false;

    Timer refreshTimer = new Timer(true);

    public ChatFrame(boolean Server, String address, int port, String senderid, String reciverid ) throws IOException {
        initComponents();
        conn = DBConnection.openConnection("certificates", "root", "");
        String[] tmp = CertificatesQueries.getPrivateKey(conn, senderid).split(";",2);
        Sender = new RSAKey(tmp[0].replaceAll(" ", ""),tmp[1].replaceAll(" ", ""));
        tmp =  CertificatesQueries.getPublicKey(conn, reciverid).split(";",2);
        Reciver = new RSAKey(tmp[0].replaceAll(" ", ""),tmp[1].replaceAll(" ", ""));
        if (Server) {
            isServer = true;
            try {
                this.Server = new Server(address, port, 1);
            } catch (Exception ex) {
                Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            isServer = false;
            Client = new Client(address, port);
        }

        MainLabel.setText(isServer ? "SERVER" : "CLIENT");

        refreshTimer.schedule(new refreshTask(), 1000, 500);
    }

    public ChatFrame() {
        initComponents();
    }

    private class refreshTask extends TimerTask {

        private void refresh() {
            String line = "";
            DecryptedMessage DM;
            if (isServer) {
                try {
                    if ((line = Server.read()) != null) {
                        LastRecivedTextArea.setText(line);
                        DM= new DecryptedMessage(line,Reciver,Sender);
                        ChatTextArea.append("CLIENT: " + DM.DecryptedMessage + "\n");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    if ((line = Client.read()) != null) {
                        LastRecivedTextArea.setText(line);
                        DM= new DecryptedMessage(line,Reciver,Sender);
                        ChatTextArea.append("SERVER: " + DM.DecryptedMessage + "\n");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        @Override
        public void run() {
            refresh();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainLabel = new javax.swing.JLabel();
        TextField = new javax.swing.JTextField();
        SendButton = new javax.swing.JButton();
        ChatScrollPane = new javax.swing.JScrollPane();
        ChatTextArea = new javax.swing.JTextArea();
        LastSentScrollPane = new javax.swing.JScrollPane();
        LastSentTextArea = new javax.swing.JTextArea();
        LastRecivedScrollPane = new javax.swing.JScrollPane();
        LastRecivedTextArea = new javax.swing.JTextArea();
        LastSentLabel = new javax.swing.JLabel();
        LastRecivedLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MainLabel.setText("CHAT");

        SendButton.setText("SEND");
        SendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendButtonActionPerformed(evt);
            }
        });

        ChatTextArea.setEditable(false);
        ChatTextArea.setColumns(20);
        ChatTextArea.setRows(5);
        ChatScrollPane.setViewportView(ChatTextArea);

        LastSentTextArea.setColumns(20);
        LastSentTextArea.setRows(5);
        LastSentScrollPane.setViewportView(LastSentTextArea);

        LastRecivedTextArea.setColumns(20);
        LastRecivedTextArea.setRows(5);
        LastRecivedScrollPane.setViewportView(LastRecivedTextArea);

        LastSentLabel.setText("Last message sent");

        LastRecivedLabel.setText("Last message recived");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ChatScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(MainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(249, 249, 249))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LastSentScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LastSentLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LastRecivedScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LastRecivedLabel))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChatScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SendButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LastSentLabel)
                    .addComponent(LastRecivedLabel))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LastRecivedScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(LastSentScrollPane))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendButtonActionPerformed
        // TODO add your handling code here:
        String cleartext;
        EncryptedMessage EM;
        if (isServer) {
            try {
                cleartext = TextField.getText();
                EM = new EncryptedMessage(cleartext,Sender,Reciver);
                Server.write(EM.EncryptedMessage);
                LastSentTextArea.setText(EM.EncryptedMessage);
                ChatTextArea.append("SERVER: " + cleartext + "\n");
                TextField.setText("");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                cleartext = TextField.getText();
                EM = new EncryptedMessage(cleartext,Sender,Reciver);
                Client.write(EM.EncryptedMessage);
                LastSentTextArea.setText(EM.EncryptedMessage);
                ChatTextArea.append("CLIENT: " + cleartext + "\n");
                TextField.setText("");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_SendButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ChatScrollPane;
    private javax.swing.JTextArea ChatTextArea;
    private javax.swing.JLabel LastRecivedLabel;
    private javax.swing.JScrollPane LastRecivedScrollPane;
    private javax.swing.JTextArea LastRecivedTextArea;
    private javax.swing.JLabel LastSentLabel;
    private javax.swing.JScrollPane LastSentScrollPane;
    private javax.swing.JTextArea LastSentTextArea;
    private javax.swing.JLabel MainLabel;
    private javax.swing.JButton SendButton;
    private javax.swing.JTextField TextField;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        System.out.println("New Chat Frame");
    }
}
