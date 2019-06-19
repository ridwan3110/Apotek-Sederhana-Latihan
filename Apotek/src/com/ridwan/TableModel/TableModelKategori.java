/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.TableModel;

import com.ridwan.model.KategoriModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ciwong
 */
public class TableModelKategori extends AbstractTableModel{
    
    
    List<KategoriModel> list = new ArrayList<>();

    public TableModelKategori() {
    }
    
    

    @Override
    public int getRowCount() {
    return list.size();
    }

    @Override
    public int getColumnCount() {
    return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex){
        case 0 :return list.get(rowIndex).getKategoriKd();
        case 1 : return list.get(rowIndex).getNamaKategori();
        case 2 : return list.get(rowIndex).isCek();
        default : return null;
    }
    }
    
    @Override
    public String getColumnName (int column){
        switch (column){
            case 0 : return "Kode Kategori";
            case 1 : return "Nama Kategori";
            case 2 : return "cek";
            default : return null;
         
     
        }
    }
    
    
    public void insertKategori(KategoriModel kategoriModel){
        this.list.add(kategoriModel);
        fireTableDataChanged();
    }
    
    public void updateKategori (int index ,KategoriModel kategoriModel){
        this.list.set(index, kategoriModel);
        fireTableDataChanged();
    }
    
    public void deleteKategori (int index){
        this.list.remove(index);
        fireTableDataChanged();
    }
    
    public KategoriModel getKategoriModel(int index){
        return list.get(index);
        
    }
    
    public void setData (List<KategoriModel> list){
        this.list=list;
    }
    
    public void clear (){
        list.clear();
    }
    
    
    public List<KategoriModel> getKategoriCek(){
        List ls = new ArrayList<>();
        for (KategoriModel km : list ){
            if (km.isCek()){
                ls.add(km);
            }
        }
        return ls;
    }
    
      @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
      return true;
    }
    
    
    public boolean obatCek (boolean cek){
        return list.equals(cek);
    }
    
    
    @Override
    public Class<?> getColumnClass (int columnIndex){
        if (columnIndex == 2){
            return Boolean.class;
        }else {
            return super.getColumnClass(columnIndex);
        }
    }
    
    
    @Override
    public void setValueAt (Object aValue , int rowIndex, int columnIndex){
        if (aValue!=null && aValue instanceof Boolean && columnIndex==2){
            Boolean cek = (Boolean) aValue; 
            list.get(rowIndex).setCek(cek);
        }
    }
    
    
}

