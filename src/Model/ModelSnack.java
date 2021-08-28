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
import umkm.Snack;
import umkm.koneksi;

/**
 *
 * @author Reza
 */
public class ModelSnack extends barang{
    @Override
    public void simpan(){
        String query = "INSERT INTO snack VALUES ("+"'"+id+"',"+"'"+nama+"',"+"'"+size+"',"+"'"+harga+"',"+"'"+status+"'"+")";
        JOptionPane.showMessageDialog(null,query);
        try {
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Snack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void update(){
        try {
             koneksi db = new koneksi();
             stm = (Statement) db.getConnection().createStatement();
             String query = "UPDATE snack SET nama_snack = '"+nama+"', harga='"+harga+"', size='"+size+"', status_snack='"+status+"' WHERE id_snack='"+id+"' ";
             stm.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "data berhasil di update");
             
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "gagal! "+e.getMessage());
        }
    }
    @Override
    public void delete(){
        String query = "DELETE FROM snack WHERE id_snack = '"+id+"'";
            try {
                stm.executeUpdate(query);
            } catch (SQLException ex) {
                Logger.getLogger(Snack.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
