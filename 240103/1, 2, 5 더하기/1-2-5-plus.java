import java.util.*;

public class Main {
    public static final int MAX_RANGE = 1000;
    public static final int MOD = 10007;
    public static int[] arr = new int[]{1, 2 ,5};
    public static long[] DP = new long[MAX_RANGE + 1];
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // initialization;
        DP[0] = 1;

        for(int i = 1 ; i <= n ; i++){
            for(int j = 0 ; j < arr.length ; j++){
                if(i < arr[j]){
                    continue;
                }        

                DP[i] += (DP[i - arr[j]]);
            }
            DP[i] %= MOD;
            // System.out.println(DP[i] + " ");
        }

        System.out.print(DP[n]);
    }
}