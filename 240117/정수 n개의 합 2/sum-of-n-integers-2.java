import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100000;
    public static final int MIN_INT = -100;
    public static int[] arr = new int[MAX_RANGE];
    public static int[] prefix = new int[MAX_RANGE];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int maxVal = MAX_RANGE * MIN_INT - 1;

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        prefix[0] = arr[0];
        for(int i = 1 ; i < n - 1 ; i++){
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for(int i = 0 ; i < n - k ; i++){
            maxVal = Math.max(maxVal, prefix[i + k - 1] - prefix[i] + arr[i]);
        }
        System.out.println(maxVal);
    }
}