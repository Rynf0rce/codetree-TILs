import java.util.*;

public class Main {
    public static final int MAX_RANGE = 1000;
    public static final int MOD = 1000000007;
    public static double[] arr = new double[MAX_RANGE + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 7;
        for(int i = 3 ; i <= n ; i++){
            arr[i] = (arr[i - 1] * 3 + (arr[i - 2] - arr[i - 3] ) ) % MOD;
        }
        System.out.println((int)arr[n]);
    }
}