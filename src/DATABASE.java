/**
 * @author Kelompok 2 - R6P
 */

import java.sql.*;
import javax.swing.*;

public class DATABASE {
    
    
    public static boolean login(String username, String password) {
        try {
            Connection conn = KONEKSI.getConnection();
            String sql = "SELECT * FROM user WHERE username=? AND password=?";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Selamat Datang " + rs.getString("full_name"));
                return true; 
            } else {
                JOptionPane.showMessageDialog(null, "LOGIN GAGAL");
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
//=================================================================================================================== 
    
    public static boolean register(String username, String password, String jabatan, String nama_lengkap) {
        try {
            Connection conn = KONEKSI.getConnection();
            String sql = "INSERT INTO user (username, password, role, full_name) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, jabatan);
            pst.setString(4, nama_lengkap);
            
            int hasil = pst.executeUpdate();
            
            if (hasil > 0) {
                return true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
//=================================================================================================================== 
    
    public static boolean stok_barang(String nama, String kategori, int jumlah) {
        try {
            Connection conn = KONEKSI.getConnection();
            String sql = "INSERT INTO barang (nama_barang, kategori, jumlah) VALUES (?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, nama);
            pst.setString(2, kategori);
            pst.setInt(3, jumlah);
            
            int hasil = pst.executeUpdate();
            
            if (hasil > 0) {
                return true; 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //========================================================================================================================
    
    public static boolean hapus_barang(String nama){
        try {
            
            String sql = "DELETE FROM barang WHERE nama_barang = ?";
            java.sql.Connection conn = KONEKSI.getConnection();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nama);
            
            int rowAffected = pst.executeUpdate();
            return rowAffected > 0;
        } catch (java.sql.SQLException e){
            System.out.println("Error Hapus: " + e.getMessage());
            return false;
        }
    }
    
    //================================================================================================
    public static boolean ubah_barang(String nama, String kategori, int jumlah){
        try{
            
            String sql = "UPDATE barang SET kategori = ? WHERE nama_barang = ?";
            java.sql.Connection conn =  KONEKSI.getConnection();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, kategori);
            pst.setInt(2, jumlah);
            pst.setString(3, nama);
            
            int rowAffected = pst.executeUpdate();
            return rowAffected > 0;
        } catch(java.sql.SQLException e){
            System.out.println("Error Update: " + e.getMessage());
            return false;
        }
    }
}

