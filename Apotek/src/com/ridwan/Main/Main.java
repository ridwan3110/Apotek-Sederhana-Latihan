/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.Main;

import com.ridwan.DBC.DBC;



/**
 *
 * @author ciwong
 */
public class Main {
    public static void main (String [] args){
        DBC.getConnection(); 
        
        System.out.print("Oke");
    }
    
}
