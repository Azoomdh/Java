/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan7.javatuan7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azoom
 */
public class J07005 {
    
    public static void main(String[] args) {
        try {
//            DataOutputStream output = new DataOutputStream(new FileOutputStream("DATA.IN"));
//            for(int i=0; i<100; i++){
//                output.writeInt(i*3);
//            }
            
            DataInputStream input = new DataInputStream(new FileInputStream("DATA.IN"));
            
            int[] arr = new int[1000];
            
            for(int i=0; i<100_000; i++){
                arr[input.readInt()]++;
            }
            
            for(int i=0; i<1000; i++){
                if(arr[i]>0){
                    System.out.println(i + " " + arr[i]);
                }
            }
        }
        catch (FileNotFoundException ex) {
            // ...
        }
        catch (IOException ex) {
            Logger.getLogger(J07005.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
