import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class J03009 {
    private static Scanner sc = new Scanner(System.in);

    public static Set<String> phanTach(String s){
        Set<String> setString1 = new HashSet<>();

        StringTokenizer stringTokenizer1 = new StringTokenizer(s);

        while(stringTokenizer1.hasMoreTokens()== true){
            String s1 = stringTokenizer1.nextToken();
            setString1.add(s1);
        }

        return setString1;
    }

    public static void xuLy(){
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        // System.out.println(phanTach(s1).toString());

        Set<String> set1 = phanTach(s1);
        Set<String> set2 = phanTach(s2);

        ArrayList<String> a = new ArrayList<>();

        for(String stringOfSet1 : set1){
            if(set2.contains(stringOfSet1)==false){
                a.add(stringOfSet1);
            }
        } 
        
        Comparator<String> comp1 = new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
            
        };

        Collections.sort(a, comp1);

        // System.out.println(a);

        for(String o1 : a){
            System.out.print(o1+ " ");
        }

        System.out.println("");
        
    }

    public static void main(String[] args) {
        Integer sobotest = Integer.parseInt(sc.nextLine());

        while(sobotest-- >0){
            xuLy();
        }
    }
}

/*
2
abc ab ab ab abcd
ab abc
aaa xyz ab zzz abc dd dd abc
xyz dd ttt sas cdc
*/