import java.util.*;

public class Main {
    public static final int MAX_RANGE = 1000;
    public static final int INVALID = Integer.MIN_VALUE;
    public static int[] arr = new int[MAX_RANGE];
    public static int[] DP = new int[MAX_RANGE];
    public static int n;

    public static void initalize(){
        for(int i = 1 ; i < n ; i++){
            DP[i] = INVALID;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int output = INVALID;

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        initalize();

        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(DP[j] == INVALID){
                    continue;
                }

                if(i <= arr[j] + j){
                    DP[i] = Math.max(DP[i], DP[j] + 1);
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            output = Math.max(output, DP[i]);
        }
        
        System.out.print(output);
    }
}