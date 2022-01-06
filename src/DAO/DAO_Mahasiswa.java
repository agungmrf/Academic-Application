/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.varMahasiswa;
import java.util.List;
import Koneksi.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Agung Ma'ruf
 */
public class DAO_Mahasiswa implements DAO_Interface<varMahasiswa>{
    public DAO_Mahasiswa(){
    connection = Database.KoneksiDB();
    }
    
    //Deklarasi SQL statement
    Connection connection;
    String INSERT = "INSERT INTO mahasiswa(NIM, Nama, Alamat) VALUES(?,?,?)";
    String UPDATE = "UPDATE mahasiswa SET Nama=?, Alamat=? WHERE NIM=?";
    String DELETE = "DELETE FROM mahasiswa WHERE NIM=?";
    String SELECT = "SELECT * FROM mahasiswa";
    String CARI   = "SELECT * FROM mahasiswa WHERE NIM LIKE ?";
    
    @Override
    public void insert(varMahasiswa Object) {
        PreparedStatement st = null;
        try{
            st = connection.prepareStatement(CARI);
            st.setString(1, Object.getvNIM());
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                JOptionPane.showMessageDialog(null, "Data sudah pernah di simpan");
            }
            else {
                st = null;
                st = connection.prepareStatement(INSERT);
                st.setString(1, Object.getvNIM());
                st.setString(2, Object.getvNama());
                st.setString(3, Object.getvAlamat());
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil di simpan");
            }
            st.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(varMahasiswa Object) {
        PreparedStatement st = null;
        try{
            st = null;
            st = connection.prepareStatement(UPDATE);
            st.setString(1, Object.getvNama());
            st.setString(2, Object.getvAlamat());
            st.setString(3, Object.getvNIM());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil di ubah");
            st.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String nim) {
       PreparedStatement st = null;
       try{
           st = null;
           st = connection.prepareStatement(DELETE);
           st.setString(1, nim);
           st.executeUpdate();
           JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
           st.close();
       }
       catch(Exception e){
           e.printStackTrace();
       }
    }

    @Override
    public List<varMahasiswa> getAll() {
        List<varMahasiswa> list = null;
        PreparedStatement st = null;
        try{
            st = null;
            list = new ArrayList<varMahasiswa>();
            st = connection.prepareStatement(SELECT);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                varMahasiswa objMhs = new varMahasiswa();
                objMhs.setvNIM(rs.getString("NIM"));
                objMhs.setvNama(rs.getString("Nama"));
                objMhs.setvAlamat(rs.getString("Alamat"));
                list.add(objMhs);
            }
            st.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<varMahasiswa> getCari(String key) {
        List<varMahasiswa> list = null;
        PreparedStatement st = null;
        try{
            list = new ArrayList<varMahasiswa>();
            st = connection.prepareStatement(CARI);
            st.setString(1,  "%"+key+"%");
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                varMahasiswa objMhs = new varMahasiswa();
                objMhs.setvNIM(rs.getString("NIM"));
                objMhs.setvNama(rs.getString("Nama"));
                objMhs.setvAlamat(rs.getString("Alamat"));
                list.add(objMhs);
            }
            st.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
}
