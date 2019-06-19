/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.Interface;

import com.ridwan.model.GudangModel;
import java.util.List;

/**
 *
 * @author ciwong
 */
public interface GudangInterface {
    
    boolean insertGudang (GudangModel gudangModel);
    void updateGudang (GudangModel gudangModel);
    boolean deleteGudang (GudangModel gudangModel);
     GudangModel getById (String Id);
    List<GudangModel> getgudangModels();
    List<GudangModel> getgudangmodelid(GudangModel gudangModel);
    String setAutonumber();
    
}
