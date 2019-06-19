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
public class ReportTransaksi {
    private Transaksi transaksi;
    private TransaksiDetail  transaksiDetil;

     public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public TransaksiDetail getTransaksiDetil() {
        return transaksiDetil;
    }

    public void setTransaksiDetil(TransaksiDetail transaksiDetil) {
        this.transaksiDetil = transaksiDetil;
    }

    @Override
    public String toString() {
        return "ReportTransaksi{" + "transaksi=" + transaksi + ", transaksiDetil=" + transaksiDetil + '}';
    }
    

   
    
    
}
