import java.util.*;

public class Main {
    public static final int MAX_INT = 1000000;
    public static final long MOD = 1000000007;
    public static long[] DP = new long[MAX_INT + 1];

    public static long findAns(int n){
        if(DP[n] != -1){
            return DP[n];
        }

        return DP[n] = (findAns(n - 1) + findAns(n - 2)) % MOD;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i <= n ; i++){
            DP[i] = -1;
        }
        DP[0] = 0;
        DP[1] = 1;
        System.out.print(findAns(n));
    }
}