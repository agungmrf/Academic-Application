/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Koneksi.Database;
import Model.varMatakuliah;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Agung Ma'ruf
 */
public class DAO_Matakuliah implements DAO_Interface<varMatakuliah>{
    public DAO_Matakuliah(){
        connection = Database.KoneksiDB();
    }
    
    Connection connection;
    String INSERT = "INSERT INTO matakuliah(KodeMTK, NamaMTK, SKS, KodePrasyarat) VALUES(?,?,?,?)";
    String UPDATE = "UPDATE matakuliah SET NamaMTK=?, SKS=?, KodePrasyarat=? WHERE KodeMTK=?";
    String DELETE = "DELETE FROM matakuliah WHERE KodeMTK=?";
    String SELECT = "SELECT * FROM matakuliah";
    String CARI   = "SELECT * FROM matakuliah WHERE KodeMTK LIKE ?";

    @Override
    public void insert(varMatakuliah Object) {
        PreparedStatement st = null;
        try{
            st = connection.prepareStatement(CARI);
            st.setString(1, Object.getvKodeMtk());
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                JOptionPane.showMessageDialog(null, "Data sudah pernah di simpan");
            }
            else {
                st = null;
                st = connection.prepareStatement(INSERT);
                st.setString(1, Object.getvKodeMtk());
                st.setString(2, Object.getvNamaMtk());
                st.setInt(3, Object.getvSks());
                st.setString(4, Object.getvKodePrasyarat());
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
    public void update(varMatakuliah Object) {
        PreparedStatement st = null;
        try{
            st = null;
            st = connection.prepareStatement(UPDATE);
            st.setString(1, Object.getvNamaMtk());
            st.setInt(2, Object.getvSks());
            st.setString(3, Object.getvKodePrasyarat());
            st.setString(4, Object.getvKodeMtk());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil di ubah");
            st.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String kode) {
        PreparedStatement st = null;
       try{
           st = null;
           st = connection.prepareStatement(DELETE);
           st.setString(1, kode);
           st.executeUpdate();
           JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
           st.close();
       }
       catch(Exception e){
           e.printStackTrace();
       }
    }

    @Override
    public List<varMatakuliah> getAll() {
        List<varMatakuliah> list = null;
        PreparedStatement st = null;
        try{
            st = null;
            list = new ArrayList<varMatakuliah>();
            st = connection.prepareStatement(SELECT);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                varMatakuliah objMtk = new varMatakuliah();
                objMtk.setvKodeMtk(rs.getString("KodeMTK"));
                objMtk.setvNamaMtk(rs.getString("NamaMTK"));
                objMtk.setvSks(rs.getInt("SKS"));
                objMtk.setvKodePrasyarat(rs.getString("KodePrasyarat"));
                list.add(objMtk);
            }
            st.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<varMatakuliah> getCari(String key) {
        List<varMatakuliah> list = null;
        PreparedStatement st = null;
        try{
            list = new ArrayList<varMatakuliah>();
            st = connection.prepareStatement(CARI);
            st.setString(1,  "%"+key+"%");
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                varMatakuliah objMtk = new varMatakuliah();
                objMtk.setvKodeMtk(rs.getString("KodeMTK"));
                objMtk.setvNamaMtk(rs.getString("NamaMTK"));
                objMtk.setvSks(rs.getInt("SKS"));
                objMtk.setvKodePrasyarat(rs.getString("KodePrasyarat"));
                list.add(objMtk);
            }
            st.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
}
