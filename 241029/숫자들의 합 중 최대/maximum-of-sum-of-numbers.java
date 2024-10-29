import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        
        int ans = 0;
        for(int i = X ; i <= Y ; i++){
            String str = String.valueOf(i);
            int val = 0;
            for(int j = str.length() - 1 ; j >= 0 ; j--){
                val += Integer.parseInt(str.charAt(j) + "");
            }
            ans = Math.max(ans, val);
        }
        System.out.print(ans);
    }
}