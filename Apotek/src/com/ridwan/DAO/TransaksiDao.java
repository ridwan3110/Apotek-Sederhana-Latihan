/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.DAO;

import com.ridwan.DBC.DBC;
import com.ridwan.Interface.ObatInterface;
import com.ridwan.Interface.PetugasInterface;
import com.ridwan.Interface.TransaksiInterface;
import com.ridwan.model.ObatModel;
import com.ridwan.model.PetugasModel;
import com.ridwan.model.ReportTransaksi;
import com.ridwan.model.Transaksi;
import com.ridwan.model.TransaksiDetail;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ciwong
 */
public class TransaksiDao  implements TransaksiInterface{
private Connection connection;
   private ObatInterface obatDao;
    private PetugasInterface petugasDao;
    private PetugasDao dao;

    public TransaksiDao() {
    connection = DBC.getConnection();
    obatDao = new ObatDao();
    }
    
    
    @Override
    public boolean InsertTransaksi(Transaksi transaksi) {
    boolean valid = false ;
    PreparedStatement statement = null;
    
    String sql = "insert into transaksi (Transaksi_kd, Tgl_Transaksi, Petugas_kd) values (?,?,?)";
    try {
        statement = connection.prepareStatement(sql);
        connection.setAutoCommit(false);
        statement.setString(1, transaksi.getTransaksikd());
        statement.setDate(2, new Date(transaksi.getTglTransaksi().getTime()));
        statement.setString(3, transaksi.getPetugas().getPetugasId());
        statement.executeUpdate();
        
        //insert ke dalam transaksi detail;
        
        
        String TRANSAKSI_SQL = "insert into trx_detail (Transaksi_kd, Obat_kd, Jumlah, Harga)"
                + "values (?, ?, ?, ?)";
        List<TransaksiDetail> detils = transaksi.getGettrTransaksiDetils();
        
        int validJumlah= 0;
        for (TransaksiDetail transaksiDetil : detils){
            statement = connection.prepareStatement(TRANSAKSI_SQL);
            statement.setString(1, transaksiDetil.getTransaksi().getTransaksikd());
            statement.setString(2, transaksiDetil.getObat().getObatKd());
            statement.setInt(3, transaksiDetil.getJumlah());
            statement.setDouble(4,transaksiDetil.getHarga());
            statement.executeUpdate();
            
            
            //proses update jumlah stock trakshir dari transaksi
            obatDao = new ObatDao();
            if (transaksiDetil.getObat().getJumlah() < transaksiDetil.getJumlah()){
                JOptionPane.showMessageDialog(null,"Jumlah obat"+transaksiDetil.getObat().getNamaObat()+
                        "Tidak Mencukupi");
                validJumlah = transaksiDetil.getObat().getJumlah() - transaksiDetil.getJumlah();
            }else {
                obatDao.KurangJumlahStock(transaksiDetil.getJumlah(), transaksiDetil.getObat());
            }
            
            
            //proses validasi stock
            if (validJumlah <0){
                connection.rollback();
                connection.setAutoCommit(true);
            }else {
                connection.commit();
                connection.setAutoCommit(true);
                valid = true;
            }
                    
                    
        }
    } catch (SQLException ex) {
        try {
            connection.rollback();
            connection.setAutoCommit(true);
        } catch (SQLException ex1) {
            Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex1);
        }
        
        Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
    }finally {
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    return valid;
    }

    
    
    @Override
    public List<ReportTransaksi> getReportTransaksis() {
        PreparedStatement statement=null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "select * from transaksi inner join trx_detail on"
                + "(transaksi.Transaksi_kd=trx_detail.Transaksi_kd)";
        
   // esultSet rs = null;
      /// List list = new ArrayList();
       // String sql = "select * from transaksi inner join barang_transaksi on "
           //    + "(transaksi.transaksi_id=barang_transaksi.transaksi_id)";
        try {
            statement = connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while (rs.next()){
                ReportTransaksi rt = new ReportTransaksi();
                Transaksi t = new Transaksi();
                t.setTransaksikd(rs.getString("transaksi.Transaksi_kd"));
                t.setTglTransaksi(rs.getDate("transaksi.Tgl_Transaksi"));
               String idKaryawan = rs.getString("transaksi.Petugas_kd");
                PetugasModel byId = petugasDao.getById(idKaryawan);
                t.setPetugas(byId);
                rt.setTransaksi(t);
                TransaksiDetail td = new TransaksiDetail();
                String Obatkd = rs.getString("trx_detail.Obat_kd");
                ObatModel byiid = obatDao.getById(Obatkd);
                td.setObat(byiid);
                td.setHarga(rs.getDouble("trx_detail.Harga"));
                td.setJumlah(rs.getInt("trx_detail.Jumlah"));
                rt.setTransaksiDetil(td);
                list.add(rt);
        }
        return list;
    } catch (SQLException ex) {
        Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
    return null;
    }finally {
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
            }if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
        
                
    
    }

