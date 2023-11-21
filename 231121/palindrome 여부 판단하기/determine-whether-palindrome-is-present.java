import java.util.*;

public class Main {
    public static boolean palindrome(String str){
        String comStr = new String(str);
        for(int i = 0 ; i < comStr.length() / 2 ; i++){
            if(comStr.charAt(i) != comStr.charAt(comStr.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(palindrome(str) ? "Yes" : "No");
    }
}