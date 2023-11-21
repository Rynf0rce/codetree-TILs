import java.util.*;

public class Main {
    public static boolean mulAlpha(String str){
        for(int i = 0 ; i < str.length() ; i++){
            for(int j = i + 1 ; j < str.length(); j++){
                if(str.charAt(i) == str.charAt(j)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(mulAlpha(str) ? "Yes" : "No");
    }
}