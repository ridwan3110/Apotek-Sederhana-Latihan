/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.DAO;

import com.ridwan.DBC.DBC;
import com.ridwan.Interface.KategoriInterface;
import com.ridwan.Interface.ObatInterface;
import com.ridwan.model.KategoriModel;
import com.ridwan.model.ObatModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ciwong
 */
public class ObatDao implements ObatInterface{
    private KategoriInterface kategoriDao;

    private Connection connection;
    

    public ObatDao() {
    connection = DBC.getConnection();
    kategoriDao = new KategoriDao();
    }
    
    
    @Override
    public boolean insertObat(ObatModel obatModel) {
       boolean valid = false;
        PreparedStatement statement = null;
        String sql = "insert into obat (Obat_kd, Nama_Obat, Jumlah, Tgl_kadaluarsa, Harga, Kategori_kd)"
                + "values (?,?,?,?,?,?)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, obatModel.getObatKd());
            statement.setString(2, obatModel.getNamaObat());
            statement.setInt(3, obatModel.getJumlah());
            statement.setDate(4, new java.sql.Date(obatModel.getTglKadaluarsa().getTime()));
            statement.setDouble(5, obatModel.getHarga());
            statement.setString(6, obatModel.getKategori().getKategoriKd());
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
        valid = false;
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    return valid;
    }
    
    @Override
    public void updateObat(ObatModel obatModel) {
    PreparedStatement statement= null;
    String sql = "update obat set Nama_Obat=?, Jumlah=?, Tgl_kadaluarsa=?, Harga=?, Kategori_kd=? where Obat_kd=?";
  
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, obatModel.getNamaObat());
            statement.setInt(2, obatModel.getJumlah());
            statement.setDate(3, new java.sql.Date(obatModel.getTglKadaluarsa().getTime()));
            statement.setDouble(4, obatModel.getHarga());
            statement.setString(5, obatModel.getKategori().getKategoriKd());
            statement.setString(6, obatModel.getObatKd());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    
    
    }

    @Override
    public boolean deleteObat(ObatModel obatModel) {
    boolean valid = false;
        PreparedStatement statement = null;
    String sql = "delete from obat where Obat_kd=?";
    
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, obatModel.getObatKd());
             statement.executeUpdate();
             valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
        valid = false;
        }finally{
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    
    
    return valid;
    }

    @Override
    public ObatModel getById(String Id) {
    PreparedStatement statement = null;
        ResultSet rs = null;
        ObatModel ob = null;
    String sql = "select * from obat where Obat_kd=? ";
    
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, Id);
            rs = statement.executeQuery();
            while (rs.next()){
                ob = new ObatModel();
                ob.setObatKd(rs.getString("Obat_kd"));
                ob.setNamaObat(rs.getString("Nama_Obat"));
                ob.setJumlah(rs.getInt("Jumlah"));
                ob.setTglKadaluarsa(rs.getDate("Tgl_kadaluarsa"));
                String kategorikd = rs.getString("Kategori_kd");
                KategoriModel byId = kategoriDao.getById(kategorikd);
                ob.setKategori(byId);
                 ob.setHarga(rs.getDouble("Harga"));
            }return ob;
        } catch (SQLException ex) {
            Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    
    
    }

    @Override
    public List<ObatModel> getObatModels() {
    PreparedStatement statement = null;
    ResultSet rs = null;
    List list = new ArrayList();
    String sql = "select * from obat ";
    
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()){
               ObatModel o = new ObatModel();
               o.setObatKd(rs.getString("Obat_kd"));
               o.setNamaObat(rs.getString("Nama_obat"));
               o.setJumlah(rs.getInt("Jumlah"));
                String kategoriId = rs.getString("Kategori_kd");
                KategoriModel byId = kategoriDao.getById(kategoriId);
                o.setKategori(byId);
                o.setTglKadaluarsa(rs.getDate("Tgl_kadaluarsa"));
                o.setHarga(rs.getDouble("Harga"));
                list.add(o);
            }return list;
        } catch (SQLException ex) {
            Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
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
      String sql="select max(right(Obat_kd, 5)) from obat";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            if(rs.first()==false){
                kode="KO/00001";
            }else{
                rs.last();
                s=Integer.toString(rs.getInt(1)+1);
                j=s.length();
                s1="";
                for(int i=0; i<=panjang-j; i++){
                    s1=s1+"0";
                }
                return kode="KO/"+s1+s;
            }
            return kode;
        } catch (SQLException ex) {
            Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }


    
    @Override
    public List<ObatModel> getKategoriModels(KategoriModel kategoriModel) {
    PreparedStatement statement = null;
    ResultSet rs = null;
    List list = new ArrayList();
    String sql = "select * from obat where Kategori_kd=?";
    
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, kategoriModel.getKategoriKd());
            rs= statement.executeQuery();
            while (rs.next()){
                ObatModel ob = new ObatModel();
                ob.setObatKd(rs.getString("Obat_kd"));
                ob.setNamaObat(rs.getString("Nama_Obat"));
                ob.setJumlah(rs.getInt("Jumlah"));
                String kategorikd = rs.getString("Kategori_kd");
                KategoriModel byId = kategoriDao.getById(kategorikd);
                ob.setKategori(byId);
                list.add(ob);
                ob.setHarga(rs.getDouble("Harga"));
                ob.setTglKadaluarsa(rs.getDate("Tgl_kadaluarsa"));
            }return list;
        } catch (SQLException ex) {
            Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    
    }

    @Override
    public void KurangJumlahStock(int Jumlah, ObatModel obatModel) {
    PreparedStatement statement =null;
    String sql = "update obat set Jumlah = Jumlah-? where Obat_kd=?";
    
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, Jumlah);
            statement.setString(2, obatModel.getObatKd());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally { 
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    
    }
    
}

