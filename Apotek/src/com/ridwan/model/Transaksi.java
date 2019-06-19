/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author ciwong
 */
public class Transaksi {
    private String Transaksikd;
    private Date TglTransaksi;
    private PetugasModel Petugas;
    List<TransaksiDetail> gettrTransaksiDetils;

    public PetugasModel getPetugas() {
        return Petugas;
    }

    public void setPetugas(PetugasModel Petugas) {
        this.Petugas = Petugas;
    }

    

   
    
    

    public String getTransaksikd() {
        return Transaksikd;
    }

    public void setTransaksikd(String Transaksikd) {
        this.Transaksikd = Transaksikd;
    }

   

    public Date getTglTransaksi() {
        return TglTransaksi;
    }

    public void setTglTransaksi(Date TglTransaksi) {
        this.TglTransaksi = TglTransaksi;
    }

    public List<TransaksiDetail> getGettrTransaksiDetils() {
        return gettrTransaksiDetils;
    }

    public void setGettrTransaksiDetils(List<TransaksiDetail> gettrTransaksiDetils) {
        this.gettrTransaksiDetils = gettrTransaksiDetils;
    }

    @Override
    public String toString() {
        return "Transaksi{" + "Transaksikd=" + Transaksikd + ", TglTransaksi=" + TglTransaksi + ", gettrTransaksiDetils=" + gettrTransaksiDetils + '}';
    }
    
    
    
}
