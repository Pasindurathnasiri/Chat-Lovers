/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_pkg;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Pasindu
 */
public class chat_user1 extends javax.swing.JFrame {

    static Socket s;
    static DataInputStream dis;
    static DataOutputStream dout;
    
    
    /**
     * Creates new form chat_user1
     */
    public chat_user1() {
        initComponents();
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
        msg_area = new javax.swing.JTextArea();
        msg_text = new javax.swing.JTextField();
        send_u1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        msg_area.setColumns(20);
        msg_area.setRows(5);
        jScrollPane1.setViewportView(msg_area);

        msg_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_textActionPerformed(evt);
            }
        });

        send_u1.setText("Send");
        send_u1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_u1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("User 1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(msg_text, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(send_u1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msg_text, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send_u1))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void msg_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_msg_textActionPerformed

    private void send_u1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_u1ActionPerformed

        // TODO add your handling code here:
        String secretKey = "secrete";
        try {
             AESEncryptionDecryption Encmsg = new AESEncryptionDecryption();
            String msg ="";
            msg = msg_text.getText();
             String Enc_msg1 = Encmsg.encrypt(msg, secretKey);
             
            dout.writeUTF(Enc_msg1);
             System.out.println("User 1 Encrypted Msg: "+Enc_msg1);
            msg_text.setText("");
            
            
        } catch (Exception e) {
            //handle exception
        }
        
    }//GEN-LAST:event_send_u1ActionPerformed

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
            java.util.logging.Logger.getLogger(chat_user1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chat_user1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chat_user1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chat_user1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chat_user1().setVisible(true);
            }
        });
        String secretKey  = "secrete";
        
        try{
        String msg1in="";
        
        AESEncryptionDecryption Encmsg = new AESEncryptionDecryption();
        s = new Socket("127.0.0.1",1201); // ip address is pf localhost
        dis = new DataInputStream(s.getInputStream());     
        dout= new DataOutputStream(s.getOutputStream());
        
        while(!msg1in.equals("exit")){
           
            msg1in = dis.readUTF();
            String Dec_msg2 = Encmsg.decrypt(msg1in, secretKey);
            msg_area.setText(msg_area.getText()+"\n user 1 : "+Dec_msg2);
            
        }
        
        }catch(Exception e){
            //handle the exeptions here
        }
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea msg_area;
    private javax.swing.JTextField msg_text;
    private javax.swing.JButton send_u1;
    // End of variables declaration//GEN-END:variables
}
