import java.util.*;

public class Main {
    public static final int MAX_COST = 100000;
    public static final int MAX_INT = (int)1e9;
    public static int[] DP = new int[MAX_COST + 1];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1 ; i <= n ; i++){
            DP[i] = MAX_INT;
        }

        int ans = 0;
        while(n != 0){
            if(n / 7 > 0){
                ans += n / 7;
                n = n % 7;
            }
            else if(n / 5 > 0){
                ans += n / 5;
                n = n % 5;
            }
            else if(n / 2 > 0){
                ans += n / 2;
                n = n % 2;
            }
            else{
                ans += n;
                n = 0;
            }
        }
        System.out.print(ans);
    }
}