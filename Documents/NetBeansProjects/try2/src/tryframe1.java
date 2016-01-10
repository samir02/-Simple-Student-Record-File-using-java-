
import java.sql.*;
import javax.swing.JOptionPane;
public class tryframe1 extends javax.swing.JFrame {

   
    public tryframe1() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        text_name = new javax.swing.JTextField();
        text_collegename = new javax.swing.JTextField();
        text_email = new javax.swing.JTextField();
        text_password = new javax.swing.JPasswordField();
        text_submit = new javax.swing.JButton();
        text_retrive = new javax.swing.JButton();
        text_delete = new javax.swing.JButton();
        text_update = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(107, 117, 34, 0);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(141, 166, 0, 0);

        jLabel3.setForeground(new java.awt.Color(51, 255, 0));
        jLabel3.setText("College Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(28, 200, 65, 34);

        jLabel4.setForeground(new java.awt.Color(0, 255, 0));
        jLabel4.setText("Email");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(28, 245, 50, 34);

        jLabel5.setForeground(new java.awt.Color(51, 255, 51));
        jLabel5.setText("Name");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(28, 117, 43, 38);

        jLabel6.setForeground(new java.awt.Color(51, 255, 0));
        jLabel6.setText("Password");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(28, 161, 57, 33);
        getContentPane().add(text_name);
        text_name.setBounds(145, 126, 296, 20);
        getContentPane().add(text_collegename);
        text_collegename.setBounds(145, 200, 296, 20);
        getContentPane().add(text_email);
        text_email.setBounds(145, 245, 296, 20);
        getContentPane().add(text_password);
        text_password.setBounds(145, 166, 296, 20);

        text_submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1452271105_door_in.png"))); // NOI18N
        text_submit.setText("Submit");
        text_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_submitActionPerformed(evt);
            }
        });
        getContentPane().add(text_submit);
        text_submit.setBounds(80, 310, 110, 20);

        text_retrive.setText("Retrive");
        text_retrive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_retriveActionPerformed(evt);
            }
        });
        getContentPane().add(text_retrive);
        text_retrive.setBounds(315, 297, 126, 23);

        text_delete.setText("Delete");
        text_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_deleteActionPerformed(evt);
            }
        });
        getContentPane().add(text_delete);
        text_delete.setBounds(154, 338, 63, 23);

        text_update.setText("update");
        text_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_updateActionPerformed(evt);
            }
        });
        getContentPane().add(text_update);
        text_update.setBounds(299, 338, 67, 23);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("student record");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(150, 10, 232, 29);

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\SAMIR-PC\\Desktop\\New-Roof-School.jpg")); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 0, 580, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void text_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_submitActionPerformed
        String name = text_name.getText();
        String password = String.valueOf(text_password.getPassword());
        String collegename = text_collegename.getText();
        String email = text_email.getText();
        
        
        try {
            Connection conn=null ;
            PreparedStatement pstmt=null ;
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/try1","root","");
            pstmt=conn.prepareStatement("insert into try values(?,?,?,?)");
            pstmt.setString(1,name);
            pstmt.setString(2, password);                   
            pstmt.setString(3, collegename);
            pstmt.setString(4, email);
            int i=pstmt.executeUpdate();
            if(i>0){
            JOptionPane.showMessageDialog(null, "data is saved");
            }
            else{
             JOptionPane.showMessageDialog(null, "data is not saved");
            
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_text_submitActionPerformed

    private void text_retriveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_retriveActionPerformed
        
         String un = text_name.getText();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
             Class.forName("com.mysql.jdbc.Driver");
          
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/try1","root","");
          pstmt = conn.prepareStatement("select *from try where Name=?");
        
          pstmt.setString(1, un);
          rs=pstmt.executeQuery();
          
            while (rs.next()) {
                text_password.setText(rs.getString("Password"));
                text_name.setText(rs.getString("Name"));
                text_collegename.setText(rs.getString("College Name"));            
                text_email.setText(rs.getString("Email"));
                
                
            }
          
          
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try {
                conn.close();
                pstmt.close();
                rs.close();
                
            } catch (Exception e) {
                
            }
        
        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_text_retriveActionPerformed

    private void text_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_deleteActionPerformed
             Connection conn = null;
        PreparedStatement pstmt = null;       

        
        
        
        
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
          
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/try1","root","");
            pstmt = conn.prepareStatement("delete from try where Name=?");
            pstmt.setString(1,text_name.getText());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "deleated");
            
            
        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);

        }
        
        
        
        
    }//GEN-LAST:event_text_deleteActionPerformed

    private void text_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_updateActionPerformed

       String name = text_name.getText();
        String password = String.valueOf(text_password.getPassword());
        String collegename = text_collegename.getText();
        String email = text_email.getText(); 
        
        
         
        Connection conn = null;
        PreparedStatement pstmt = null; 
              
        try {
          
            Class.forName("com.mysql.jdbc.Driver");
          
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/try1","root","");
           
            String sql="UPDATE try SET Password='"+password+"',Email='"+email+"' WHERE Name ='"+name+"'";
        //try1 database  name.... try table name 
           pstmt=conn.prepareStatement(sql);
            
           
            pstmt.execute();
          
          
            
           
            JOptionPane.showMessageDialog(null, "updated");
            
            
        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);

        }
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_text_updateActionPerformed

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
            java.util.logging.Logger.getLogger(tryframe1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tryframe1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tryframe1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tryframe1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tryframe1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField text_collegename;
    private javax.swing.JButton text_delete;
    private javax.swing.JTextField text_email;
    private javax.swing.JTextField text_name;
    private javax.swing.JPasswordField text_password;
    private javax.swing.JButton text_retrive;
    private javax.swing.JButton text_submit;
    private javax.swing.JButton text_update;
    // End of variables declaration//GEN-END:variables
}
