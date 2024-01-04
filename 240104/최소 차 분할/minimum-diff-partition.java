import java.util.*;

public class Main {
    public static final int MAX_NUM = 100;
    public static final int MAX_RANGE = 1000;
    public static final int INVALUED = Integer.MAX_VALUE;
    public static int[] arr = new int[MAX_NUM];
    public static boolean[] DP = new boolean[MAX_NUM * MAX_RANGE + 1];
    public static int n, total;

    public static void initialize(){
        for(int i = 1 ; i <= total ; i++){
            DP[i] = false;
        }
        DP[0] = true;
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        initialize();

        for(int i = 0 ; i < n ; i++){
            for(int j = total ; j >= 1 ; j--){
                if(j < arr[i] || !DP[j - arr[i]]){
                    continue;
                }
                DP[j] = true;
            }
        }

        int minVal = INVALUED;

        for(int i = 0 ; i <= total / 2 ; i++){
            // System.out.print(DP[i] + " ");
            if(DP[i]){
                minVal = Math.min(minVal, Math.abs(total - 2 * i));
            }
        }
        // System.out.println();
        System.out.println(minVal);
    }
}