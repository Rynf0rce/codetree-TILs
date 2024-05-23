import java.util.*;
public class Main {
    public static int INVALID = (int) 1e9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = INVALID;
        int cnt = 0;
        while(5 * cnt <= n){
            if( (n - 5 * cnt) % 2 == 0 ){
                ans = Math.min(ans, cnt + ((n - 5 * cnt) / 2));
            }
            cnt++;
        }
        System.out.print(ans == INVALID ? -1 : ans);
    }
}