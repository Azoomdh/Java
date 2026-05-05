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
public class Fail_J02028_v3 {
    
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
        
        Boolean tonTaiDayThoaMan = false;
        
        Integer start=0;
        Integer end=0;
        
        Long sum = arlLongDauVao.get(0);
        
        while(start<=end && end<=arlLongDauVao.size()-1){
//            System.out.println("start, end : " + start + " " + end);
            
            if(start>=end && end<=arlLongDauVao.size()-2 ){
                end++;
                sum = sum + arlLongDauVao.get(end);
            }

            if(sum<k && end<=arlLongDauVao.size()-2){
                end++;
                sum = sum + arlLongDauVao.get(end);
            }
            
            if(sum>k && start<=end-1){
                sum = sum - arlLongDauVao.get(start);
                start++;
            }

            if(sum==k){
                tonTaiDayThoaMan=true;
                break;
            }
            
            if(start<=end && end==arlLongDauVao.size()-1){
                tonTaiDayThoaMan = false;
                break;
            }
            
        }
        
//        System.out.println("sum, start, end : " + sum + " " + start + " " + end);
//        System.out.println(arlLongToString(arlLongDauVao, start, end));

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