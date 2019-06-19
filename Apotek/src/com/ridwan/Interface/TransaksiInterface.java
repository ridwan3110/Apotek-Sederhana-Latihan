/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.Interface;

import com.ridwan.model.ReportTransaksi;
import com.ridwan.model.Transaksi;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ciwong
 */
public interface TransaksiInterface {
    boolean InsertTransaksi (Transaksi transaksi);
    List<ReportTransaksi> getReportTransaksis();
    List<ReportTransaksi> getTransaksi(Date tglMulai, Date tglAkhir);
    List<ReportTransaksi> getTransaksi(Transaksi transaksi);
    String KodeTransaksi ();
    
}
