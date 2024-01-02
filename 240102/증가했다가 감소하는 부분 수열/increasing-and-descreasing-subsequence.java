import java.util.*;

public class Main {
    public static final int MAX_RANGE = 1000;
    public static final int INVAILED = Integer.MIN_VALUE;
    public static int[] arr = new int[MAX_RANGE + 1];
    public static int[] DP = new int[MAX_RANGE + 1];
    public static boolean[] upDown = new boolean[MAX_RANGE + 1];

    public static int n;

    public static void initialize(){
        for(int i = 0 ; i < n ; i++){
            DP[i] = INVAILED;
            upDown[i] = true;
        }
        DP[0] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 1 ; i <= n ; i++){
            arr[i] = sc.nextInt();
        }

        initialize();

        for(int i = 1 ; i <= n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(arr[j] == INVAILED || arr[i] == arr[j] ){
                    continue;
                }

                if((arr[i] > arr[j]) && upDown[j] == false){
                    DP[i] = 2;
                    upDown[i] = true;
                    continue;
                }

                // DP[i] = Math.max(DP[i], DP[j] + 1);

                if(DP[i] < DP[j] + 1){
                    DP[i] = DP[j] + 1;
                    if(arr[i] < arr[j]){
                        upDown[i] = false;
                    }
                    else{
                        upDown[i] = true;
                    }
                } 
            }
        }

        int output = INVAILED;

        for(int i = 1 ; i <= n ; i++){
            output = Math.max(output, DP[i]);
            // System.out.println(DP[i] + " " + upDown[i]);
        }

        System.out.print(output);
    }
}