    @Override
    public String KodeTransaksi() {
        PreparedStatement statement = null;
    String kode = null;
        ResultSet rs = null;
        String s, s1;
        Integer j;
        Integer panjang = 5;
        String sql = "select max(right(Transaksi_kd, 5)) from transaksi";
        
    try {
        statement = connection.prepareStatement(sql);
        rs = statement.executeQuery();
        if (rs.first()==false){
            kode = "KT/00001";
        }else {
            rs.last();
            s = Integer.toString(rs.getInt(1)+1);
            j = s.length();
            s1 ="";
            for (int i= 0; i<panjang-j; i++){
                s1 = s1+"0";
            }
            kode = "KT"+s1+s;
        }return kode;
    } catch (SQLException ex) {
        Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
     return kode;
    }finally {
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
            }if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
   
        
    }   

    @Override
    public List<ReportTransaksi> getTransaksi(java.util.Date tglMulai, java.util.Date tglAkhir) {
    PreparedStatement statement = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "select * from transaksi inner join trx_detail on "
                + "(transaksi.Transaksi_kd=trx_detail.Transaksi_kd)"
                + "where (transaksi.Tgl_Transaksi>=?) and (transaksi.Tgl_Transaksi<=?)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setDate(1, new java.sql.Date(tglMulai.getTime()));
            statement.setDate(2, new java.sql.Date(tglAkhir.getTime()));
            rs=statement.executeQuery();
            while (rs.next()){
                ReportTransaksi rt = new ReportTransaksi();
                Transaksi t = new Transaksi();
                t.setTransaksikd(rs.getString("transaksi.Transaksi_kd"));
                t.setTglTransaksi(rs.getDate("transaksi.Tgl_Transaksi"));
               String idKaryawan = rs.getString("transaksi.Petugas_kd");
               PetugasModel byId = petugasDao.getById(idKaryawan);
                t.setPetugas(byId);
                rt.setTransaksi(t);
                TransaksiDetail td = new TransaksiDetail();
                String barangId = rs.getString("trx_detail.Obat_kd");
                ObatModel byId1 = obatDao.getById(barangId);
                td.setObat(byId1);
                td.setHarga(rs.getDouble("trx_detail.Harga"));
                td.setJumlah(rs.getInt("trx_detail.Jumlah"));
                rt.setTransaksiDetil(td);
                list.add(rt);
                
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }


    @Override
    public List<ReportTransaksi> getTransaksi(Transaksi transaksi) {
    PreparedStatement statement = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "select * from transaksi inner join trx_detail on "
                + "(transaksi.Transaksi_kd=trx_detail.Transaksi_kd)"
                + "where transaksi.Transaksi_kd=?";
    try {
        statement = connection.prepareStatement(sql);
            statement.setString(1, transaksi.getTransaksikd());
            rs=statement.executeQuery();
            while (rs.next()){
                ReportTransaksi rt = new ReportTransaksi();
                Transaksi t = new Transaksi();
                t.setTransaksikd(rs.getString("transaksi.Transaksi_kd"));
                t.setTglTransaksi(rs.getDate("transaksi.Tgl_Transaksi"));
               // String idPetugas = rs.getString("transaksi.Petugas_kd");
            //PetugasModel byId = petugasDao.getById(idPetugas);
             //   t.setPetugas(byId);
                rt.setTransaksi(t);
                TransaksiDetail td = new TransaksiDetail();
                String barangId = rs.getString("trx_detail.Obat_kd");
                ObatModel byId1 = obatDao.getById(barangId);
                td.setObat(byId1);
                td.setHarga(rs.getDouble("trx_detail.Harga"));
                td.setJumlah(rs.getInt("trx_detail.Jumlah"));
                rt.setTransaksiDetil(td);
                list.add(rt);
            }return list;
    } catch (SQLException ex) {
        Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
    return null;
    }finally {
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }if (rs!=null){
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
            
   }
 }

    
   