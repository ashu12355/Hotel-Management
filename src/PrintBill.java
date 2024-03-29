import java.awt.print.PrinterException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class PrintBill extends javax.swing.JFrame {

    /**
     * Creates new form PrintBill
     */
    String id = BillDetails.id;
    String name , mobile , email , roomnumber , bed ,roomtype ,indate ,outdate ,price ,day , amount;
    
    
    public PrintBill() {
        initComponents();
        Connect();
        txtbill.setText("\t\t-: Gauri Hotel :-\n");
        txtbill.setText(txtbill.getText()+"**********************************************************************************\n");
        txtbill.setText(txtbill.getText()+"Bill ID:- "+id+"\n");
        txtbill.setText(txtbill.getText()+"Customer Details:- \n");
        txtbill.setText(txtbill.getText()+"Name:- "+name+"\n");
        txtbill.setText(txtbill.getText()+"Mobile Number:- "+mobile+"\n");
        txtbill.setText(txtbill.getText()+"Email:- "+email+"\n");
        txtbill.setText(txtbill.getText()+"**********************************************************************************\n");
        txtbill.setText(txtbill.getText()+"Room Details:- \n");
        txtbill.setText(txtbill.getText()+"Room Number:- "+roomnumber+"\n");
        txtbill.setText(txtbill.getText()+"Type:- "+roomtype+"\n");
        txtbill.setText(txtbill.getText()+"Bed:- "+bed+"\n");
        txtbill.setText(txtbill.getText()+"Price:- "+price+"\n");
        txtbill.setText(txtbill.getText()+"Check IN Date="+indate+"\t\tNumber of Days="+day+"\n");
        txtbill.setText(txtbill.getText()+"Check OUT Date="+outdate+"\t\tTotal Amount="+amount+"\n");
        txtbill.setText(txtbill.getText()+"**********************************************************************************\n");
        txtbill.setText(txtbill.getText()+"\t\t"+"                    Thank You,Visit Us Again.");
    }
public void Connect(){
    PreparedStatement pst;
    ResultSet rs;
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels","root","root");
            pst=con.prepareStatement("select * from customer where billid=?");
            pst.setString(1,id);
            rs=pst.executeQuery();
            if(rs.next()){
                email=rs.getString("email");
                name=rs.getString("name");
                mobile=rs.getString("mobile");
                roomnumber=rs.getString("roomnumber");
                bed=rs.getString("bed");
                roomtype=rs.getString("roomtype");
                indate=rs.getString("indate");
                outdate=rs.getString("outdate");
                price=rs.getString("price");
                day=rs.getString("day");
                amount=rs.getString("amount");
            }  
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PrintBill.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        txtbill = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtbill.setEditable(false);
        txtbill.setColumns(20);
        txtbill.setRows(5);
        jScrollPane1.setViewportView(txtbill);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 53, 470, 390));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("PRINT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, -1, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("CANCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close (1).png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 40, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mangeroom  bg.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            txtbill.print();
        } catch (PrinterException ex) {
            Logger.getLogger(PrintBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(PrintBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrintBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtbill;
    // End of variables declaration//GEN-END:variables
}
