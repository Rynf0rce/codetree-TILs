import java.util.*;
public class Main {
    static final int MOD = 1000000007;
    static final int UNUSED = -1;
    static int n;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n + 1][9 + 1];
        init();
        for(int i=1; i<=n; i++){
            for(int j=0; j<=9; j++){
                if(j <= 8)
                    dp[i][j] = (dp[i-1][j+1] + dp[i][j]) % MOD;
                if(j >= 1)
                    dp[i][j] = (dp[i-1][j-1] + dp[i][j]) % MOD;
            }
        }
        int ans = 0;
        for (int j = 0; j <= 9; j++) {
            ans = (ans + dp[n][j]) % MOD;
        }
        System.out.println(ans);
    }
    static void init(){
        for(int i=1; i<=9; i++){
            dp[1][i] = 1;
        }
    }
}