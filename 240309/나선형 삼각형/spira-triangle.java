import java.util.*;

public class Main {
    public static final int MAX_INT = 100;
    public static long[] DP = new long[MAX_INT + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DP[1] = 1;
        DP[2] = 1;
        for(int i = 3 ; i <= n ; i++){
            DP[i] = DP[i - 3] + DP[i - 2];
        }
        System.out.print(DP[n]);
    }
}