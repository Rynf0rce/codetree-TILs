import java.util.*;
public class Main {
    public static final int MAX_LENGTH = 1000;
    public static final int MOD = 10007;
    public static int[][][][][] DP = new int[MAX_LENGTH + 2][2][2][2][2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DP[1][0][0][0][0] = 1; // 첫번째 열 직전까지는 다 채워짐 (경우의 수 1)
        for(int i = 1 ; i <= n ; i++){
            // 0 0 0 0
            DP[i + 1][0][0][0][0] = (DP[i + 1][0][0][0][0] + DP[i][0][0][0][0]) % MOD;
            DP[i + 1][1][1][0][0] = (DP[i + 1][1][1][0][0] + DP[i][0][0][0][0]) % MOD;
            DP[i + 1][1][0][0][1] = (DP[i + 1][1][0][0][1] + DP[i][0][0][0][0]) % MOD;
            DP[i + 1][0][0][1][1] = (DP[i + 1][0][0][1][1] + DP[i][0][0][0][0]) % MOD;
            DP[i + 1][1][1][1][1] = (DP[i + 1][1][1][1][1] + DP[i][0][0][0][0]) % MOD;

            // 1 1 0 0
            DP[i + 1][0][0][0][0] = (DP[i + 1][0][0][0][0] + DP[i][1][1][0][0]) % MOD;
            DP[i + 1][0][0][1][1] = (DP[i + 1][0][0][1][1] + DP[i][1][1][0][0]) % MOD;

            // 1 0 0 1
            DP[i + 1][0][0][0][0] = (DP[i + 1][0][0][0][0] + DP[i][1][0][0][1]) % MOD;
            DP[i + 1][0][1][1][0] = (DP[i + 1][0][1][1][0] + DP[i][1][0][0][1]) % MOD;

            // 0 0 1 1 
            DP[i + 1][0][0][0][0] = (DP[i + 1][0][0][0][0] + DP[i][0][0][1][1]) % MOD;
            DP[i + 1][1][1][0][0] = (DP[i + 1][1][1][0][0] + DP[i][0][0][1][1]) % MOD;

            // 0 1 1 0
            DP[i + 1][1][0][0][1] = (DP[i + 1][1][0][0][1] + DP[i][0][1][1][0]) % MOD;

            // 1 1 1 1
            DP[i + 1][0][0][0][0] = (DP[i + 1][0][0][0][0] + DP[i][1][1][1][1]) % MOD;
        }
        System.out.print(DP[n + 1][0][0][0][0]);
    }
}