import java.util.Scanner;

public class J03021 {

    private static Scanner sc = new Scanner(System.in);

    public static Integer change(Character c ){
        Character char1 = Character.toLowerCase(c) ;
        switch (char1) {
            case 'a':
            case 'b':
            case 'c':
                return 2;
            case 'd':
            case 'e':
            case 'f':
                return 3;
            case 'g':
            case 'h':
            case 'i':
                return 4;
            case 'j':
            case 'k':
            case 'l':
                return 5;
            case 'm':
            case 'n':
            case 'o':
                return 6;
            case 'p':
            case 'q':
            case 'r':
            case 's':
                return 7;
            case 't':
            case 'u':
            case 'v':
                return 8;
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                return 9;
            default:
                return null;
        }
    }

    public static String convertString(String s){
        StringBuilder s1 = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            s1.append(change(s.charAt(i)));
        }
        return s1.toString();
    }

    public static Boolean isOk(String s){
        int n = s.length();
        for(int i=0; i<=(n-1)/2; i++){
            if(s.charAt(i) != s.charAt(n-1-i) ){
                return false;
            }
        }
        return true;
    }

    public static void xuLy(){
        String s = sc.next();
        String s2 = convertString(s);
        if(isOk(s2)==true){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        Integer sobotest = sc.nextInt() ;

        while(sobotest-- >0){
            xuLy();
        }
    }
}

/*
2
BOHIMA
IamACoder
*/