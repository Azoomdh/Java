/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan10.ThucHanh;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author azoom
 */
public class Bai1 {
//    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("MATRIX.in"));
        
        Integer sobotest = sc.nextInt();
        
        while(sobotest-- >0){
            xuLy(sc);
        }
    }

    private static void xuLy(Scanner sc) {
        Integer var_n = sc.nextInt();
        Integer var_m = sc.nextInt();
        Integer var_i = sc.nextInt();
        
        ArrayList< ArrayList<Integer> > matranA1 = new ArrayList<>();
        
        for(int i=0; i<var_n; i++){
            ArrayList<Integer> motHang = new ArrayList<>();
            
            for(int j=0; j<var_m; j++){
                motHang.add(sc.nextInt());
            }
            
            matranA1.add(motHang);
        }
        
        ArrayList<Integer> cotThuI = new ArrayList<>();
        
        for(int i=0; i<matranA1.size(); i++){
            cotThuI.add(matranA1.get(i).get(var_i-1));
        }
        
        Collections.sort(cotThuI);
//        System.out.println(cotThuI.toString());
        
        ArrayList< ArrayList<Integer> > matranA2 = new ArrayList<>();
        
        for(int i=0; i<matranA1.size(); i++){
            ArrayList<Integer> motHang2 = new ArrayList<>();
            for(int j=0; j<matranA1.get(i).size(); j++){
                if(j==var_i-1){
                    motHang2.add(cotThuI.get(i));
                }
                else{
                    motHang2.add(matranA1.get(i).get(j));
                }
            }
            matranA2.add(motHang2);
        }
        
        for(ArrayList<Integer> motHang : matranA2){
            for(Integer a : motHang){
                System.out.print(a + " ");
            }
            System.out.println("");
        }
    }
    
    
}
/*
1
2 2 1
90 49 85 88
*/