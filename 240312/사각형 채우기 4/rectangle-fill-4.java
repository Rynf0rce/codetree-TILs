import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 1000;
    public static final int MOD = 10007;
    public static long[] DP = new long[MAX_LENGTH + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DP[1] = 2;
        DP[2] = 3;
        for(int i = 4; i <= n; i += 2){
            DP[i] = DP[i - 2] * 3;
            for(int j = i - 4; j >= 0; j -= 2){
                DP[i] += DP[j] * 2;
            }
            DP[i] = DP[i] % MOD;
        }
        System.out.print(DP[n]);
    }
}