/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.dialog;

import com.ridwan.model.PetugasModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ciwong
 */
public class Dialog_update_petugas extends javax.swing.JDialog {
    
    private boolean modeedit;
    private PetugasModel pm;

    /**
     * Creates new form Dialog_update_petugas
     */
    public Dialog_update_petugas() {
        setModal(true);
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public PetugasModel updatePetugas (PetugasModel p){
        this.modeedit=true;
        this.pm = p;
        txt_Namapetugas.setText(p.getNama());
        txt_username.setText(p.getUsername());
        txt_password.setText(p.getPassword());
        cbo_status.setSelectedItem(p.getStatus());
        txt_alamat.setText(p.getAlamat());
        txt_telepon.setText(String.valueOf(p.getTelepon()));
        setVisible(true);
        setLocationRelativeTo(getParent());
        return pm;
    }
    
    
    private void resetfrm(){
        txt_Namapetugas.setText("");
        txt_username.setText("");
        txt_password.setText("");
        cbo_status.setSelectedIndex(0);
        txt_alamat.setText("");
        txt_telepon.setText("");
    }
    
    
    
    private boolean validasiInput(){
        boolean valid = false;
        if (txt_Namapetugas.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Nama Masih kosong");
        }else if (txt_username.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Username Masih Kosong");
        }else if (txt_password.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Password Masih Kosong");
        }else if (cbo_status.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Status Belum Dipilih");
        }else if(txt_alamat.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Alamat Masih Kosong");
        }else if (txt_telepon.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Telepon Masih Kosong");
        }
        
        else {
            valid = true;
        }
        return valid;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_Namapetugas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        btn_simpan = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_alamat = new javax.swing.JTextField();
        cbo_status = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txt_telepon = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("NAMA PETUGAS :");

        jLabel2.setText("USERNAME :");

        jLabel3.setText("PASSWORD :");

        btn_simpan.setText("SIMPAN");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_batal.setText("BATAL");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(btn_simpan)
                .addGap(32, 32, 32)
                .addComponent(btn_batal)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_simpan)
                    .addComponent(btn_batal))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel4.setText("Status :");

        jLabel5.setText("ALAMAT :");

        cbo_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-PILIH-", "ADMIN", "KASIR", "KARYAWAN" }));
        cbo_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_statusActionPerformed(evt);
            }
        });

        jLabel6.setText("TELEPON : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4))
                            .addComponent(jLabel6))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Namapetugas)
                            .addComponent(txt_username)
                            .addComponent(txt_password, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(txt_alamat)
                            .addComponent(cbo_status, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_telepon))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_Namapetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbo_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_telepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
    if (validasiInput()==true){
        String nama = txt_Namapetugas.getText();
        String username = txt_username.getText();
        char [] pwd = txt_password.getPassword();
        String password = new String(pwd);
        String Status =(String) cbo_status.getSelectedItem();
        String Alamat = txt_alamat.getText();
        String telepon = txt_telepon.getText();
        
        pm.setNama(nama);
        pm.setUsername(username);
        pm.setPassword(password);
        pm.setStatus(Status);
        pm.setAlamat(Alamat);
        pm.setTelepon(telepon);
        
        JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
        resetfrm();
        dispose();
        
    }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btn_batalActionPerformed

    private void cbo_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_statusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JComboBox cbo_status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_Namapetugas;
    private javax.swing.JTextField txt_alamat;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_telepon;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}