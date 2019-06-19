/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.DAO;

import com.ridwan.DBC.DBC;
import com.ridwan.Interface.GudangInterface;
import com.ridwan.model.GudangModel;
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
public class GudangDao implements GudangInterface{
    
    private Connection connection;
    private KategoriDao kategoriDao = new KategoriDao();

    public GudangDao() {
        connection = DBC.getConnection();
    }
    
    

    @Override
    public boolean insertGudang(GudangModel gudangModel) {
            boolean valid = false;
            PreparedStatement statement = null;
            String sql = " insert into gudang (Gudang_kd, Nama_Gudang, namaobat, Stok_obat) values (?,?,?,?)";
            
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, gudangModel.getGudangkd());
            statement.setString(2, gudangModel.getNamaGudang());
            statement.setString(3, gudangModel.getNamaObat());
            statement.setInt(4, gudangModel.getStokobat());
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(GudangDao.class.getName()).log(Level.SEVERE, null, ex);
        valid = false;
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GudangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
        }   
  
    @Override
    public void updateGudang(GudangModel gudangModel) {
    PreparedStatement statement = null;
    String sql = "update gudang set Nama_Gudang=? , namaobat=?, Stok_obat=? where Gudang_kd=?";
    
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, gudangModel.getNamaGudang());
            statement.setString(2, gudangModel.getNamaObat());
            statement.setInt(3, gudangModel.getStokobat());
            statement.setString(4, gudangModel.getGudangkd());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GudangDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GudangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }

    @Override
    public boolean deleteGudang(GudangModel gudangModel) {
    boolean valid = false;
    PreparedStatement statement = null;
    
    String sql = "delete from gudang where Gudang_kd=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, gudangModel.getGudangkd());
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(GudangDao.class.getName()).log(Level.SEVERE, null, ex);
        valid = false;
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GudangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    return valid;
    }

    @Override
    public GudangModel getById(String Id) {
    PreparedStatement statement = null;
        ResultSet rs = null;
        GudangModel g = null;
        
        String sql = "select * from gudang where Gudang_kd=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, Id);
            rs = statement.executeQuery();
            while (rs.next()){
                g = new GudangModel();
                g.setGudangkd(rs.getString("Gudang_kd"));
                g.setNamaGudang(rs.getString("Nama_Gudang"));
                g.setNamaObat(rs.getString("namaobat"));
                g.setStokobat(rs.getInt("Stok_obat"));
            }return g;
        } catch (SQLException ex) {
            Logger.getLogger(GudangDao.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GudangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GudangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
    }

    @Override
    public List<GudangModel> getgudangModels() {
    PreparedStatement statement = null;
    ResultSet rs = null;
    List list = new ArrayList<>();
    
    String sql="select * from gudang";
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()){
                GudangModel g = new GudangModel();
                g.setGudangkd(rs.getString("Gudang_kd"));
                g.setNamaGudang(rs.getString("Nama_Gudang"));
                g.setNamaObat(rs.getString("namaobat"));
                g.setStokobat(rs.getInt("Stok_obat"));
                list.add(g);
            }return list;
        } catch (SQLException ex) {
            Logger.getLogger(GudangDao.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GudangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GudangDao.class.getName()).log(Level.SEVERE, null, ex);
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
    Integer j;
    Integer panjang = 5;
    String sql = "select max(right(Gudang_kd, 5))from gudang";
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            if (rs.first()==false){
                kode = "KG/00001";
            }else {
                rs.last();
                s = Integer.toString(rs.getInt(1)+1);
                j = s.length();
                s1 = "";
                for (int i=0; i<panjang-j ; i++){
                    s1 = s1 +"0";
                }
                kode = "KG/"+s1+s;
            }return kode;
        } catch (SQLException ex) {
            Logger.getLogger(GudangDao.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GudangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }if (rs!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GudangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    
    }

    @Override
    public List<GudangModel> getgudangmodelid(GudangModel gudangModel) {
    PreparedStatement statement = null;
    ResultSet rs = null;
    List list = new ArrayList<>();
    
    String sql="select * from gudang where Gudang_kd=? ";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, gudangModel.getGudangkd() );
            rs = statement.executeQuery();
            while (rs.next()){
                GudangModel g = new GudangModel();
                g.setGudangkd(rs.getString("Gudang_kd"));
                g.setNamaGudang(rs.getString("Nama_Gudang"));
                g.setNamaObat(rs.getString("namaobat"));
                g.setStokobat(rs.getInt("Stok_obat"));
                list.add(g);
            }return list;
        } catch (SQLException ex) {
            Logger.getLogger(GudangDao.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GudangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GudangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
