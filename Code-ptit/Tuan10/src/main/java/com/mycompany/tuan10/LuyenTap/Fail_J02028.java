package com.mycompany.tuan10.LuyenTap;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author azoom
 */
public class Fail_J02028 {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        Integer sobotest = sc.nextInt();
        
        while(sobotest-- >0){
            xuLy();
        }
    }

    private static void xuLy() {
        Integer n = sc.nextInt();
        Long k = sc.nextLong();
        
        ArrayList<Long> arlLongDauVao = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            arlLongDauVao.add(sc.nextLong());
        }
        
        Boolean thoatFor1 = false;
        Boolean thoatFor2 = false;
        Boolean tonTaiDayThoaMan = false;
        
        Integer start=0;
        Integer end=0;
        
        for(int i=0; i<=arlLongDauVao.size()-2; i++){
            thoatFor1 = false;
            
            Long sum = arlLongDauVao.get(i);
            
            for(int j=i+1; j<=arlLongDauVao.size()-1; j++){
                thoatFor2 = false;
                
                sum = sum + arlLongDauVao.get(j);
                
                if(sum==k){
                    thoatFor2 = true;
                    thoatFor1 = true;
                    tonTaiDayThoaMan = true;
                    
                    start = i;
                    end = j;
                }
                else if(sum>k){
                    thoatFor2 = true;
                }
                else if(sum<k){
                    // doesnt do
                }
                
                if(thoatFor2==true){
                    break;
                }
            }
            
            if(thoatFor1==true){
                break;
            }
        }
        
        
        if(tonTaiDayThoaMan==true){
            System.out.println("YES");
//            System.out.println(arlLongToString(arlLongDauVao, start, end));
        }
        else{
            System.out.println("NO");
        }
    }
    
    private static String arlLongToString(ArrayList<Long> arlLongA1, Integer begin, Integer end){
        String s = "";
        for(int i= begin; i<=end; i++){
            s = s + arlLongA1.get(i) + " ";
        }
        
        s = s.trim();
        
        return s;
    }
}

/*
3
6 33
1 4 20 3 10 5
7 7
1 4 0 0 3 10 5
2 0
1 4
*/