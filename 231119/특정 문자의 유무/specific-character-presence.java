import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        boolean triger = false;
        for(int i = 0 ; i < str.length() - 1 ; i++ ){
            if(str.substring(i, i+2).equals("ee")){
                triger = true;
                break;
            }
        }
        System.out.print(triger ? "Yes " : "No ");
        
        triger = false;
        for(int i = 0 ; i < str.length() - 1 ; i++ ){
            if(str.substring(i, i+2).equals("ab")){
                triger = true;
                break;
            }
        }

        System.out.print(triger ? "Yes" : "No");
    }
}