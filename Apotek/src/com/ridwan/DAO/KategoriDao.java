/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.DAO;

import com.ridwan.DBC.DBC;
import com.ridwan.Interface.KategoriInterface;
import com.ridwan.model.KategoriModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ciwong
 */
public class KategoriDao implements KategoriInterface{

    private Connection connection;

    public KategoriDao() {
    connection = DBC.getConnection();
    }
    
    @Override
    public boolean insertKategori(KategoriModel kategoriModel) {
        boolean valid = false;
        PreparedStatement statement = null;
        String sql = "insert into kategori (Kategori_kd, Nama_Kategori) values (?,?)";
        
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, kategoriModel.getKategoriKd());
            statement.setString(2, kategoriModel.getNamaKategori());
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
        valid = false;
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
        
    }

    @Override
    public void updateKategori(KategoriModel kategoriModel) {
    PreparedStatement statement = null;
    String sql = "update kategori set Nama_Kategori=? where Kategori_kd=?";
    
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, kategoriModel.getNamaKategori());
            statement.setString(2, kategoriModel.getKategoriKd());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    
    }

    @Override
    public boolean deleteKategori(KategoriModel kategoriModel) {
    boolean valid = false;
        PreparedStatement statement = null;
    String sql = "delete from kategori where Kategori_kd=?";
    
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, kategoriModel.getKategoriKd());
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
        valid = false;
        }finally { 
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    return valid;
    }

    @Override
    public KategoriModel getById(String Id) {
        PreparedStatement statement = null;
        ResultSet rs = null;
        KategoriModel k = null;
        String sql = "select * from kategori where Kategori_kd=?";
        
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, Id);
            rs = statement.executeQuery();
            while (rs.next()){
                k = new KategoriModel();
                k.setKategoriKd(rs.getString("Kategori_kd"));
                k.setNamaKategori(rs.getString("Nama_Kategori"));
                
            }return k;
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }

    @Override
    public List<KategoriModel> getKategoriModels() {
    PreparedStatement statement =null;
    ResultSet rs = null;
    List list = new ArrayList();
    
    String sql = "select * from kategori ";
    
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()){
                KategoriModel k = new KategoriModel();
                k.setKategoriKd(rs.getString("Kategori_kd"));
                k.setNamaKategori(rs.getString("Nama_Kategori"));
                list.add(k);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    
    }

    @Override
     public String setAutoNumber() {
      PreparedStatement statement=null;
      ResultSet rs=null;
      String kode=null;
      String s, s1;
      Integer j;
      Integer panjang = 5;
      String sql="select max(right(Kategori_kd, 5)) from kategori";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            if(rs.first()==false){
                kode="KK/00001";
            }
            else {
                rs.last();
                s=Integer.toString(rs.getInt(1)+1);
                j=s.length();
                s1="";
                for(int i=0; i<=panjang-j; i++){
                    s1=s1+"0";
                }
                return kode="KK/"+s1+s;
            }
            return kode;
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}