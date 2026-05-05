package Tuan6.J05033;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J05033_copy {

    private static Scanner sc = new Scanner(System.in);
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH mm ss");

    public static void main(String[] args) {
        Integer sobotest = sc.nextInt();

        List<LocalTime> dsT= new ArrayList<>();
        for(int i=0; i<sobotest; i++){
            Integer hour = sc.nextInt();
            Integer min = sc.nextInt();
            Integer sec = sc.nextInt();

            LocalTime t;
            String s = "100" + " " + min + " " + sec;
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

            System.out.println(t.getHour() + " "+ t.getMinute() + " " + t.getSecond());
        }
    }
}
/*
3
11 20 20
14 20 14
11 15 12
*/