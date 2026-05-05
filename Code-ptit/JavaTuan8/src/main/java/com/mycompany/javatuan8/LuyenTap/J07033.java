/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan8.LuyenTap;

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
public class J07033 {
    
    public static Student readStudent(Scanner sc){
        return new Student(
                sc.nextLine(),
                sc.nextLine(),
                sc.nextLine(),
                sc.nextLine()
        );
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("SINHVIEN.in"));
        
        Integer n = Integer.valueOf(sc.nextLine());
        
        ArrayList<Student> listStuA = new ArrayList<>();
        for(int i=0; i<n; i++){
            listStuA.add( readStudent(sc));
        }
        
        Collections.sort(listStuA, new StudentComparator());
        
        for(Student t : listStuA){
            System.out.println(t.toString());
        }
    }
    
    static class Student {
        private String masv;
        private String hoten;
        private String lop;
        private String email;

        public Student(String masv, String hoten, String lop, String email) {
            this.masv = masv;
            this.hoten = xuLyXau(hoten);
            this.lop = lop;
            this.email = email;
        }

        public String getMasv() {
            return masv;
        }

        public String getHoten() {
            return hoten;
        }

        public String getLop() {
            return lop;
        }

        public String getEmail() {
            return email;
        }

        @Override
        public String toString() {
            return this.masv + " " + this.hoten + " " + this.lop + " " + this.email;
        }
        
        

        private String xuLyXau(String hoten) {
            StringTokenizer sTokenizer = new StringTokenizer(hoten, " ");
            
            StringBuilder s = new StringBuilder();
            while(sTokenizer.hasMoreTokens()==true ){
                String motTu = sTokenizer.nextToken();
                System.out.println("mot tu : " + motTu);
                if(motTu.equals("")==false && motTu.equals(" ")==false){
                    motTu = xuLyMotTu(motTu);
                    s.append(motTu);
                    s.append(" ");
                }
            }
            
            s.deleteCharAt(s.length()-1);
            return s.toString();
        }
        
        private String xuLyMotTu(String motTu){
            motTu = motTu.toLowerCase();
            motTu = motTu.substring(0, 1).toUpperCase() + motTu.substring(1, motTu.length());
            
            return motTu;
        }
        
        
    }
    
    static class StudentComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            String masv1 = o1.getMasv();
            String masv2 = o2.getMasv();
            Integer soSanhMasv = masv1.compareTo(masv2);
            if(soSanhMasv>0){
                return 1;
            }
            else if(soSanhMasv<0){
                return -1;
            }
            else{
                return 0;
            }
        }
        
    }
}
