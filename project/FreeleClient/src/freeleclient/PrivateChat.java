/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freeleclient;

import java.awt.event.KeyEvent;
import java.io.PrintWriter;

/**
 *
 * @author Vetle
 */
public class PrivateChat extends javax.swing.JFrame {

    private PrintWriter writer;
    private String targetName;
    private String ownName;
    /**
     * Creates new form PrivateChat
     */
    public PrivateChat() {
        initComponents();
    }
    
    public PrivateChat(String targetName, PrintWriter writer, String ownName) {
        initComponents();
        privUsername.setText(targetName);
        this.targetName = targetName;
        this.writer = writer;
        this.ownName = ownName;
    }
    
    public void print(String message){
        privChatArea.append(message);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        privChatArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        privInputField = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        privUsername = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        privChatArea.setEditable(false);
        privChatArea.setColumns(20);
        privChatArea.setRows(5);
        jScrollPane1.setViewportView(privChatArea);

        privInputField.setColumns(20);
        privInputField.setRows(5);
        privInputField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                privInputFieldFocusGained(evt);
            }
        });
        privInputField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                privInputFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                privInputFieldKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(privInputField);

        jLabel3.setText("Speaking to:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(privUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(privUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void privInputFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_privInputFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_privInputFieldFocusGained

    private void privInputFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_privInputFieldKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String n = "";
            if((privInputField.getText()).equals(n)) {
                privInputField.setText("");
                privInputField.requestFocus();
            } else {
                try {
                    writer.println(targetName + "β" + privInputField.getText() + "βPrivate" + "β" + ownName);
                    privChatArea.append(ownName + ": " + privInputField.getText() + "\n");
                    writer.flush();
                } catch(Exception e){
                    privChatArea.append("Error in sending message. \n");
                }
                privInputField.setText("");
                privInputField.requestFocus();
            }
            privInputField.setText(null);
            privInputField.requestFocus();
        }
    }//GEN-LAST:event_privInputFieldKeyPressed

    private void privInputFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_privInputFieldKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            privInputField.setText(null);              
        }
    }//GEN-LAST:event_privInputFieldKeyReleased

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
            java.util.logging.Logger.getLogger(PrivateChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrivateChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrivateChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrivateChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrivateChat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea privChatArea;
    private javax.swing.JTextArea privInputField;
    private javax.swing.JLabel privUsername;
    // End of variables declaration//GEN-END:variables
}
