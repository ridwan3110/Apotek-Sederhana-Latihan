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
public class TransaksiDetail {
    private Transaksi transaksi;
    private ObatModel obat;
    private int Jumlah;
    private Double Harga;

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public ObatModel getObat() {
        return obat;
    }

    public void setObat(ObatModel obat) {
        this.obat = obat;
    }

    public int getJumlah() {
        return Jumlah;
    }

    public void setJumlah(int Jumlah) {
        this.Jumlah = Jumlah;
    }

    public Double getHarga() {
        return Harga;
    }

    public void setHarga(Double Harga) {
        this.Harga = Harga;
    }

   
    
    
}

    
    

