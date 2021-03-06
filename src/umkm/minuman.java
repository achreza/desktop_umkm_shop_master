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

public class minuman extends javax.swing.JFrame {

    /**
     * Creates new form minuman
     */
    Statement stm;
    String idlevel;
    public minuman(String level) throws SQLException{
        initComponents();
        koneksi con = new koneksi();
        stm = (Statement) con.getConnection().createStatement();
        this.idlevel = level;
        if(idlevel.equals("2")){
            
            jMenu1.setVisible(false);
        }
        
        this.selectMinuman(); 
    }
    
    public void selectMinuman() throws SQLException{
        String query = "select * from minuman";
        ResultSet rs = stm.executeQuery(query);
        while(rs.next()){
            this.insertTable(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
        }
    }
    
    public void insertTable(String id, String nama, String harga, String status){
        DefaultTableModel model = (DefaultTableModel) tbminuman.getModel();
        model.addRow(new Object[] {id,nama,harga,status});
    }
    
    public void resetTable(){
        DefaultTableModel model = (DefaultTableModel) tbminuman.getModel();
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
        tfidminuma = new javax.swing.JTextField();
        tfnama = new javax.swing.JTextField();
        tfharga = new javax.swing.JTextField();
        cbstatus = new javax.swing.JComboBox<>();
        btnsimpan = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbminuman = new javax.swing.JTable();
        tfcari = new javax.swing.JTextField();
        btncari = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Minuman");

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("X");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addGap(112, 112, 112))
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfidminuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfidminumaActionPerformed(evt);
            }
        });
        jPanel2.add(tfidminuma, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 78, 195, 29));

        tfnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnamaActionPerformed(evt);
            }
        });
        jPanel2.add(tfnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 138, 195, 29));

        tfharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfhargaActionPerformed(evt);
            }
        });
        jPanel2.add(tfharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 206, 195, 29));

        cbstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "tersedia", "tidak tersedia" }));
        cbstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbstatusActionPerformed(evt);
            }
        });
        jPanel2.add(cbstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 253, 117, 28));

        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        jPanel2.add(btnsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 299, 77, -1));

        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });
        jPanel2.add(btnreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 299, 73, -1));

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        jPanel2.add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 346, -1, -1));

        btnedit.setText("edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        jPanel2.add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 346, 73, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Id Minuman");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 54, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 116, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Harga");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 183, -1, -1));

        tbminuman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Minuman", "Nama Minuman", "Harga", "Status"
            }
        ));
        tbminuman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbminumanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbminuman);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 42, -1, 274));
        jPanel2.add(tfcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 346, 169, 28));

        btncari.setText("Cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });
        jPanel2.add(btncari, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 346, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\AVITA\\OneDrive\\Desktop\\LOGIN2.png")); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -90, 740, 550));

        jMenu1.setText("Master");

        jMenuItem1.setText("Makanan");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Minuman");
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
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Transaksi");

        jMenuItem4.setText("Pemesanan");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem5.setText("Pembayaran");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(734, 545));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfidminumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfidminumaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfidminumaActionPerformed

    private void tfnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfnamaActionPerformed

    private void tfhargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfhargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfhargaActionPerformed

    private void cbstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbstatusActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        String id = tfidminuma.getText();
        String nama = tfnama.getText();
        String harga = tfharga.getText();
        String status = (String) cbstatus.getSelectedItem();
        
        String query = "INSERT INTO minuman VALUES ("+"'"+id+"',"+"'"+nama+"',"+"'"+harga+"',"+"'"+status+"'"+")";
        JOptionPane.showMessageDialog(null,query);
        try {
            stm.executeUpdate(query);
            this.insertTable(id,nama,harga,status);
            this.resetText();
        } catch (SQLException ex) {
            Logger.getLogger(minuman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void tbminumanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbminumanMouseClicked
        // TODO add your handling code here:
        int row = tbminuman.rowAtPoint(evt.getPoint());
        String id = tbminuman.getValueAt(row, 0).toString();
        String nama = tbminuman.getValueAt(row, 1).toString();
        String harga = tbminuman.getValueAt(row, 2).toString();
        String status = tbminuman.getValueAt(row, 3).toString();
        tfidminuma.setEditable(false);
        tfidminuma.setText(id);
        tfnama.setText(nama);
        tfharga.setText(harga);
        cbstatus.setSelectedItem(status);
    }//GEN-LAST:event_tbminumanMouseClicked

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        tfidminuma.setEditable(true);
        tfidminuma.setText("");
        tfnama.setText("");
        tfharga.setText("");
        cbstatus.setSelectedItem("tersedia");
    }//GEN-LAST:event_btnresetActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            // TODO add your handling code here:
            new menu(idlevel).show();
            new menu(idlevel).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(minuman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            // TODO add your handling code here:
            new user(idlevel).show();
            new user(idlevel).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(minuman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        String id = tfidminuma.getText();
        String nama = tfnama.getText();
        String harga = tfharga.getText();
        String status = (String) cbstatus.getSelectedItem();
       
        
        try {
             koneksi db = new koneksi();
             stm = (Statement) db.getConnection().createStatement();
             String query = "UPDATE minuman SET nama_minuman = '"+nama+"', harga='"+harga+"', status_minuman='"+status+"' WHERE id_minuman='"+id+"' ";
             stm.executeUpdate(query);
             JOptionPane.showConfirmDialog(null, "data berhasil di update");
             menu m = new menu(idlevel);
             m.setVisible(true);
             this.dispose();
             
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "gagal! "+e.getMessage());
        }
    }//GEN-LAST:event_btneditActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        String id = tfidminuma.getText();
        int confirmed = JOptionPane.showConfirmDialog(this, "Yakin menghapus?", "ya",JOptionPane.YES_NO_OPTION);
        if (confirmed == JOptionPane.YES_OPTION){
            String query = "DELETE FROM minuman WHERE id_minuman = '"+id+"'";
            try {
                stm.executeUpdate(query);
                this.resetText();
                this.resetTable();
                this.selectMinuman();
            } catch (SQLException ex) {
                Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        // TODO add your handling code here:
          DefaultTableModel tabelmodel = new DefaultTableModel();
        tabelmodel.addColumn("id_minuman");
        tabelmodel.addColumn("nama_minuman");
        tabelmodel.addColumn("harga");
        tabelmodel.addColumn("status");
        String kode = tfcari.getText();
        String query = "select * from minuman where nama_minuman like '%"+kode+"%'";
        
        try {
            stm.executeQuery(query);
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                tabelmodel.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)});
            }
            tbminuman.setModel(tabelmodel);
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
            new transaksi(idlevel).show();
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
    
        private void resetText(){
        tfidminuma.setEditable(true);
        tfidminuma.setText("");
        tfnama.setText("");
        tfharga.setText("");
        cbstatus.setSelectedItem("Tersedia");
    }
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
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
    private javax.swing.JTable tbminuman;
    private javax.swing.JTextField tfcari;
    private javax.swing.JTextField tfharga;
    private javax.swing.JTextField tfidminuma;
    private javax.swing.JTextField tfnama;
    // End of variables declaration//GEN-END:variables
}
