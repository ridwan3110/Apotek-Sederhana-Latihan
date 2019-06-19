/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.DAO;

import com.ridwan.DBC.DBC;
import com.ridwan.Interface.PetugasInterface;
import com.ridwan.model.PetugasModel;
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
public class PetugasDao implements PetugasInterface{
    
    
    private Connection connection;

    public PetugasDao() {
        connection = DBC.getConnection();
    }
    

    @Override
    public boolean insertPetugas(PetugasModel petugasModel) {
        boolean valid = false;
        PreparedStatement statement = null;
        String sql = "insert into petugas (Petugas_kd, Nama, Username, Password, Status, Alamat, Telepon) values (?,?,?,?,?,?,?)";
        
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, petugasModel.getPetugasId());
            statement.setString(2, petugasModel.getNama());
            statement.setString(3, petugasModel.getUsername());
            statement.setString(4, petugasModel.getPassword());
            statement.setString(5, petugasModel.getStatus());
            statement.setString(6, petugasModel.getAlamat());
            statement.setString(7, petugasModel.getTelepon());
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
        valid = false;
        }finally{
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    @Override
    public void updatePetugas(PetugasModel petugasModel) {
    PreparedStatement statement = null;
    String sql = "update petugas set Nama=?, Username=?, Password=?, Status=?, Alamat=?, Telepon=? where Petugas_kd=?";
    
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, petugasModel.getNama());
             statement.setString(2, petugasModel.getUsername());
            statement.setString(3, petugasModel.getPassword());
            statement.setString(4, petugasModel.getStatus());
            statement.setString(5, petugasModel.getAlamat());
            statement.setString(6, petugasModel.getTelepon());
            statement.setString(7, petugasModel.getPetugasId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
   
    }

    @Override
    public boolean deletePetugas(PetugasModel petugasModel) {
        boolean valid = false;
    PreparedStatement statement = null;
    String sql = "delete from petugas where Petugas_kd=?";
    
        try {
            statement= connection.prepareStatement(sql);
            statement.setString(1, petugasModel.getPetugasId());
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    @Override
    public PetugasModel getById(String Id) {
    PreparedStatement statement = null;
        ResultSet rs = null;
        PetugasModel p = null;
        
        String sql  = "select * from petugas where Petugas_kd=?";
   
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, Id);
            rs = statement.executeQuery();
            while (rs.next()){
                p = new PetugasModel();
                p.setPetugasId(rs.getString("Petugas_kd"));
                p.setNama(rs.getString("Nama"));
                p.setUsername(rs.getString("Username"));
                p.setPassword(rs.getString("Password"));
                p.setStatus(rs.getString("Status"));
                p.setAlamat(rs.getString("Alamat"));
                p.setTelepon(rs.getString("Telepon"));
                
            }return p;
        } catch (SQLException ex) {
            Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }finally{
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
    

    @Override
    public List<PetugasModel> petugasModels() {
    PreparedStatement statement = null;
    ResultSet rs = null;
    List list = new ArrayList();
    String sql = "select * from petugas ";
    
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
    while (rs.next()){
        PetugasModel p = new PetugasModel();
        p.setPetugasId(rs.getString("Petugas_kd"));
        p.setNama(rs.getString("Nama"));
        p.setUsername(rs.getString("Username"));
        p.setPassword(rs.getString("Password"));
        p.setStatus(rs.getString("Status"));
        p.setAlamat(rs.getString("Alamat"));
        p.setTelepon(rs.getString("Telepon"));
        list.add(p);
        
    }return list;
        } catch (SQLException ex) {
            Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    
    
    }

    @Override
    public String setAutonumber() {
     PreparedStatement statement = null;
     ResultSet rs = null;
     String kode = null;
     String s, s1;
     Integer j ;
     Integer panjang = 5;
     
     String sql = "select max(right(Petugas_kd, 5))from petugas";
     
        try {
            statement = connection.prepareStatement(sql);
            rs= statement.executeQuery();
            if (rs.first()==false){
                kode = "KP/00001";
            }else {
                
                rs.last();
                s = Integer.toString(rs.getInt(1)+1);
                j = s.length();
                s1 = "";
                for (int i = 0 ; i<=panjang-j ;  i++){
                    s1 = s1 + "0";
                }
                kode = "KP/"+s1+s;
            }
            return kode;
        } catch (SQLException ex) {
            Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
        return kode;
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    
    }

    @Override
    public PetugasModel loginPetugas(String Username, String Password) {
        PreparedStatement statement = null;
        ResultSet rs = null;
        PetugasModel p = null;
        String sql = "select * from petugas where Username=? and Password=?";
        
        try {
            statement = connection.prepareStatement(sql);
             statement.setString(1, Username);
             statement.setString(2, Password);
             rs = statement.executeQuery();
             while (rs.next()){
                 p = new PetugasModel();
                 p.setPetugasId(rs.getString("Petugas_kd"));
                 p.setNama(rs.getString("Nama"));
                 p.setUsername(rs.getString("Username"));
                 p.setPassword(rs.getString("Password"));
                 p.setStatus(rs.getString("Status"));
                 p.setAlamat(rs.getString("Alamat"));
                 p.setTelepon(rs.getString("Telepon"));
                 
             }return p;
        } catch (SQLException ex) {
            Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }

    @Override
    public boolean ubahPassword(String oldUsername, String oldPassword, String newUsername, String newPassword) {
   boolean valid = false;
        PreparedStatement statement = null;
    
    String sql = "update petugas set Username=?, Password=? where Username=?, Password=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, newUsername);
            statement.setString(2, newPassword);
            statement.setString(3, oldUsername);
            statement.setString(4, oldPassword);
            statement.executeUpdate();
            return valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
               return valid = false;
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    
    }
    
}
