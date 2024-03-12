import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 1000;
    public static final int MOD = 10007;
    public static int[][] DP = new int[MAX_LENGTH + 1][6];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DP[0][0]=1;
        for(int i = 1 ; i <= n ; i++){
            DP[i][0] = DP[i - 1][1] % MOD + DP[i - 1][2] % MOD + DP[i - 1][5] % MOD;
            DP[i][1] = DP[i - 1][0] % MOD + DP[i - 1][4] % MOD;
            DP[i][2] = DP[i - 1][0] % MOD + DP[i - 1][3] % MOD;
            DP[i][3] = DP[i - 1][2] % MOD;
            DP[i][4] = DP[i - 1][1] % MOD;
            DP[i][5] = DP[i - 1][0] % MOD;
        }
        System.out.print(DP[n][0]);
    }
}