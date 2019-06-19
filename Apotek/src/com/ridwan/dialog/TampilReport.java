/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.dialog;

import javax.swing.JDialog;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author ciwong
 */
public class TampilReport extends JDialog{
    private String title;
    private JRViewer jv;

    public TampilReport(String title, JRViewer jv) {
        this.title = title;
        this.jv = jv;
        atur();
    }
    
    private void atur (){
        setSize(900, 700);
        setLocationRelativeTo(null);
        setTitle(title);
        getContentPane().add(jv);
        setVisible(true);
        
    }
    
    
    
}
