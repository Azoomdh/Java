/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan8.LuyenTap;

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
import java.util.TreeSet;

/**
 *
 * @author azoom
 */
public class J07032 {
    
    public static Integer countNumberItem(ArrayList<Integer> listA, Integer x){
        Integer num=0;
        for(Integer a : listA){
            if(a.equals(x)==true ){
                num++;
            }
        }
        return num;
    }
    
    public static Boolean isOkPart1(Integer n){
        String s = n.toString();
        if(s.length() < 2){
            return false;
        }
        if(s.length()%2==0){
            return false;
        }
        for(Character c : s.toCharArray()){
            if
            /*condition*/(
                    c.equals('0')
                    || c.equals('2')
                    || c.equals('4')
                    || c.equals('6')
                    || c.equals('8')
            )
            {
                return false;
            }
            else {
                // doesnt do
            }
        }
        return true;
    }
    
//    public static ArrayList<Integer> generateArrayList(Integer memberNum){
//        ArrayList<Integer> listA1 = new ArrayList<>();
//        for(int i=0; i<memberNum; i++){
//            listA1.add(new Random().nextInt(0, 1_000_000));
//        }
//        
//        return listA1;
//    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//        ObjectOutputStream outputA = new ObjectOutputStream(new FileOutputStream("DATA1.in"));
//        ObjectOutputStream outputB = new ObjectOutputStream(new FileOutputStream("DATA2.in"));
//        
//        ArrayList<Integer> listA1 = generateArrayList(1_000_000);
//        ArrayList<Integer> listB1 = generateArrayList(1_000_000);
//        
//        outputA.writeObject(listA1);
//        outputB.writeObject(listB1);
//        
////        System.out.println("A1");
        // ---------------------------------------------
        
        ObjectInputStream inputA = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream inputB = new ObjectInputStream(new FileInputStream("DATA2.in"));
        
        ArrayList<Integer> listA2 = (ArrayList<Integer>) inputA.readObject();
        ArrayList<Integer> listB2 = (ArrayList<Integer>) inputB.readObject();
        
//        System.out.println("A2");
        
        HashSet<Integer> listA3 = new HashSet<>();
        HashSet<Integer> listB3 = new HashSet<>();
        
        listA3.addAll(listA2);
        listB3.addAll(listB2);
        
//        System.out.println("A3");
        
        ArrayList<Integer> listA4 = new ArrayList<>();
        ArrayList<Integer> listB4 = new ArrayList<>();
        
        listA4.addAll(listA3);
        listB4.addAll(listB3);
        
//        System.out.println("A4");

        Collections.sort(listA4);
        Collections.sort(listB4);
        
//        System.out.println("A5");
        
        Integer soLuongDaThoaMan=0;
        for(int i=0; i<listA4.size(); i++){
            if(soLuongDaThoaMan>=10){
                break;
            }
            Integer temp = listA4.get(i);
            if(isOkPart1(temp)==true && listB4.contains(temp)==true){
                Integer soLuong = countNumberItem(listA2, temp) + countNumberItem(listB2, temp);
                System.out.println(temp + " " + soLuong);
                soLuongDaThoaMan++;
            }
        }
        
//        System.out.println("A6");
    }
}
