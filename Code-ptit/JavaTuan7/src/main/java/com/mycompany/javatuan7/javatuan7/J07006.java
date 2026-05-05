/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan7.javatuan7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azoom
 */
public class J07006 {
    public static void main(String[] args) {
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("DATA.in"));
            
            ArrayList<Integer> dsT = (ArrayList<Integer>) input.readObject();
            
            int[] arr = new int[1000];
            for(Integer t : dsT){
                arr[t]++;
            }
            
            for(int i=0; i<arr.length; i++){
                if(arr[i]>0){
                    System.out.println(i + " " + arr[i]);
                }
            }
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(J07006.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(J07006.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(J07006.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
