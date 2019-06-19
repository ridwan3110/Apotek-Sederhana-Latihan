/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.TableModel;

import com.ridwan.model.TransaksiDetail;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ciwong
 */
public class TableModelTransaksiDetail extends AbstractTableModel {
    List<TransaksiDetail> list = new ArrayList<>();
    

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
        case 0 : return list.get(rowIndex).getObat();
        case 1 : return list.get(rowIndex).getJumlah();
        case 2 : return list.get(rowIndex).getHarga();
        default : return null;
    }
    }
    
    @Override
    public String getColumnName (int column){
        switch (column){
            case 0 : return "Obat";
            case 1 : return "Jumlah";
            case 2 : return "Harga";
            default : return null;
        }
    }
    
    public void insertTransaksiDetail(TransaksiDetail transaksiDetil){
        this.list.add(transaksiDetil);
        fireTableDataChanged();
    }
    
    public void updateTransaksi (int index, TransaksiDetail transaksiDetil){
        this.list.set(index, transaksiDetil);
        fireTableDataChanged();
    }
    
    public void deleteTransaksi (int index){
        this.list.remove(index);
        fireTableDataChanged();
    }
    
    public void setData (List<TransaksiDetail> list){
        this.list = list;
        fireTableDataChanged();
    }
    
    public TransaksiDetail getTransaksiDetail (int index){
        return list.get(index);
    }
    
    public void clear (){
        list.clear();
        fireTableDataChanged();
    }
    
    
    @Override
    public boolean isCellEditable (int rowindex, int columnindex){
        return true;
    }
    
    @Override
    public Class<?> getColumnClass (int columnindex){
        switch (columnindex){
            case 1 : return Integer.class;
            default : return Object.class;
        }
    }
    
    @Override
       public void setValueAt (Object aValue, int rowIndex, int columnIndex){
           if (aValue !=null && aValue instanceof Integer && columnIndex==1){
               int jumlah = (int) aValue;
               list.get(rowIndex).setJumlah(jumlah);
      }  
    }
    
    } 
    

