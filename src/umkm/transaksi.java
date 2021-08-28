/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umkm;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class transaksi extends javax.swing.JFrame {

    /**
     * Creates new form transaksi
     */
    Statement stm;
    String idlevel;
    String idTrans,idLevell,idOrder,tanggal,bayar;
    String idtransaksi,jumlah;
    public transaksi(String level) throws SQLException {
        initComponents();
        koneksi con = new koneksi();
        stm = (Statement) con.getConnection().createStatement();
        this.idlevel = level;
        if(idlevel.equals("2")){
            
            jMenu1.setVisible(false);
        }
        
        this.selectdetailorder();
        
        
        
    }
    
  
    
    public void selectdetailorder() throws SQLException{
        String query = "select * from detail_order";
        ResultSet rs = stm.executeQuery(query);
        while(rs.next()){
            this.insertTable(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
        }
    }
    
    public void gawestruk() throws SQLException{
        String query = "select pakaian.nama_pakaian,pakaian.harga,detail_order.jumlah from pakaian INNER join detail_order where detail_order.id_order = "+tfidorder.getText()+" && detail_order.id_pakaian = pakaian.id_pakaian;";
        ResultSet rs = stm.executeQuery(query);
        while(rs.next()){
            this.printStrukPakaian(rs.getString(1),rs.getString(2),rs.getString(3));
        }
        String query2 = "select kerajinan.nama_kerajinan,kerajinan.harga,detail_order.jumlah from kerajinan INNER join detail_order where detail_order.id_order = "+tfidorder.getText()+"  && detail_order.id_kerajinan = kerajinan.id_kerajinan;";
        ResultSet rs2 = stm.executeQuery(query2);
        while(rs2.next()){
            this.printStrukKerajinan(rs2.getString(1),rs2.getString(2),rs2.getString(3));
        }
        String query3 = "select kuliner.nama_kuliner,kuliner.harga,detail_order.jumlah from kuliner INNER join detail_order where detail_order.id_order = "+tfidorder.getText()+"  && detail_order.id_kuliner = kuliner.id_kuliner;";
        ResultSet rs3 = stm.executeQuery(query3);
        while(rs3.next()){
            this.printStrukKuliner(rs3.getString(1),rs3.getString(2),rs3.getString(3));
        }
        String query4 = "select snack.nama_snack,snack.harga,detail_order.jumlah from snack INNER join detail_order where detail_order.id_order = "+tfidorder.getText()+"  && detail_order.id_snack = snackwes.id_snack;";
        ResultSet rs4 = stm.executeQuery(query4);
        while(rs4.next()){
            this.printStrukSnack(rs4.getString(1),rs4.getString(2),rs4.getString(3));
        }
    }
    
    public void printStrukPakaian(String nama,String harga,String jumlah){
         DefaultTableModel model = (DefaultTableModel) hargapakaian.getModel();
        model.addRow(new Object[] {nama,harga,this.jumlah});
        
        int pakaian = hargapakaian.getRowCount();
        if (pakaian == 0){
            struk.append("");
        }else{
            if(pakaian >= 2){
                
            for (int i = 0;i < pakaian-1;i++){
                struk.append("\n"+nama+"\t"+harga+"\t"+jumlah);
            }
        }else{
               for (int i = 0;i < pakaian;i++){
                struk.append("\n"+nama+"\t"+harga+"\t"+jumlah);
            }
            }
            
        }
        
        
    }
    public void printStrukKuliner(String nama,String harga,String jumlah){
         DefaultTableModel model = (DefaultTableModel) hargakuliner.getModel();
        model.addRow(new Object[] {nama,harga,this.jumlah});
        
        int kuliner = hargakuliner.getRowCount();
        if (kuliner == 0){
            struk.append("");
        }else{
            if(kuliner >= 2){
            for (int i = 0;i < kuliner-1;i++){
            struk.append("\n"+nama+"\t"+harga+"\t"+jumlah);
        } 
            }else{
            for (int i = 0;i < kuliner;i++){
            struk.append("\n"+nama+"\t"+harga+"\t"+jumlah);
        }
            
            }
            
        }
        
        
    }
    public void printStrukKerajinan(String nama,String harga,String jumlah){
         DefaultTableModel model = (DefaultTableModel) hargakerajinan.getModel();
        model.addRow(new Object[] {nama,harga,this.jumlah});
        
        int kerajinan = hargakerajinan.getRowCount();
        if (kerajinan == 0){
            struk.append("");
        }else{
            if(kerajinan >= 2){
            for (int i = 0;i < kerajinan-1;i++){
            struk.append("\n"+nama+"\t"+harga+"\t"+jumlah);
        } 
            }else{
            for (int i = 0;i < kerajinan;i++){
            struk.append("\n"+nama+"\t"+harga+"\t"+jumlah);
        }
            
            }
            
        }
        
        
    }
    public void printStrukSnack(String nama,String harga,String jumlah){
         DefaultTableModel model = (DefaultTableModel) hargasnack.getModel();
        model.addRow(new Object[] {nama,harga,this.jumlah});
        
        int snack = hargasnack.getRowCount();
        if (snack == 0){
            struk.append("");
        }else{
            if(snack >= 2){
            for (int i = 0;i < snack-1;i++){
            struk.append("\n"+nama+"\t"+harga+"\t"+jumlah);
        } 
            }else{
            for (int i = 0;i < snack;i++){
            struk.append("\n"+nama+"\t"+harga+"\t"+jumlah);
        }
            
            }
            
        }
        
        
    }
        
    public void insertTable(String kodeorder, String tanggal , String idpakaian, String idkerajinan, String idkuliner, String idsnack, String jumlah, String harga,String keterangan){
        DefaultTableModel model = (DefaultTableModel) tbbayar.getModel();
        model.addRow(new Object[] {kodeorder,tanggal,idpakaian,idkerajinan,idkuliner,idsnack,jumlah,harga,keterangan});
        
    }
    
    public void selectdetailorder2() throws SQLException{
        
        
        String query = "select * from transaksi where id_transaksi = "+idtransaksi+"";
        ResultSet rs = stm.executeQuery(query);
        while(rs.next()){
            this.ambiltrans(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
        }
    }
        
    public void ambiltrans(String idtrans,String idlevel,String idorder, String tanggal, String bayar){
        idTrans = idtrans;
        idLevell = idlevel;
        idOrder = idorder;
        this.tanggal = tanggal;
        this.bayar = bayar;
    }
    
        public void resetTable(){
        DefaultTableModel model = (DefaultTableModel) tbbayar.getModel();
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
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbbayar = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfbayar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        totalbayar = new javax.swing.JLabel();
        tfidorder = new javax.swing.JLabel();
        tfkembali = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        struk = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        hargapakaian = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        hargakerajinan = new javax.swing.JTable();
        btnCetak = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        hargakuliner = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        hargasnack = new javax.swing.JTable();
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

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("X");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pembayaran");

        tbbayar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Order", "id Order", "Id Pakaian", "Id Kerajinan", "Id Kuliner", "Id Snack", "Keterangan", "Status", "Jumlah"
            }
        ));
        tbbayar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbbayarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbbayar);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Id Order");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Bayar");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kembali :");

        jButton1.setText("BAYAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tfidorder.setBackground(new java.awt.Color(0, 204, 204));
        tfidorder.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tfidorder.setForeground(new java.awt.Color(102, 255, 102));
        tfidorder.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tfidorder.setEnabled(false);
        tfidorder.setOpaque(true);

        struk.setColumns(20);
        struk.setRows(5);
        jScrollPane2.setViewportView(struk);

        hargapakaian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nama", "harga", "Jumlah"
            }
        ));
        jScrollPane3.setViewportView(hargapakaian);

        hargakerajinan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nama", "harga", "Jumlah"
            }
        ));
        jScrollPane4.setViewportView(hargakerajinan);

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        hargakuliner.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nama", "harga", "Jumlah"
            }
        ));
        jScrollPane5.setViewportView(hargakuliner);

        hargasnack.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nama", "harga", "Jumlah"
            }
        ));
        jScrollPane6.setViewportView(hargasnack);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfbayar, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(tfidorder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(111, 111, 111)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfkembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(totalbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(781, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(58, 58, 58)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(791, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(48, 48, 48)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfidorder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(totalbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(27, 27, 27))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(511, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(501, Short.MAX_VALUE)))
        );

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
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbbayarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbayarMouseClicked
        try {
            this.selectdetailorder2();
        } catch (SQLException ex) {
            Logger.getLogger(transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int row = tbbayar.rowAtPoint(evt.getPoint());
        
        String idorder = tbbayar.getValueAt(row, 1).toString();
        String id = tbbayar.getValueAt(row, 0).toString();
        String nama = tbbayar.getValueAt(row, 1).toString();
        String harga = this.bayar;
        String tanggal = this.bayar;
        String status = tbbayar.getValueAt(row, 3).toString();
        String jumlah = tbbayar.getValueAt(row, 6).toString();
        this.idtransaksi = idorder;
        this.jumlah = jumlah;
        
        
        
        tfidorder.setText(idorder);
        totalbayar.setText(harga);
        

    }//GEN-LAST:event_tbbayarMouseClicked

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
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            new Kuliner(idlevel).show();
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(minuman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            // TODO add your handling code here:
            new user(idlevel).show();
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(minuman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int bayar = Integer.parseInt(tfbayar.getText());
        int total = Integer.parseInt(totalbayar.getText());
        if (bayar < total){
            JOptionPane.showMessageDialog(jMenu1, "Uang anda Kurang");
        }else{
        int hasil = bayar - total;
        
        
        String shasil = Integer.toString(hasil);
        
        tfkembali.setText(shasil);
        struk.append("=============SALAMERTA SHOP=============\n"
                + "\nNama\tHarga\tJumlah\n"
                );
        try {
            this.gawestruk();
        } catch (SQLException ex) {
            Logger.getLogger(transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        struk.append("\n=======================================\nTotal Harga\t: "+total+"\n"
                + "Total Bayar\t: "+bayar+"\n"
                + "Kembali\t: "+shasil+""
                + "\n\nTerimakasih Sudah Berkunjung di Toko Kami"); 
        }
        
        String query = "DELETE FROM orderan WHERE id_order = '"+tfidorder.getText()+"'";
        String query2 = "DELETE FROM detail_order WHERE id_order = '"+tfidorder.getText()+"'";
        String query3 = "DELETE FROM transaksi WHERE id_order = '"+tfidorder.getText()+"'";
            try {
                stm.executeUpdate(query);
                stm.executeUpdate(query2);
                stm.executeUpdate(query3);
                
                this.resetTable();
                this.selectdetailorder();
            } catch (SQLException ex) {
                Logger.getLogger(transaksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        try {
            struk.print();
        } catch (PrinterException ex) {
            Logger.getLogger(transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCetakActionPerformed

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
    private javax.swing.JButton btnCetak;
    private javax.swing.JTable hargakerajinan;
    private javax.swing.JTable hargakuliner;
    private javax.swing.JTable hargapakaian;
    private javax.swing.JTable hargasnack;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea struk;
    private javax.swing.JTable tbbayar;
    private javax.swing.JTextField tfbayar;
    private javax.swing.JLabel tfidorder;
    private javax.swing.JLabel tfkembali;
    private javax.swing.JLabel totalbayar;
    // End of variables declaration//GEN-END:variables
}
