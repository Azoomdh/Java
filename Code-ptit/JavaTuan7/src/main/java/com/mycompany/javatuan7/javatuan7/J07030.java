/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan7.javatuan7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author azoom
 */
public class J07030 {
    
    public static Set<Integer> bienDoi(ArrayList<Integer> ds){
        Set<Integer> ds2 = new HashSet<>();
        
        for(Integer t : ds){
            ds2.add(t);
        }
        
        return ds2;
    }
    
    public static ArrayList<Integer> bienDoi2(Set<Integer> ds){
        ArrayList<Integer> ds2 = new ArrayList<>();
        for(Integer t : ds){
            ds2.add(t);
        }
        
        Collections.sort(ds2);
        
        return ds2;
    }
    
    public static Boolean isSnt(Integer n){
        if(n<2){ 
            return false;
        }
        if(n==2){
            return true;
        }
        if(n%2==0){
            return false;
        }
        Double sqrt_n = Math.sqrt(n);
        for(int i=3; i<=sqrt_n; i=i+2){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//        ObjectOutputStream output1 = new ObjectOutputStream(new FileOutputStream("DATA1.in"));
//        ObjectOutputStream output2 = new ObjectOutputStream(new FileOutputStream("DATA2.in"));
//        
//        ArrayList<Integer> list1 = new ArrayList<>();
//        ArrayList<Integer> list2 = new ArrayList<>();
//        
//        for(int i=0; i<100_000; i++){
//            list1.add(new Random().nextInt(2, 1_000_000));
//            list2.add(new Random().nextInt(2, 1_000_000));
//        }
//        
//        output1.writeObject(list1);
//        output2.writeObject(list2);
        
        //--------------------------------------------------------
        
        ObjectInputStream input1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream input2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        
        Set<Integer> ds1 = bienDoi((ArrayList<Integer>) input1.readObject());
        Set<Integer> ds2 = bienDoi((ArrayList<Integer>) input2.readObject());
        
        ArrayList<Integer> ds1b = bienDoi2(ds1);
        for(Integer t : ds1b){
            Integer t2 = 1_000_000-t;
            if(t>t2){
                break;
            }
            if(
                    ds2.contains(t2)
                    && isSnt(t)== true
                    && isSnt(t2)== true
            )
            {
                System.out.println(t + " " + t2);
            }
                
        }
    }
}
