/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.TableModel;

import com.ridwan.model.GudangModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ciwong
 */
public class TableModelGudang extends AbstractTableModel{

    List<GudangModel> list = new ArrayList<>();
    @Override
    
    public int getRowCount() {
    return list.size();
    }

    @Override
    public int getColumnCount() {
    return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex){
        case 0 : return list.get(rowIndex).getGudangkd();
        case 1 : return list.get(rowIndex).getNamaGudang();
        case 2 : return list.get(rowIndex).getNamaObat();
        case 3 : return list.get(rowIndex).getStokobat();
        case 4 : return list.get(rowIndex).isCek();
        default : return null;
    }
    }
    
    @Override
     public String getColumnName(int column){
        switch (column){
            case 0 : return "Kode Gudang";
            case 1 : return "Nama Gudang";
            case 2 : return "Nama Obat";
            case 3 : return "Stok Obat";
            case 4 : return "Cek";
            default : return null;
        }
    }
     
    @Override
     public boolean isCellEditable (int rowIndex, int columnIndex){
         return true;
     }
     
     public void insertGudang (GudangModel gudangModel){
         this.list.add(gudangModel);
         fireTableDataChanged();
     }
     public void updateGudang (int index, GudangModel gudangModel){
         this.list.set(index, gudangModel);
         fireTableDataChanged();
     }
     
     public void deleteGudang (int index){
         this.list.remove(index);
         fireTableDataChanged();
     }
     
     public void setData (List<GudangModel> list){
         this.list = list;
         fireTableDataChanged();
     }
     
     public void clear(){
         list.clear();
     }
     
     public GudangModel getGudangModel (int index){
         return list.get(index);
     }
     
     public List<GudangModel> getGudangCek(){
         List ls = new ArrayList();
         for (GudangModel g : list){
             if (g.isCek()){
                 ls.add(g);
             }
         }
         return ls;
     }
     
     public boolean gudangCek(boolean cek){
         return list.equals(cek);
     }
    
    @Override
     public Class<?> getColumnClass(int columnIndex){
         if (columnIndex == 4){
             return Boolean.class;
         }else {
             return super.getColumnClass(columnIndex);
         }
     }
     
    @Override
     public void setValueAt(Object aValue, int rowIndex, int columnIndex){
         if (aValue!=null&&aValue instanceof Boolean&&columnIndex==4){
         Boolean cek = (Boolean) aValue;
         list.get(rowIndex).setCek(cek);
     }
     }
}
