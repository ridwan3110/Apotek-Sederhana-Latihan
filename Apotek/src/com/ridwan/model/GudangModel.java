/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.model;

/**
 *
 * @author ciwong
 */
public class GudangModel {
    private String Gudangkd;
    private String NamaGudang;
    private String namaObat;
    private int Stokobat;
    private boolean cek;

    @Override
    public String toString() {
        return NamaGudang;
    }

   

    
    
    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }
    
    

    public boolean isCek() {
        return cek;
    }

    public void setCek(boolean cek) {
        this.cek = cek;
    }
    
    

    public String getGudangkd() {
        return Gudangkd;
    }

    public void setGudangkd(String Gudangkd) {
        this.Gudangkd = Gudangkd;
    }

    public String getNamaGudang() {
        return NamaGudang;
    }

    public void setNamaGudang(String NamaGudang) {
        this.NamaGudang = NamaGudang;
    }
    

    public int getStokobat() {
        return Stokobat;
    }

    public void setStokobat(int Stokobat) {
        this.Stokobat = Stokobat;
    }
    
    
    
    
}
