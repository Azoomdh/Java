/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan9.LuyenTap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author azoom
 */
public class Fail_J07071 {
    
    private static TenVietTat readTenVietTat(Scanner sc) {
        return new TenVietTat(
                sc.nextLine().trim()
        );
    }

    private static TenDayDu readTenDayDu(Scanner sc) {
        return new TenDayDu(
                sc.nextLine().trim()
        );
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("DANHSACH.in"));
        
        Integer n = Integer.valueOf(sc.nextLine().trim());
        
        ArrayList<TenDayDu> listA1 = new ArrayList<>();
        for(int i=0; i<n; i++){
            TenDayDu aTemp = readTenDayDu(sc);
            listA1.add(aTemp);
        }
        
        Integer m = Integer.valueOf(sc.nextLine().trim());
        
        ArrayList<TenVietTat> listB1 = new ArrayList<>();
        for(int i=0; i<m; i++){
            TenVietTat bTemp = readTenVietTat(sc);
            listB1.add(bTemp);
        }
        
        ArrayList<TenDayDu> listA2 = new ArrayList<>();
        for(TenDayDu a : listA1){
            for(TenVietTat b : listB1){
                if(CompareUtil.isEqual(a.getTenVietTat(), b.getTenVietTat())==true ){
                    listA2.add(a);
                    break; 
                    // break de thoat khoi vong lap : for(TenVietTat b : listB1)
                }
            }
        }
        
        Collections.sort(listA2, new Comparator_TenDayDu());
        
        for(TenDayDu a2 : listA2){
            System.out.println(a2.toString());
        }
    }




    
    static class TenDayDu{
        private String ho;
        private String ten;

        public TenDayDu(String tenDayDu) {
            StringTokenizer sTokener = new StringTokenizer(tenDayDu, " ");
            
            ArrayList<String> listTenDayDu = new ArrayList<>();
            while(sTokener.hasMoreTokens()==true ){
                listTenDayDu.add(sTokener.nextToken());
            }
            
            this.ho= "";
            this.ten= "";
            
            for(int i=0; i<=listTenDayDu.size()-2; i++){
                this.ho = this.ho + listTenDayDu.get(i) + " ";
            }
            this.ho = this.ho.trim();
            
            this.ten = listTenDayDu.get(listTenDayDu.size()-1);
        
        }

        @Override
        public String toString() {
            return this.ho + " " + this.ten;
        }
        
        public String getTenVietTat(){
            String tenVietTat = "";
            
            StringTokenizer sTokenizer = new StringTokenizer(this.ho+ " " + this.ten, " ");
            while(sTokenizer.hasMoreTokens()==true ){
                String motTu = sTokenizer.nextToken();
                tenVietTat = tenVietTat + motTu.substring(0, 1).toUpperCase();
            }
            
            return tenVietTat;
        }

        public String getHo() {
            return ho;
        }
        
        public String getTen() {
            return ten;
        }
        
    }
    
    static class Comparator_TenDayDu implements Comparator<TenDayDu> {

        @Override
        public int compare(TenDayDu o1, TenDayDu o2) {
            String ten1 = o1.getTen();
            String ten2 = o2.getTen();
            Integer soSanhTen = ten1.compareTo(ten2);
            
            String ho1 = o1.getHo();
            String ho2 = o2.getHo();
            Integer soSanhHo = ho1.compareTo(ho2);
            
            if(soSanhTen>0){
                return 1;
            }
            else if(soSanhTen<0){
                return -1;
            }
            else if(soSanhHo>0){
                return 1;
            }
            else if(soSanhHo<0){
                return -1;
            }
            else{
                return 0;
            }
        }
        
    }
    
    static class TenVietTat{
        private String tenVietTat;

        public TenVietTat(String tenVietTatString) {
            this.tenVietTat = "";
            
            StringTokenizer sTokenizer = new StringTokenizer(tenVietTatString, ".");
            while(sTokenizer.hasMoreTokens()==true ){
                tenVietTat = tenVietTat + sTokenizer.nextToken();
            }
        }

        @Override
        public String toString() {
            String s = "";
            for(Character c : this.tenVietTat.toCharArray()){
                s = s + c + ".";
            }
            
            s = s.substring(0, s.length()-1);
            
            return s;
        }

        public String getTenVietTat() {
            return tenVietTat;
        }
    }
    
    static class CompareUtil {
        public static Boolean isEqual(Character c1, Character c2){
            if(c1.equals('*')==true || c2.equals('*')==true ){
                return true;
            }
            else if(c1.equals(c2)==true){
                return true;
            }
            else{
                return false;
            }
        }
        
        public static Boolean isEqual(String s1, String s2){
            if(s1.length()!=s2.length()){
                return false;
            }
            
            for(int i=0; i<s1.length(); i++){
                Character cTemp1 = s1.charAt(i);
                Character cTemp2 = s2.charAt(i);

                if(CompareUtil.isEqual(cTemp1, cTemp2)==true ){
                    // doesnt do
                }
                else {
                    return false;
                }
            }
            return true;
        }
    }
}

/*
16
Nguyen Manh Son
Ngo Minh Tuan
Nguyen Manh Hung
Tran Trung Dung
Nguyen Manh Son
Ngo Minh Tuan
Nguyen Manh Hung
Tran Trung Dung
Nguyen Manh Son
Ngo Minh Tuan
Nguyen Manh Hung
Tran Trung Dung
Nguyen Manh Son
Ngo Minh Tuan
Nguyen Manh Hung
Tran Trung Dung
2
N.M.*
T.T.*
*/