import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class Class1{

    private static Scanner sc = new Scanner(System.in);

    public static User docUser(){
            String username1 = sc.next();
            String password1 = sc.next();
            User user1 = new User(username1, password1);

            return user1;
    }

    public static ArrayList<User> docUser(Integer n){
        ArrayList<User> dsUser = new ArrayList<>();

        for(int i=0; i<n; i++){
            dsUser.add(docUser());
        }

        return dsUser;
    }

    public static Integer timKiem(ArrayList<User> dsUser, User user1){
        for(int i=0; i<dsUser.size(); i++){
            // System.out.println(dsUser.get(i).toString());
            // System.out.println(user1.toString());
            // System.out.println("");
            if(dsUser.get(i).getUsername().equals(user1.getUsername()) && dsUser.get(i).getPassword().equals(user1.getPassword()) ){
                // System.out.println("🟩"+i);
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer n = sc.nextInt();
        
        ArrayList<User> dsUser = new ArrayList<>();

        for(int i=0; i<n; i++){
            dsUser.add(docUser());
        }
        // System.out.println(dsUser.toString());

        Integer m = sc.nextInt();
        
        ArrayList<Integer> a = new ArrayList<>();

        for(int i=0; i<n; i++){
            a.add(0);
        }

        while(m-- >0){
            User user1 = docUser();

            Integer i = timKiem(dsUser, user1);
            // System.out.println(user1.toString());
            if(i!=-1){
                a.set(i, a.get(i)+1);
            }
        }

        for(int i=0; i<n; i++){
            System.out.print(a.get(i)+ " ");
        }
        
    }
}

class User {
    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "[" + username + ", " + password + "]";
    }


    
}

/*
4
tendangnhap matkhau
username password
nguoidung m4tkh4un4yr4tb40m4t
user2 password
6
tendangnhap matkhau
username matkhau
bfc34 contest
username password
tendangnhap matkhau
user2 password
*/