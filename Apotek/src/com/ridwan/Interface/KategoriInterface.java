/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.Interface;

import com.ridwan.model.KategoriModel;
import java.util.List;

/**
 *
 * @author ciwong
 */
public interface KategoriInterface {
    boolean insertKategori(KategoriModel kategoriModel);
   void updateKategori (KategoriModel kategoriModel);
    boolean deleteKategori (KategoriModel kategoriModel);
    KategoriModel getById(String Id);
    String setAutoNumber();
    List<KategoriModel> getKategoriModels();
    
}
