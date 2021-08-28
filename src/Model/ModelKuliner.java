/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import umkm.Kuliner;
import umkm.koneksi;

/**
 *
 * @author Reza
 */
public class ModelKuliner extends barang {
    @Override
    public void simpan(){
        String query = "INSERT INTO kuliner VALUES ("+"'"+id+"',"+"'"+nama+"',"+"'"+size+"',"+"'"+harga+"',"+"'"+status+"'"+")";
        JOptionPane.showMessageDialog(null,query);
        try {
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Kuliner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void update(){
        try {
             koneksi db = new koneksi();
             stm = (Statement) db.getConnection().createStatement();
             String query = "UPDATE kuliner SET nama_kuliner = '"+nama+"', harga='"+harga+"', size='"+size+"', status_kuliner='"+status+"' WHERE id_kuliner='"+id+"' ";
             stm.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "data berhasil di update");
             
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "gagal! "+e.getMessage());
        }
    }
    @Override
    public void delete(){
        String query = "DELETE FROM kuliner WHERE id_kuliner = '"+id+"'";
            try {
                stm.executeUpdate(query);
            } catch (SQLException ex) {
                Logger.getLogger(Kuliner.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
