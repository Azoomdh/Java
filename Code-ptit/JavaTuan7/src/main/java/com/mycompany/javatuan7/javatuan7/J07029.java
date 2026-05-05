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
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 *
 * @author azoom
 */
public class J07029 {
    
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
//        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("DATA.in"));
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("DATA.in"));
        
//        ArrayList<Integer> dsT = new ArrayList<>();
//        for(int i=0; i<10_000; i++){
//            dsT.add(new Random().nextInt(1, 500));
//        }
//        output.writeObject(dsT);
        
        ArrayList<Integer> dsT2 = (ArrayList<Integer>) input.readObject();
        
        Map<Integer, Integer> map3 = new TreeMap<>();
        for(Integer t2 : dsT2){
            if(isSnt(t2)==true){
                if(map3.containsKey(t2)==true){
                    Integer soluong = map3.get(t2);
                    soluong++;
                    map3.put(t2, soluong);
                }
                else{
                    map3.put(t2, 1);
                }
            }
        }
        
        ArrayList<Item> dsT4 = new ArrayList<>();
        
        if(map3.size()<10){
            for(Integer t : map3.keySet()){
                dsT4.add(new Item(t, map3.get(t)));
            }
        }
        else{
            int i = 0;
            int n = map3.size();
            for(Integer t : map3.keySet()){
                if(i>=n-10){
                    dsT4.add(new Item(t, map3.get(t)));
                }
                i++;
            }
        }
        
        ArrayList<Item> dsT5 = new ArrayList<>();
        for(int i=dsT4.size()-1; i>-1; i=i-1){
            dsT5.add(dsT4.get(i));
        }
        
        for(Item t : dsT5){
            System.out.println(t.toString());
        }
    }
    
    static class Item{
        private Integer t1;
        private Integer t2;

        public Item(Integer t1, Integer t2) {
            this.t1 = t1;
            this.t2 = t2;
        }

        public Integer getT1() {
            return t1;
        }

        public Integer getT2() {
            return t2;
        }

        @Override
        public String toString() {
            return this.t1 + " " + this.t2;
        }
        
        
    }
}


