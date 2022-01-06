/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO_Interface;
import DAO.DAO_Periode;
import Model.varPeriode;
import View.FrmPeriode;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Agung Ma'ruf
 */
public class Controller_Periode {
    FrmPeriode form;
    DAO_Interface<varPeriode> model;
    List<varPeriode> list;
    String[] header;
    
    public Controller_Periode(FrmPeriode form) {
        this.form = form;
        model = (DAO_Interface<varPeriode>) new DAO_Periode();
        list = model.getAll();
        header = new String[]{"Tahun Ajaran", "Semester"};
        form.getTblPeriode().setShowGrid(true);
        form.getTblPeriode().setShowVerticalLines(true);
        form.getTblPeriode().setGridColor(Color.blue);
    }
    
    public void reset(){
        form.getTxtTA().setText("");
        form.getTxtSemester().setText("");
        form.getTxtTA().requestFocus();
        isiTable();
    }
    
    public void isiTable() {
        list = model.getAll();
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        
        Object[] data = new Object[header.length];
        for (varPeriode p : list) {
            data[0] = p.getvTA();
            data[1] = p.getvSemester();
            tblModel.addRow(data);
        }
        form.getTblPeriode().setModel(tblModel);
    }
    
    public void isiField(int row){
        form.getTxtTA().setText(list.get(row).getvTA());
        form.getTxtSemester().setText(list.get(row).getvSemester());
    }
    
    public void insert(){
        varPeriode p = new varPeriode();
        
        p.setvTA(form.getTxtTA().getText());
        p.setvSemester(form.getTxtSemester().getText());
        
        model.insert(p);
    }
    
    public void update(){
        varPeriode p = new varPeriode();
        
        p.setvTA(form.getTxtTA().getText());
        p.setvSemester(form.getTxtSemester().getText());
        
        model.update(p);
    }
    
    public void delete(){
        if(!form.getTxtTA().getText().trim().isEmpty()){
            //mengisi variabel objMhs dengan data yang di entri
            String kode = form.getTxtTA().getText();
            
            //menjalankan method delete yang ada di DAO_Mahasiswa
            model.delete(kode);
        }
        else{
            JOptionPane.showMessageDialog(form, "Pilih data yang akan d hapus");
        }
    }
    
    public void isiTabelCari(){
        list = model.getCari(form.getTxtTA().getText().trim());
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header);
        Object[] data = new Object[header.length];
        for(varPeriode objMtk : list){
            data[0] = objMtk.getvTA();
            data[1] = objMtk.getvSemester();
            tblModel.addRow(data);
        }
        form.getTblPeriode().setModel(tblModel);
    }
}
