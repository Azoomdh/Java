/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan10.ThucHanh;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azoom
 */
public class Bai3 {
    
    public static Boolean isOk1(Integer n){
        if(n<100){
            return false;
        }
        
        String s = n.toString();
        
        for(int i=0; i<=s.length()/2-1; i++){
            Character c1 = s.charAt(i);
            Character c2 = s.charAt(n-1-i);
            if(c1.equals(c2)==false ){
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        try {
            ObjectInputStream inputA = new ObjectInputStream(new FileInputStream("DAYSO.DAT"));
            ArrayList<Integer> listA1 = (ArrayList<Integer>) inputA.readObject();
            TreeSet<Integer> listA2 = new TreeSet<>();
            listA2.addAll(listA1);
            for(Integer a2 : listA2){
                if(isOk1(a2)==true){
                    System.out.println(a2);
                }
            }
        }
        catch (FileNotFoundException ex) {
//            Logger.getLogger(Bai3.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
//            Logger.getLogger(Bai3.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex) {
//            Logger.getLogger(Bai3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
