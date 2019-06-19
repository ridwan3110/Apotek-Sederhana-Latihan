/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.TableModel;

import com.ridwan.model.ObatModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ciwong
 */
public class TableModelObat extends AbstractTableModel{
    
    List<ObatModel> list = new ArrayList<>();

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
        case 0 : return list.get(rowIndex).getObatKd();
        case 1 : return list.get(rowIndex).getNamaObat();
        case 2 : return list.get(rowIndex).getKategori().getNamaKategori();
        case 3 :return list.get(rowIndex).getJumlah();
        case 4 : return list.get(rowIndex).getTglKadaluarsa();
        case 5 : return list.get(rowIndex).getHarga();
        case 6 : return list.get(rowIndex).isCek();
        default : return null;
     }
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0 : return "Kode Obat";
            case 1 : return "Nama Obat";
            case 2 : return "Kategori";
            case 3 : return "Jumlah";
            case 4 : return "Kadaluarsa";
            case 5: return "Harga";
            case 6 : return "Cek";
            default : return null;
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
      return true;
    }
    
    
    public void insertObat (ObatModel obatModel){
        this.list.add(obatModel);
        fireTableDataChanged();
    }
    public void updateObat (int index, ObatModel obatModel){
        this.list.set(index, obatModel);
        fireTableDataChanged();
    }
    
    public void deleteObat (int index){
        this.list.remove(index);
        fireTableDataChanged();
    }
    
    public void setData (List<ObatModel> list){
        this.list = list;
        fireTableDataChanged();
    }
    
    public void clear(){
        list.clear();
    }
    
    public ObatModel getobatModel(int index){
        return list.get(index);
    }
    
    public List<ObatModel> getObatCek(){
        List ls = new ArrayList<>();
        for (ObatModel o : list){
            if (o.isCek()){
                ls.add(o);
            }
        }
    return ls;
    }
    
    public boolean obatCek(boolean cek){
        return list.equals(cek);
    }
    
    @Override
    public Class<?> getColumnClass (int columnIndex){
        if (columnIndex == 6){
           return Boolean.class; 
        }else {
            return super.getColumnClass(columnIndex);
        }
    }
    
    @Override
    public void setValueAt (Object aValue, int rowIndex, int columnIndex){
        if (aValue!=null&& aValue instanceof Boolean && columnIndex ==6  ){
            Boolean cek = (Boolean) aValue;
            list.get(rowIndex).setCek(cek);
        }
    }
    
}


