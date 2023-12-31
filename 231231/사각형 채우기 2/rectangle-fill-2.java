import java.util.*;

public class Main {
    public static final int MAX_RANGE = 1000;
    public static final int MOD = 10007;
    public static long[] arr = new long[MAX_RANGE + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2 ; i <= n ; i++){
            arr[i] = (arr[i - 1] + 2 * arr[i - 2]) % MOD;
        }

        System.out.println(arr[n]);
    }
}