/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Koneksi.Database;
import Model.varPeriode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Agung Ma'ruf
 */
    public class DAO_Periode implements DAO_Interface<varPeriode>{
        public DAO_Periode(){
        connection = Database.KoneksiDB();
    }
        
    Connection connection;
    String INSERT = "INSERT INTO periode(TA, Semester) VALUES(?,?)";
    String UPDATE = "UPDATE periode SET Semester=? WHERE TA=?";
    String DELETE = "DELETE FROM periode WHERE TA=?";
    String SELECT = "SELECT * FROM periode";
    String CARI   = "SELECT * FROM periode WHERE TA LIKE ?";

    @Override
    public void insert(varPeriode Object) {
        PreparedStatement st = null;
        try{
            st = connection.prepareStatement(CARI);
            st.setString(1, Object.getvTA());
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                JOptionPane.showMessageDialog(null, "Data sudah pernah di simpan");
            }
            else {
                st = null;
                st = connection.prepareStatement(INSERT);
                st.setString(1, Object.getvTA());
                st.setString(2, Object.getvSemester());
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
    public void update(varPeriode Object) {
        PreparedStatement st = null;
        try{
            st = null;
            st = connection.prepareStatement(UPDATE);
            st.setString(1, Object.getvSemester());
            st.setString(2, Object.getvTA());
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
    public List<varPeriode> getAll() {
        List<varPeriode> list = null;
        PreparedStatement st = null;
        try{
            st = null;
            list = new ArrayList<varPeriode>();
            st = connection.prepareStatement(SELECT);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                varPeriode p = new varPeriode();
                p.setvTA(rs.getString("TA"));
                p.setvSemester(rs.getString("Semester"));
                list.add(p);
            }
            st.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<varPeriode> getCari(String key) {
        List<varPeriode> list = null;
        PreparedStatement st = null;
        try{
            list = new ArrayList<varPeriode>();
            st = connection.prepareStatement(CARI);
            st.setString(1,  "%"+key+"%");
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                varPeriode p = new varPeriode();
                p.setvTA(rs.getString("TA"));
                p.setvSemester(rs.getString("Semester"));
            }
            st.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
}
