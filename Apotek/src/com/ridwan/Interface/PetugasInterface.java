/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.Interface;

import com.ridwan.model.PetugasModel;
import java.util.List;

/**
 *
 * @author ciwong
 */
public interface PetugasInterface {
    boolean insertPetugas (PetugasModel petugasModel);
    void updatePetugas (PetugasModel petugasModel);
    boolean deletePetugas (PetugasModel petugasModel);
    PetugasModel getById (String Id);
    List<PetugasModel> petugasModels();
    String setAutonumber();
    PetugasModel loginPetugas (String Username, String Password);
    boolean ubahPassword (String oldUsername, String oldPassword, String newUsername, String newPassword);
}
