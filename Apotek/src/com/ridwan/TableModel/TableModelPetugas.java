/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.TableModel;

import com.ridwan.model.PetugasModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ciwong
 */
public class TableModelPetugas extends AbstractTableModel {
    List<PetugasModel>list = new ArrayList<>();

    public TableModelPetugas() {
    }
    
    

    @Override
    public int getRowCount() {
    return list.size();
    }

    @Override
    public int getColumnCount() {
    return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex){
        case 0 : return list.get(rowIndex).getPetugasId();
        case 1 : return list.get(rowIndex).getNama();
        case 2 : return list.get(rowIndex).getUsername();
        case 3 : return list.get(rowIndex).getStatus();
        case 4 : return list.get(rowIndex).getAlamat();
        case 5 : return list.get(rowIndex).getTelepon();
        case 6 : return list.get(rowIndex).isCek();
        default : return null;
    }
    }
    @Override
    public String getColumnName (int column){
        switch(column){
            case 0 : return "Kode Petugas";
            case 1 : return "Nama Petugas";
            case 2 : return "Username Petugas";
            case 3 : return "Status";
            case 4 : return "Alamat";
            case 5 : return "Telepon";
            case 6 : return "Cek";
            default : return null;
            
        }
    }
    
    public void insertPetugas (PetugasModel petugasModel){
        this.list.add(petugasModel);
        fireTableDataChanged();
    }
    public void updatePetugas (int index , PetugasModel petugasModel){
        this.list.set(index, petugasModel);
        fireTableDataChanged();
    }
    
    public void deletePetugas (int index){
        this.list.remove(index);
        fireTableDataChanged();
    }
    
    public void setData (List<PetugasModel> list){
        this.list = list;
        fireTableDataChanged();
    }
    
    public PetugasModel getPetugasModel(int index){
        return list.get(index);
    }
    
    public void clear (){
        list.clear();
    }
    
    
    public List<PetugasModel> getpetugasCek(){
        List ls = new ArrayList();
        for (PetugasModel p : list){
            if (p.isCek()){
                ls.add(p);
            }
        }
        return ls;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }
    
    public boolean petugasCek(boolean cek){
        return list.equals(cek);
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        if (columnIndex ==  6){
            return Boolean.class;
        }else {
            return super.getColumnClass(columnIndex);
        }
    }

    
    @Override
    public void setValueAt (Object aValue, int rowIndex, int columnIndex){
        if (aValue!=null && aValue instanceof Boolean && columnIndex == 6){
            Boolean cek = (Boolean) aValue;
            list.get(rowIndex).setCek(cek);
        }
    }
    
   
}
    

