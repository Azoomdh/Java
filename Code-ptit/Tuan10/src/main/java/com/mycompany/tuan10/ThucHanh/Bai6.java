/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan10.ThucHanh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author azoom
 */
public class Bai6 {
    
    
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("POLYGON.in"));
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            Point p[] = new Point[n];
            for(int i = 0; i < n; i++){
                p[i] = new Point(in.nextInt(),in.nextInt());
            }
            Polygon poly = new Polygon(p);
            System.out.println(poly.getArea());
        }
    }
    
    static class Point {
        private Integer x;
        private Integer y;
        
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Integer getX() {
            return x;
        }

        public Integer getY() {
            return y;
        }
        
        public Double khoangCach(Point diemKhac){
            Integer deltaX = this.x - diemKhac.getX();
            Integer deltaY = this.y - diemKhac.getY();
            
            return Math.sqrt(deltaX*deltaX + deltaY*deltaY);
        }
    }
    
    static class Polygon {

        private ArrayList<Point> listPoint;
        
        private Polygon(Point[] polygon) {
            this.listPoint = new ArrayList<>();
            
            for(Point point : polygon){
                listPoint.add(point);
            }
        }
        
        public Double dienTichTamGiac(Point p1, Point p2, Point p3){
            Double a = p1.khoangCach(p2);
            Double b = p1.khoangCach(p3);
            Double c = p2.khoangCach(p3);
            
            Double dienTich = 
                    Math.sqrt(
                            (a+b+c)
                            * (a+b-c)
                            * (a+c-b)
                            * (b+c-a)
                    )
                    /4;
            
            return dienTich;
        }
        
        private String getArea() {
            Double dienTich = Double.valueOf("0");
            
            for(int i=0; i<=this.listPoint.size()-3; i++){
                dienTich = 
                        dienTich 
                        + 
                        this.dienTichTamGiac(
                                this.listPoint.get(i),
                                this.listPoint.get(i+1),
                                this.listPoint.get(i+2)
                        );
            }
            
            return String.format("%.3f", dienTich);
        }
    }

}
/*
2
3
0 0
1 0
0 1
4
0 0
2 0
2 2
0 2
*/