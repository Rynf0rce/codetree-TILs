import java.util.*;

public class Main {
    public static final int MAX_RANGE = 1000;
    public static int[] arr = new int[MAX_RANGE];
    public static int[] DP = new int[MAX_RANGE];

    public static void initialize(){
        DP[0] = 1;
        for(int i = 1 ; i < MAX_RANGE ; i++){
            DP[i] = Integer.MIN_VALUE;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxVal = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        initialize();

        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(DP[j] == Integer.MIN_VALUE){
                    continue;
                }

                if(arr[j] < arr[i]){
                    DP[i] = Math.max(DP[i], DP[j] + 1);
                }
            }
            maxVal = Math.max(maxVal, DP[i]);
        }

        System.out.print(maxVal);
    }
}