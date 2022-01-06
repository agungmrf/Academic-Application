/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO_Interface;
import DAO.DAO_Matakuliah;
import Model.varMatakuliah;
import View.FrmMatakuliah;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Agung Ma'ruf
 */
public class Controller_Matakuliah {
    FrmMatakuliah form;
    DAO_Interface<varMatakuliah> model;
    List<varMatakuliah> list;
    String[] header;
    
    public Controller_Matakuliah(FrmMatakuliah form) {
        this.form = form;
        model = new DAO_Matakuliah();
        list = model.getAll();
        header = new String[]{"Kode Matakuliah", "Nama Matakuliah", "SKS", "Kode Prasyarat"};
        form.getTblMatakuliah().setShowGrid(true);
        form.getTblMatakuliah().setShowVerticalLines(true);
        form.getTblMatakuliah().setGridColor(Color.blue);
    }
    
    public void reset(){
        form.getTxtKodeMtk().setText("");
        form.getTxtNamaMtk().setText("");
        form.getTxtSks().setText("");
        form.getTxtKodePrasyarat().setText("");
        form.getTxtKodeMtk().requestFocus();
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
        for (varMatakuliah c : list) {
            data[0] = c.getvKodeMtk();
            data[1] = c.getvNamaMtk();
            data[2] = c.getvSks();
            data[3] = c.getvKodePrasyarat();
            tblModel.addRow(data);
        }
        form.getTblMatakuliah().setModel(tblModel);
    }
    
    public void isiField(int row){
        form.getTxtKodeMtk().setText(String.valueOf(list.get(row).getvKodeMtk()));
        form.getTxtNamaMtk().setText(list.get(row).getvNamaMtk());
        form.getTxtSks().setText(String.valueOf(list.get(row).getvSks()));
        form.getTxtKodePrasyarat().setText(list.get(row).getvKodePrasyarat());
    }
    
    public void insert(){
        varMatakuliah objMtk = new varMatakuliah();
   
        objMtk.setvKodeMtk(form.getTxtKodeMtk().getText());
        objMtk.setvNamaMtk(form.getTxtNamaMtk().getText());
        objMtk.setvSks(Integer.parseInt(form.getTxtSks().getText()));
        objMtk.setvKodePrasyarat(form.getTxtKodePrasyarat().getText());
        model.insert(objMtk);
    }
    
    public void update(){
        varMatakuliah objMtk = new varMatakuliah();
   
        objMtk.setvKodeMtk(form.getTxtKodeMtk().getText());
        objMtk.setvNamaMtk(form.getTxtNamaMtk().getText());
        objMtk.setvSks(Integer.parseInt(form.getTxtSks().getText()));
        objMtk.setvKodePrasyarat(form.getTxtKodePrasyarat().getText());
        model.update(objMtk);
    }
    
    public void delete(){
        if(!form.getTxtKodeMtk().getText().trim().isEmpty()){
            String kode = form.getTxtKodeMtk().getText();
            
            model.delete(kode);
        }
        else{
            JOptionPane.showMessageDialog(form, "Pilih data yang akan d hapus");
        }
    }
    
    public void isiTabelCari(){
        list = model.getCari(form.getTxtKodeMtk().getText().trim());
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header);
        Object[] data = new Object[header.length];
        for(varMatakuliah objMtk : list){
            data[0] = objMtk.getvKodeMtk();
            data[1] = objMtk.getvNamaMtk();
            data[2] = objMtk.getvSks();
            data[3] = objMtk.getvKodePrasyarat();
            tblModel.addRow(data);
        }
        form.getTblMatakuliah().setModel(tblModel);
    }
}
