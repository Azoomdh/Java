package Tuan6.J05033;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05033_copy2 {

    private static Scanner sc = new Scanner(System.in);

    public static Time readTime(){
        return new Time(
            sc.nextInt(),
            sc.nextInt(),
            sc.nextInt()
        );
    }
    public static void main(String[] args) {
        Integer sobotest = sc.nextInt();

        List<Time> dsT= new ArrayList<>();
        for(int i=0; i<sobotest; i++){
            Time t = readTime();
            dsT.add(t);
        }

        Collections.sort(dsT, new TimeComparator());

        for(int i=0; i<dsT.size(); i++){
            Time t = dsT.get(i);

            System.out.println(t.getHour() + " "+ t.getMinute() + " " + t.getSecond());
        }
    }
}


class Time{
    private Integer hour;
    private Integer minute;
    private Integer second;
    public Time() {
    }
    public Time(Integer hour, Integer minute, Integer second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    public Integer getHour() {
        return hour;
    }
    public Integer getMinute() {
        return minute;
    }
    public Integer getSecond() {
        return second;
    }

    
}

class TimeComparator implements Comparator<Time> {

    @Override
    public int compare(Time o1, Time o2) {
        if(o1.getHour() > o2.getHour()){
            return 1;
        }
        else if(o1.getHour() < o2.getHour()){
            return -1;
        }
        else if(o1.getMinute() > o2.getMinute()){
            return 1;
        }
        else if(o1.getMinute() < o2.getMinute()){
            return -1;
        }
        else if(o1.getSecond() > o2.getSecond()){
            return 1;
        }
        else if(o1.getSecond() < o2.getSecond()){
            return -1;
        }
        else {
            return 0;
        }
    }
    
}

/*
3
11 20 20
14 20 14
110 15 12
*/