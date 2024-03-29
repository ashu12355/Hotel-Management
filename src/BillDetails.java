
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class BillDetails extends javax.swing.JFrame {

    /**
     * Creates new form BillDetails
     */
    Connection con =null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    static String id;
    
    public BillDetails() {
        initComponents();
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels","root","root");
            
         } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ManageRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
         Data2();
        
    }
    public void Data2() {
        try {
            pst=con.prepareStatement("select * from customer where status=?");
            pst.setString(1,"check-out");
            rs=pst.executeQuery();
            ResultSetMetaData ob = rs.getMetaData();
            int n = ob.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) table2.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v = new Vector();
                for(int i=1;i<=n;i++){
                v.add(rs.getString("billid")); 
                v.add(rs.getString("roomnumber"));
                v.add(rs.getString("name"));
                v.add(rs.getString("mobile"));
                v.add(rs.getString("address"));
                v.add(rs.getString("email"));
                v.add(rs.getString("id"));
                v.add(rs.getString("indate"));
                v.add(rs.getString("outdate"));
                v.add(rs.getString("price"));
                v.add(rs.getString("day"));
                v.add(rs.getString("amount"));  
            }
                df.addRow(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtoutdate = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bill.png"))); // NOI18N
        jLabel1.setText("CUSTOMER BILL DETAILS ");
        jLabel1.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 33, 230, 60));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search By Check Out Date:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 132, -1, 27));

        txtoutdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtoutdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 132, 112, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 132, -1, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(661, 132, -1, -1));

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Bill ID", "Room No.", "Customer Name", "Mobile No", "Address", "Email", "Adhar No", "Check In Date", "Check Out Date", "Amount", "No. Of Days", "Total Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 960, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close (1).png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(913, 0, 37, 32));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mangeroom  bg.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 690));

        setBounds(250, 55, 960, 690);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            pst=con.prepareStatement("select * from customer where status=? and outdate");
            pst.setString(1,"check-out");
            pst.setString(2,txtoutdate.getText());
            rs=pst.executeQuery();
            ResultSetMetaData ob = rs.getMetaData();
            int n = ob.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) table2.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v = new Vector();
                for(int i=1;i<=n;i++){
                v.add(rs.getString("billid")); 
                v.add(rs.getString("roomnumber"));
                v.add(rs.getString("name"));
                v.add(rs.getString("mobile"));
                v.add(rs.getString("address"));
                v.add(rs.getString("email"));
                v.add(rs.getString("id"));
                v.add(rs.getString("indate"));
                v.add(rs.getString("outdate"));
                v.add(rs.getString("price"));
                v.add(rs.getString("day"));
                v.add(rs.getString("amount"));
                
            }
                df.addRow(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Data2();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
        if(evt.getClickCount()== 2){
            DefaultTableModel df = (DefaultTableModel) table2.getModel();
            id=(String) df.getValueAt(table2.getSelectedRow(),0);
            new PrintBill().setVisible(true);
        }
    }//GEN-LAST:event_table2MouseClicked

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
            java.util.logging.Logger.getLogger(BillDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table2;
    private javax.swing.JTextField txtoutdate;
    // End of variables declaration//GEN-END:variables
}
