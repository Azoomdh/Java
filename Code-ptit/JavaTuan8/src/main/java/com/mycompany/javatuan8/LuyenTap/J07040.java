/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan8.LuyenTap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 *
 * @author azoom
 */
public class J07040 {
    
    public static ArrayList<String> readA(ObjectInputStream inputA) throws IOException, ClassNotFoundException{
        return (ArrayList<String>) inputA.readObject();
    }
    
    public static ArrayList<String> readB(Scanner inputB){
        ArrayList<String> listB= new ArrayList<>();
        while(inputB.hasNextLine()==true ){
            String s = inputB.nextLine();
            listB.add(s);
        }
        return listB;
    }
    
    public static ArrayList<String> convertToWordArray(String s){
        ArrayList<String> list2 = new ArrayList<>();
        
        s = s.toLowerCase();
        
        StringTokenizer sTokenizer = new StringTokenizer(s, " ");
        
        while(sTokenizer.hasMoreTokens()==true ){
            String sTemp = sTokenizer.nextToken();
            if(list2.contains(sTemp)==true ){
                // doesnt do
            }
            else{
                list2.add(sTemp);
            }
        }
        
        return list2;
    }
    
    public static ArrayList<String> convertToWordArray(ArrayList<String> list){
        
        ArrayList<String> list2 = new ArrayList<>();
        
        for(String motCau : list){
            ArrayList<String> listTemp = convertToWordArray(motCau);
            
            for(String motTu : listTemp){
                if(list2.contains(motTu)==true ){
                    // doesnt do
                }
                else {
                    list2.add(motTu);
                }
            }
        }
        
        return list2;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream inputA = new ObjectInputStream(new FileInputStream("NHIPHAN.in"));
        Scanner inputB = new Scanner(new FileInputStream("VANBAN.in"));
        
        ArrayList<String> listA = readA(inputA);
        ArrayList<String> listB = readB(inputB);
        
        ArrayList<String> listA2 = convertToWordArray(listA);
        ArrayList<String> listB2 = convertToWordArray(listB);
        
        for(String b : listB2){
            if(listA2.contains(b)==true){
                System.out.println(b);
            }
        }
    }
}
