import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static final int MAX_INT = 1000;
    public static int[] arr = new int[MAX_RANGE + 1];
    public static boolean[] DP_A = new boolean[MAX_RANGE * MAX_INT];
    public static boolean[] DP_B = new boolean[MAX_RANGE * MAX_INT];
    public static int n, total;

    public static void initialize(){
        for(int i = 1 ; i <= total ; i++){
            DP_A[i] = false;
            DP_B[i] = false;
        }
        DP_A[0] = true;
        DP_B[0] = true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int maxVal = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        for(int i = 0 ; i < n ; i++){
            initialize();
            for(int j = 0 ; j <= i ; j++){
                for(int k = total ; k >= 0 ; k--){
                    if(k < arr[j] || !DP_A[k - arr[j]]){
                        continue;
                    }

                    DP_A[k] = true;
                }
            }

            for(int j = i + 1 ; j < n ; j++){
                for(int k = total ; k >= 0 ; k--){
                    if(k < arr[j] || !DP_B[k - arr[j]]){
                        continue;
                    }

                    DP_B[k] = true;
                }
            }

            for(int j = 0 ; j <= total ; j++){
                if(DP_A[j] && DP_B[j]){
                    maxVal = Math.max(maxVal, j);
                }
            }
        }

        System.out.println(maxVal);
    }
}