/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

//import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class ViewAllRecords extends javax.swing.JFrame {

    /**
     * Creates new form ViewAllRecords
     */
    
   // Color mouseEnterColor = new Color(255,255,255); //white
    //Color mouseExitColor = new Color(51,51,51);
    
     DefaultTableModel model;
    public ViewAllRecords() {
        initComponents();
        setIssueBookDetailsToTable();
    }
    
    //to set book details into the table
    
    public void setIssueBookDetailsToTable(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system","root","");
            
            Statement stmnt=con.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from issue_book_details");
            
            while (rs.next()) {
               String Id = rs.getString("id");
               String BookName = rs.getString("book_name");
               String StudentName= rs.getString("student_name");
               String IssueDate= rs.getString("issue_date");
               String DueDate= rs.getString("due_date");
               String Status = rs.getString("status");  
               
               Object[] obj = { Id,BookName,StudentName,IssueDate,DueDate,Status};
               model =(DefaultTableModel) tbl_allRecord.getModel();
               model.addRow(obj);
               
               
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
        
    }
    
    //method to clear table
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_allRecord.getModel();
        model.setRowCount(0);
    }
    
    // To fetch the record using date field
    public void search(){
        
        Date uFromDate = date_fromDate.getDatoFecha();
        Date uToDate = date_toDate.getDatoFecha();
        
        long l1 = uFromDate.getTime();
        long l2 = uToDate.getTime();
        
        java.sql.Date fromDate = new java.sql.Date(l1);
        java.sql.Date toDate = new java.sql.Date(l2);
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system","root","");
            String sql = "SELECT * FROM issue_book_details WHERE issue_date BETWEEN ? AND ? AND due_date BETWEEN ? AND ?";

            
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, fromDate);
            pst.setDate(2, toDate);
            pst.setDate(3, fromDate);
            pst.setDate(4, toDate);
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()==false) {
                
                JOptionPane.showMessageDialog(this, "No Record Found");
                
            }else{
                
                //while (rs.next()) {
                
                model =(DefaultTableModel) tbl_allRecord.getModel();
                
                do{
                    
               String Id = rs.getString("id");
               String BookName = rs.getString("book_name");
               String StudentName= rs.getString("student_name");
               String IssueDate= rs.getString("issue_date");
               String DueDate= rs.getString("due_date");
               String Status = rs.getString("status");  
               
               Object[] obj = { Id,BookName,StudentName,IssueDate,DueDate,Status};
              
               
               model.addRow(obj);
              
            }while (rs.next());
                
            }
            rs.close();
    pst.close();
    con.close();
             
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        date_fromDate = new rojeru_san.componentes.RSDateChooser();
        date_toDate = new rojeru_san.componentes.RSDateChooser();
        btn_search = new rojerusan.RSMaterialButtonCircle();
        backLbl = new javax.swing.JLabel();
        lbl_close = new javax.swing.JLabel();
        lbl_refresh = new javax.swing.JLabel();
        panel_Table = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_allRecord = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_book_and_pencil_52px_1.png"))); // NOI18N
        jLabel1.setText("View All Records");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 260, 60));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 310, 5));

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Due Date :");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 110, 30));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Issue Date :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 120, 30));

        date_fromDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_fromDate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_fromDate.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        date_fromDate.setPlaceholder("Select Issue Date...");
        jPanel1.add(date_fromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 270, 30));

        date_toDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_toDate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_toDate.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        date_toDate.setPlaceholder("Select Due Date...");
        jPanel1.add(date_toDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 180, 270, 30));

        btn_search.setBackground(new java.awt.Color(255, 0, 0));
        btn_search.setText("Search");
        btn_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_searchMouseClicked(evt);
            }
        });
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        jPanel1.add(btn_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 170, 150, 50));

        backLbl.setBackground(new java.awt.Color(255, 0, 0));
        backLbl.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        backLbl.setForeground(new java.awt.Color(255, 255, 255));
        backLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_back_to_40px.png"))); // NOI18N
        backLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backLblMouseClicked(evt);
            }
        });
        jPanel1.add(backLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, -1));

        lbl_close.setBackground(new java.awt.Color(255, 0, 0));
        lbl_close.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lbl_close.setForeground(new java.awt.Color(255, 255, 255));
        lbl_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_window_40px_1.png"))); // NOI18N
        lbl_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_closeMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 0, 40, 30));

        lbl_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_refresh_40px.png"))); // NOI18N
        lbl_refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_refreshMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_refreshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_refreshMouseExited(evt);
            }
        });
        jPanel1.add(lbl_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 170, 40, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 260));

        panel_Table.setBackground(new java.awt.Color(255, 255, 255));
        panel_Table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_allRecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book Name", "Student Name", "Issue Date", "Due Date", "Status"
            }
        ));
        tbl_allRecord.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_allRecord.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_allRecord.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_allRecord.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_allRecord.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_allRecord.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_allRecord.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_allRecord.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_allRecord.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_allRecord.setRowHeight(30);
        tbl_allRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_allRecordMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_allRecord);

        panel_Table.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 1060, 350));

        getContentPane().add(panel_Table, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 1370, 510));

        setSize(new java.awt.Dimension(1370, 770));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        if (date_fromDate.getDatoFecha() != null && date_toDate.getDatoFecha() != null) {
            clearTable();
            search();
        }else{
            JOptionPane.showMessageDialog(this, "Please select a date");
        }
      
    }//GEN-LAST:event_btn_searchActionPerformed

    private void tbl_allRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_allRecordMouseClicked
       
    }//GEN-LAST:event_tbl_allRecordMouseClicked

    private void backLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backLblMouseClicked
        HomePage home=new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_backLblMouseClicked

    private void lbl_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lbl_closeMouseClicked

    private void lbl_refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_refreshMouseClicked
        clearTable();
        setIssueBookDetailsToTable();
    }//GEN-LAST:event_lbl_refreshMouseClicked

    private void lbl_refreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_refreshMouseEntered
        //lbl_refresh.setBackground(mouseEnterColor);
    }//GEN-LAST:event_lbl_refreshMouseEntered

    private void lbl_refreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_refreshMouseExited
       // lbl_refresh.setBackground(mouseExitColor);
    }//GEN-LAST:event_lbl_refreshMouseExited

    private void btn_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseClicked
        
    }//GEN-LAST:event_btn_searchMouseClicked

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
            java.util.logging.Logger.getLogger(ViewAllRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAllRecords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backLbl;
    private rojerusan.RSMaterialButtonCircle btn_search;
    private rojeru_san.componentes.RSDateChooser date_fromDate;
    private rojeru_san.componentes.RSDateChooser date_toDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_close;
    private javax.swing.JLabel lbl_refresh;
    private javax.swing.JPanel panel_Table;
    private rojeru_san.complementos.RSTableMetro tbl_allRecord;
    // End of variables declaration//GEN-END:variables
}
