/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.Interface;

import com.ridwan.model.KategoriModel;
import com.ridwan.model.ObatModel;
import java.util.List;

/**
 *
 * @author ciwong
 */
public interface ObatInterface {
    boolean insertObat(ObatModel obatModel);
    void updateObat (ObatModel obatModel);
    boolean deleteObat (ObatModel obatModel);
    ObatModel getById(String Id);
    List<ObatModel> getObatModels();
    String setAutoNumber();
    List<ObatModel> getKategoriModels(KategoriModel kategoriModel);
    void KurangJumlahStock (int Jumlah, ObatModel obatModel);
    
}
