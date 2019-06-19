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
public class KategoriModel {
    private String KategoriKd;
    private String NamaKategori;
    public boolean cek;

    public boolean isCek() {
        return cek;
    }

    public void setCek(boolean cek) {
        this.cek = cek;
    }

    public String getKategoriKd() {
        return KategoriKd;
    }

    public void setKategoriKd(String KategoriKd) {
        this.KategoriKd = KategoriKd;
    }

    public String getNamaKategori() {
        return NamaKategori;
    }

    public void setNamaKategori(String NamaKategori) {
        this.NamaKategori = NamaKategori;
    }

    @Override
    public String toString() {
        return NamaKategori;
    }
    
    
    
}
