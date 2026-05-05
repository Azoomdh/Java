package com.mycompany.javatuan7.javatuan7;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author azoom
 */
public class J07015_TLE {
    
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
//        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("SONGUYEN.in"));
//        ArrayList<Integer> dsT2 = new ArrayList<>();
//        for(int i=0; i<10000; i++){
//            Integer temp = new Random().nextInt(0, 9999);
//            dsT2.add(temp);
//        }
//        output.writeObject(dsT2);
        
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("SONGUYEN.in"));
        
        ArrayList<Integer> dsT = (ArrayList<Integer>) input.readObject();
        
        int[] arr = new int[10_000];
        for(Integer t : dsT){
            if(isSnt(t)==true ){
                arr[t]++;
            }
        }
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]>0){
                System.out.println(i + " " + arr[i]);
            }
        }
    }
}
