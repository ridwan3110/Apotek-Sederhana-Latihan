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
public class PetugasModel {
    
    private String PetugasId;
    private String username;
    private String Password;
    private String Nama;
    private String Status;
    private String Alamat;
    private String Telepon;
    public boolean cek;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public String getTelepon() {
        return Telepon;
    }

    public void setTelepon(String Telepon) {
        this.Telepon = Telepon;
    }

   
    
    
    
    

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }
    
    

    public boolean isCek() {
        return cek;
    }

    public void setCek(boolean cek) {
        this.cek = cek;
    }

    public String getPetugasId() {
        return PetugasId;
    }

    public void setPetugasId(String PetugasId) {
        this.PetugasId = PetugasId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return Nama;
    }
    
    
    
    
}
