package com.mycompany.tuan10.LuyenTap;

import java.util.Locale;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author azoom
 */
public class J04009 {

    private static Point readPoint() {
        return new Point(
                sc.nextDouble(), 
                sc.nextDouble()
        );
    }
    
    private static Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    
    public static void main(String[] args) {
        Integer sobotest = sc.nextInt();
        
        while(sobotest-- >0){
            xuLy();
        }
    }

    private static void xuLy() {
        Point diemA = readPoint();
        Point diemB = readPoint();
        Point diemC = readPoint();
        
        double a = diemB.distance(diemC);
        double b = diemA.distance(diemC);
        double c = diemB.distance(diemA);
        
        if
        /*dieu kien*/(
                a+b>c
                && a+c>b
                && b+c>a
        )
        {

            double dienTich = 
                    Math.sqrt(a+b+c)
                    *
                    Math.sqrt(a+b-c)
                    *
                    Math.sqrt(b+c-a)
                    *
                    Math.sqrt(c+a-b)
                    /4
                    ;

            System.out.println( String.format("%.2f", dienTich));
        }
        else {
            System.out.println("INVALID");
            return;
        }
        
    }
}

class Point{
    private double x;
    private double y;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p2) {
        this.x = p2.getX();
        this.y = p2.getY();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Point p2){
        double deltaX = this.x - p2.getX();
        double deltaY = this.y - p2.getY();
        return Math.sqrt(
                Math.pow(deltaX, 2)
                +
                Math.pow(deltaY, 2)
        );
    }

    public double distance(Point p1, Point p2){
        return p1.distance(p2);
    }

    @Override
    public String toString() {
        return this.x + " " + this.y;
    }


}

/*
3
0 0 0 5 0 199
1 1 1 1 1 1
0 0 0 5 5 0
*/