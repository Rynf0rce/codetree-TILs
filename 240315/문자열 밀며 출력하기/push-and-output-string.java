import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(str);
        for(int i = 0 ; i < str.length() ; i++){
            System.out.println(str.substring(i + 1) + str.substring(0, i + 1));
        }
    }
}