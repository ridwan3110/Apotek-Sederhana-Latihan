/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.model;

import java.util.Date;

/**
 *
 * @author ciwong
 */
public class ObatModel {
    
    private String ObatKd;
    private String NamaObat;
    private int Jumlah;
    private Date TglKadaluarsa;
    private Double Harga;
    private KategoriModel kategori;
    private boolean cek;

    public String getObatKd() {
        return ObatKd;
    }

    public void setObatKd(String ObatKd) {
        this.ObatKd = ObatKd;
    }

    public String getNamaObat() {
        return NamaObat;
    }

    public void setNamaObat(String NamaObat) {
        this.NamaObat = NamaObat;
    }

    public int getJumlah() {
        return Jumlah;
    }

    public void setJumlah(int Jumlah) {
        this.Jumlah = Jumlah;
    }

    public Date getTglKadaluarsa() {
        return TglKadaluarsa;
    }

    public void setTglKadaluarsa(Date TglKadaluarsa) {
        this.TglKadaluarsa = TglKadaluarsa;
    }

    public Double getHarga() {
        return Harga;
    }

    public void setHarga(Double Harga) {
        this.Harga = Harga;
    }

    public KategoriModel getKategori() {
        return kategori;
    }

    public void setKategori(KategoriModel kategori) {
        this.kategori = kategori;
    }

    public boolean isCek() {
        return cek;
    }

    public void setCek(boolean cek) {
        this.cek = cek;
    }
    
    

    
    
    @Override
    public String toString() {
        return NamaObat;
    }
    
    
    
}
