    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umkm;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class user extends javax.swing.JFrame {

    /**
     * Creates new form user
     */
    Statement stm;
    String idlevel;
    public user(String level) throws SQLException{
        initComponents();
        koneksi con = new koneksi();
        stm = (Statement) con.getConnection().createStatement();
        this.idlevel = level;
        if(idlevel.equals("2")){
            
            jMenu1.setVisible(false);
        }
        this.selectUser();
    }
    
        public void selectUser() throws SQLException{
        String query = "SELECT *FROM user";
        ResultSet rs;
        
        try {
            
        rs = stm.executeQuery(query);
         
           
            while(rs.next()){
                String status;
                if(rs.getString (5).equals("1")){
                    status = "Manager";
                }else{
                    status = "Kasir";
                }
                this.insertTable(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),status);
            }
            
        }
        catch(SQLException ex){
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
    public void insertTable(String id,String username,String password,String nama, String status){
        DefaultTableModel model = (DefaultTableModel) tbuser.getModel();
        model.addRow(new Object[]{id,nama,username,password,status});
    }
    public void resetTable(){
        DefaultTableModel model = (DefaultTableModel) tbuser.getModel();
        model.setRowCount(0);
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
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tfnama = new javax.swing.JTextField();
        tfiduser = new javax.swing.JTextField();
        tfpass = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbstatus = new javax.swing.JComboBox<>();
        btnsimpan = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbuser = new javax.swing.JTable();
        tfnamauser = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfcari = new javax.swing.JTextField();
        btncari = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User");

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("X");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 348, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnamaActionPerformed(evt);
            }
        });
        jPanel2.add(tfnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 139, 195, 29));

        tfiduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfiduserActionPerformed(evt);
            }
        });
        jPanel2.add(tfiduser, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 81, 195, 29));

        tfpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfpassActionPerformed(evt);
            }
        });
        jPanel2.add(tfpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 201, 195, 29));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Id User");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 58, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 115, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 177, -1, -1));

        cbstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Kasir" }));
        cbstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbstatusActionPerformed(evt);
            }
        });
        jPanel2.add(cbstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 316, 117, 28));

        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        jPanel2.add(btnsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 358, 77, -1));

        btnreset.setText("Reset");
        btnreset.setPreferredSize(new java.awt.Dimension(73, 23));
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });
        jPanel2.add(btnreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 361, -1, -1));

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        jPanel2.add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 430, -1, -1));

        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        jPanel2.add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 430, 73, -1));

        tbuser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id User", "Nama user", "Username", "Password", "Level"
            }
        ));
        tbuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbuserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbuser);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 29, -1, 262));
        jPanel2.add(tfnamauser, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 270, 195, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nama User");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 246, -1, -1));
        jPanel2.add(tfcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 309, 127, 28));

        btncari.setText("cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });
        jPanel2.add(btncari, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 309, 61, 31));
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(716, 358, 41, 54));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\AVITA\\OneDrive\\Desktop\\LOGIN2.png")); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 470));

        jMenu1.setText("Master");

        jMenuItem1.setText("Snack");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Kuliner");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem6.setText("Pakaian");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setText("Kerajinan");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem3.setText("User");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Transaksi");

        jMenuItem4.setText("Pemesanan");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Pembayaran");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(735, 569));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfnamaActionPerformed

    private void tfiduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfiduserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfiduserActionPerformed

    private void tfpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfpassActionPerformed

    private void cbstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbstatusActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        String id = tfiduser.getText();
        String nama = tfnama.getText();
        String username = tfnamauser.getText();
        String password = tfpass.getText();
        String status = (String) cbstatus.getSelectedItem();
        String level;
        if(status.equals("Manager")){
            level = "1";
        }else{
            level = "2";
        }
        
        String query = "INSERT INTO user VALUES ("
        +"'"+id+"',"
        +"'"+username+"',"
        +"'"+password+"',"
                +"'"+nama+"',"
        +"'"+level+"'"
        +")";
        JOptionPane.showMessageDialog(null,query);
        try {
            stm.executeUpdate(query);
            this.insertTable(id,username,password,nama,status);
            this.resetText();
        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        String id = tfiduser.getText();
        int confirmed = JOptionPane.showConfirmDialog(this,"Yakin menghapus ?", "ya",JOptionPane.YES_NO_OPTION);
        if(confirmed == JOptionPane.YES_OPTION){
            String query = "DELETE FROM user WHERE id_user ='"+id+"'";
            try {
                stm.executeUpdate(query);
                this.resetText();
                this.resetTable();
                this.selectUser();
            }
            catch (SQLException ex){
                Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void tbuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbuserMouseClicked
        // TODO add your handling code here:
        int row = tbuser.rowAtPoint (evt.getPoint());
        String id = tbuser.getValueAt(row , 0).toString();
        String nama = tbuser.getValueAt(row, 1).toString();
        String username = tbuser.getValueAt (row , 2).toString();
        String password = tbuser.getValueAt(row , 3).toString();
        String level = tbuser.getValueAt(row , 4).toString();
        tfiduser.setEditable(false);
        tfiduser.setText(id);
        tfnama.setText(nama);
        tfnamauser.setText(username);
        tfpass.setText(password);
        cbstatus.setSelectedItem(level);
    }//GEN-LAST:event_tbuserMouseClicked

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        tfiduser.setEditable(true);
        tfiduser.setText("");
        tfnama.setText("");
        tfnamauser.setText("");
        tfpass.setText("");
        cbstatus.setSelectedItem("Manager");
    }//GEN-LAST:event_btnresetActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        String id = tfiduser.getText();
        String nama = tfnama.getText();
        String username = tfnamauser.getText();
        String password = tfpass.getText();
        String status = (String) cbstatus.getSelectedItem();
        String level;
        if (status.equals("Manager")){
            level = "1";
        }else{
            level = "2";
        }

        String query = "UPDATE user"
        +" SET nama_user ='"+nama+"',"
        +"username ='"+username+"',"
        +"password ='"+password+"',"
        +"id_level ='"+level+"'"       
        +" Where id_user ='"+id+"'";

        JOptionPane.showMessageDialog(null, query);
        try {
            stm.executeUpdate(query);
            new user(idlevel).show();
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btneditActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            // TODO add your handling code here:
            new Snack(idlevel).show();
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            // TODO add your handling code here:
            new Kuliner(idlevel).show();
            new minuman(idlevel).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        // TODO add your handling code here:
          DefaultTableModel tabelmodel = new DefaultTableModel();
        tabelmodel.addColumn("id_user");
        tabelmodel.addColumn("username");
        tabelmodel.addColumn("password");
        tabelmodel.addColumn("nama_user");
        String kode = tfcari.getText();
        String query = "select * from user where username like '%"+kode+"%'";
        
        try {
            stm.executeQuery(query);
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                tabelmodel.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)});
            }
            tbuser.setModel(tabelmodel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error:"+e.getMessage());
        }
    }//GEN-LAST:event_btncariActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            new Pemesanan(idlevel).show();
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            new Pemesanan(idlevel).show();
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        try {
            // TODO add your handling code here:
            new Pakaian(idlevel).show();
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        try {
            // TODO add your handling code here:
            new Kerajinan(idlevel).show();
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncari;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JComboBox<String> cbstatus;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbuser;
    private javax.swing.JTextField tfcari;
    private javax.swing.JTextField tfiduser;
    private javax.swing.JTextField tfnama;
    private javax.swing.JTextField tfnamauser;
    private javax.swing.JTextField tfpass;
    // End of variables declaration//GEN-END:variables

    private void resetText() {
        tfiduser.setText("");
        tfnama.setText("");
        tfpass.setText("");
        tfnamauser.setText("");
    }

    private void insertTable(String id, String nama, String harga, String status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
