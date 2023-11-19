import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int idx_1 = 0, idx_2 = 0;
        for(int i = 0 ; i < str.length() - 1 ; i++ ){
            if(str.substring(i, i+2).equals("ee")){
                idx_1++;
            }
        }
        
        for(int i = 0 ; i < str.length() - 1 ; i++ ){
            if(str.substring(i, i+2).equals("eb")){
                idx_2++;
            }
        }

        System.out.printf("%d %d", idx_1, idx_2);
    }
}