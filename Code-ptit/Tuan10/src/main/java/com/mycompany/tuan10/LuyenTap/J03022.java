/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan10.LuyenTap;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author azoom
 */
public class J03022 {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        String s = "";
        
        while(sc.hasNext()==true ){
            s = s + sc.next().toLowerCase() + " ";
        }
        
        s = s.trim();
        
        ArrayList<String> listA1 = phanTachCau(s);
        ArrayList<String> listA2 = chuanHoaTungCau(listA1);
        
        for(String sTemp : listA2){
            System.out.println(sTemp);
        }
    }

    private static ArrayList<String> phanTachCau(String s) {
        ArrayList<String> listA1 = new ArrayList<>();
        
        StringTokenizer stringTokenizer = new StringTokenizer(s, ".?!");
        
        while(stringTokenizer.hasMoreTokens()==true ){
            listA1.add(stringTokenizer.nextToken());
        }
        
        return listA1;
    }

    private static ArrayList<String> chuanHoaTungCau(ArrayList<String> listA1) {
        ArrayList<String> listA2 = new ArrayList<>();
        
        for(String s : listA1){
            String sTemp = chuanHoaMotCau(s);
            listA2.add(sTemp);
        }
        
        return listA2;
    }

    private static String chuanHoaMotCau(String s) {
        String sDaChuanHoa = "";
        
        s = s.trim();
        s = s.toLowerCase();
        
        StringTokenizer stringTokenizer = new StringTokenizer(s, " ");
        
        while(stringTokenizer.hasMoreTokens()==true ){
            sDaChuanHoa = sDaChuanHoa + stringTokenizer.nextToken() + " ";
        }
        
        sDaChuanHoa = sDaChuanHoa.trim();
        
        sDaChuanHoa = sDaChuanHoa.substring(0,1).toUpperCase() + sDaChuanHoa.substring(1, sDaChuanHoa.length()).toLowerCase();
        
        return sDaChuanHoa;
    }
}

/*
ky thi LAP TRINH ICPC PTIT  bat dau to chuc     tu     nam 2010. nhu vay, nam nay la          tron 10 nam!
    vay CO PHAI NAM NAY LA KY THI LAN THU 10?        khong phai! nam nay la KY THI LAN THU 11.
*/