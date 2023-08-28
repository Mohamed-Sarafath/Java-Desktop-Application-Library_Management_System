
package source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;




public class ManageStudents extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    String studentName,course;
    int studentID,year;
    DefaultTableModel model;
    private Object Dconnection;
    
    public ManageStudents() {
        initComponents();
        setStudentDetailsToTable();
    }
    
    //to set book details into the table
    
    public void setStudentDetailsToTable(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system","root","");
            
            Statement stmnt=con.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from student_details");
            
            while (rs.next()) {
               String StudentID = rs.getString("student_id");
               String StudentName= rs.getString("name");
               String Course= rs.getString("course");
               String Year= rs.getString("year");
               
               Object[] obj = { StudentID,StudentName,Course,Year};
               model =(DefaultTableModel) tbl_Student.getModel();
               
               model.addRow(obj);
               
               
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
        
    }
    
    //to add student to student_details table
    public boolean addStudent(){
        
        boolean isAdded=false;
        
        studentID=Integer.parseInt(txt_studentID.getText());
        studentName=txt_studentName.getText();
        course=combo_course.getSelectedItem().toString();
        year = Integer.parseInt(combo_year.getSelectedItem().toString());
        
        
        try {
         Class.forName("com.mysql.jdbc.Driver"); 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system","root","");
            
            String sql = "INSERT INTO student_details (student_id, name, course, year) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);

            
            pst.setInt(1, studentID);
            pst.setString(2, studentName);
            pst.setString(3, course);
            pst.setInt(4, year);
            
            int rowCount= pst.executeUpdate();
            
            if (rowCount>0) {
                isAdded=true;
                
            }else{
                isAdded=false;
                JOptionPane.showMessageDialog(this, "Field empty");
            }
            
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdded;
        
    }
    
    //method to clear table
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_Student.getModel();
        model.setRowCount(0);
    }
    
    //to update book details
    public boolean updateStudent(){
        
        boolean isUpdated=false;
        
        studentID=Integer.parseInt(txt_studentID.getText());
        studentName=txt_studentName.getText();
        course=combo_course.getSelectedItem().toString();
        year = Integer.parseInt(combo_year.getSelectedItem().toString());
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system","root","");
            
            String sql = "UPDATE student_details SET name=?, course=?, year=? WHERE student_id=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, studentName);
            pst.setString(2, course);
            pst.setInt(3, year);
            pst.setInt(4, studentID);
            
           int rowCount= pst.executeUpdate();
           if (rowCount>0) {
                isUpdated=true;
                
            }else{
                isUpdated=false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }
    
    public boolean deleteStudent(){
        
        boolean isDeleted=false;
        
        studentID=Integer.parseInt(txt_studentID.getText()); 
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system","root","");
            
            String sql = "DELETE from student_details WHERE student_id=? ";
            PreparedStatement pst = con.prepareStatement(sql);
  
            pst.setInt(1, studentID);
            
           int rowCount= pst.executeUpdate();
           if (rowCount>0) {
                isDeleted=true;
                
            }else{
                isDeleted=false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted;
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
        jLabel7 = new javax.swing.JLabel();
        txt_studentID = new app.bolivia.swing.JCTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_studentName = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btn_DeleteBook = new rojerusan.RSMaterialButtonCircle();
        btn_AddBook = new rojerusan.RSMaterialButtonCircle();
        btn_UpdateBook = new rojerusan.RSMaterialButtonCircle();
        backLbl = new javax.swing.JLabel();
        combo_year = new javax.swing.JComboBox<>();
        combo_course = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lbl_close = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Student = new rojeru_san.complementos.RSTableMetro();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Student ID");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 160, -1));

        txt_studentID.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentID.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_studentID.setPlaceholder("Enter Student ID...");
        txt_studentID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_studentIDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIDFocusLost(evt);
            }
        });
        txt_studentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIDActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 330, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 50, 50));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Student Name");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 160, -1));

        txt_studentName.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentName.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_studentName.setPlaceholder("Enter Student Name...");
        txt_studentName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_studentNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentNameFocusLost(evt);
            }
        });
        txt_studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 330, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 50, 50));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Select Course");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 160, -1));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 50, 50));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Select Year");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 160, -1));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 50, 50));

        btn_DeleteBook.setBackground(new java.awt.Color(255, 0, 0));
        btn_DeleteBook.setText("Delete");
        btn_DeleteBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteBookActionPerformed(evt);
            }
        });
        jPanel1.add(btn_DeleteBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 570, 120, 60));

        btn_AddBook.setBackground(new java.awt.Color(255, 0, 0));
        btn_AddBook.setText("Add");
        btn_AddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddBookActionPerformed(evt);
            }
        });
        jPanel1.add(btn_AddBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, 120, 60));

        btn_UpdateBook.setBackground(new java.awt.Color(255, 0, 0));
        btn_UpdateBook.setText("Update");
        btn_UpdateBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateBookActionPerformed(evt);
            }
        });
        jPanel1.add(btn_UpdateBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 570, 120, 60));

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

        combo_year.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        combo_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2021", "2020", "2019", "2018" }));
        jPanel1.add(combo_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 330, 30));

        combo_course.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        combo_course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HNDIT", "HNDA", "HNDE" }));
        jPanel1.add(combo_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 330, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 770));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_close.setBackground(new java.awt.Color(255, 0, 0));
        lbl_close.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lbl_close.setForeground(new java.awt.Color(255, 255, 255));
        lbl_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_window_40px_1.png"))); // NOI18N
        lbl_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_closeMouseClicked(evt);
            }
        });
        jPanel4.add(lbl_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 30));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 70, 30));

        tbl_Student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Course", "Year"
            }
        ));
        tbl_Student.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_Student.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_Student.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_Student.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_Student.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_Student.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_Student.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_Student.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_Student.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_Student.setRowHeight(30);
        tbl_Student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_StudentMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_Student);
        if (tbl_Student.getColumnModel().getColumnCount() > 0) {
            tbl_Student.getColumnModel().getColumn(0).setResizable(false);
            tbl_Student.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 760, 260));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_student_male_52px.png"))); // NOI18N
        jLabel1.setText("Manage Students");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 290, 70));

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 360, 5));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 850, 770));

        setBounds(0, 0, 1366, 768);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_studentIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIDFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIDFocusGained

    private void txt_studentIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIDFocusLost

    }//GEN-LAST:event_txt_studentIDFocusLost

    private void txt_studentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIDActionPerformed

    private void txt_studentNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameFocusGained

    private void txt_studentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentNameFocusLost

    }//GEN-LAST:event_txt_studentNameFocusLost

    private void txt_studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameActionPerformed

    private void btn_DeleteBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteBookActionPerformed
       if (deleteStudent()==true) {
            //JOptionPane.showMessageDialog(this, "Student Deleted");
            clearTable();
            setStudentDetailsToTable();
            
        }else{
             //JOptionPane.showMessageDialog(this, "Student Deletion Failed");
        }
    }//GEN-LAST:event_btn_DeleteBookActionPerformed

    private void btn_AddBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddBookActionPerformed
        if (addStudent()==true) {
            //JOptionPane.showMessageDialog(this, "Student Added");
            clearTable();
            setStudentDetailsToTable();
            
        }else{
            //JOptionPane.showMessageDialog(this, "Student Addition Failed");
        }
    }//GEN-LAST:event_btn_AddBookActionPerformed

    private void btn_UpdateBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateBookActionPerformed
        if (updateStudent()==true) {
           //JOptionPane.showMessageDialog(this, "Student Updated");
            clearTable();
            setStudentDetailsToTable();
            
        }else{
            //JOptionPane.showMessageDialog(this, "Student Udating Failed");
        }
    }//GEN-LAST:event_btn_UpdateBookActionPerformed

    private void lbl_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseClicked
     System.exit(0);
    }//GEN-LAST:event_lbl_closeMouseClicked

    private void backLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backLblMouseClicked
        HomePage home=new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_backLblMouseClicked

    private void tbl_StudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_StudentMouseClicked
        int rowNo = tbl_Student.getSelectedRow();
        TableModel model= tbl_Student.getModel();
        
        txt_studentID.setText(model.getValueAt(rowNo, 0).toString());
        txt_studentName.setText(model.getValueAt(rowNo, 1).toString());
        combo_course.setSelectedItem(model.getValueAt(rowNo, 2).toString());
        combo_year.setSelectedItem(model.getValueAt(rowNo, 3).toString());
        
    }//GEN-LAST:event_tbl_StudentMouseClicked

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
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backLbl;
    private rojerusan.RSMaterialButtonCircle btn_AddBook;
    private rojerusan.RSMaterialButtonCircle btn_DeleteBook;
    private rojerusan.RSMaterialButtonCircle btn_UpdateBook;
    private javax.swing.JComboBox<String> combo_course;
    private javax.swing.JComboBox<String> combo_year;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_close;
    private rojeru_san.complementos.RSTableMetro tbl_Student;
    private app.bolivia.swing.JCTextField txt_studentID;
    private app.bolivia.swing.JCTextField txt_studentName;
    // End of variables declaration//GEN-END:variables
}
