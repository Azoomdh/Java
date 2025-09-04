import java.util.Scanner;

public class J03027 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String s = sc.next();
        Boolean running = true;
        while(running==true ){
            running = false;
            for(int i=0; i<s.length()-1; i++){
                if(s.charAt(i)==s.charAt(i+1) ){
                    s = s.substring(0, i) + s.substring(i+2, s.length());
                    running = true;
                }
                // System.out.println("🟩🟩🟩"+ s);
            }
        }
        if(s.isEmpty()== true){
            System.out.println("Empty String");
        }
        else{
            System.out.println(s);
        }
    }
}
