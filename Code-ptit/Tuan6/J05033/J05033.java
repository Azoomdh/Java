package Tuan6.J05033;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J05033 {

    private static Scanner sc = new Scanner(System.in);
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH mm ss");

    public static void main(String[] args) {
        Integer sobotest = Integer.parseInt(sc.nextLine());

        List<LocalTime> dsT= new ArrayList<>();
        for(int i=0; i<sobotest; i++){
            String s = sc.nextLine();
            LocalTime t;
            
            try {
                t = LocalTime.parse(s, dateTimeFormatter);
                dsT.add(t);
            } 
            catch (Exception e) {
                // doesnt do
            }
        }

        Collections.sort(dsT);

        for(int i=0; i<dsT.size(); i++){
            LocalTime t = dsT.get(i);
            // String s = t.getHour() + " "+ t.getMinute() + " " + t.getSecond();
            String s = dsT.get(i).format(dateTimeFormatter);
            System.out.println(s);
            // System.out.println(t.getHour() + " "+ t.getMinute() + " " + t.getSecond());
        }
    }
}
/*
3
11 20 20
14 20 14
11 15 12
*/