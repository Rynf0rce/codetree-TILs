import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 1000;
    public static final int MOD = 10007;
    public static int[] DP = new int[MAX_LENGTH + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DP[1] = 2;
        DP[2] = 3;
        for(int i = 3; i <= n; i++){
            if(i % 2 == 0){
                DP[i] = (DP[i - 1] + DP[i - 2]) % MOD;
            } 
            else {
                DP[i] = (DP[i - 1] * 2 + DP[i - 2]) % MOD;
            }
        }
        System.out.print(DP[n]);
    }
}