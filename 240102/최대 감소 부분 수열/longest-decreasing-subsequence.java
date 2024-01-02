import java.util.*;

public class Main {
    public static final int MAX_RANGE = 1000;
    public static final int MAX_INPUT = 10000;
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static int[] arr = new int[MAX_RANGE];
    public static int[][] DP = new int[MAX_RANGE + 1][MAX_INPUT + 1];

    public static void initialize(){
        for(int i = 0 ; i < MAX_RANGE ; i++){
            for(int j = 0 ; j < MAX_INPUT ; j++){
                DP[i][j] = INT_MIN;
            }
        }
        DP[0][MAX_INPUT] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max_element = INT_MIN;
        for(int i = 1 ; i <= N ; i++){
            arr[i] = sc.nextInt();
            max_element = Math.max(max_element, arr[i]);
        }

        initialize();

        for(int i = 1 ; i <= N ; i++){
            for(int j = max_element ; j >= 1 ; j--){
                if(arr[i] != j){
                    DP[i][j] = DP[i - 1][j];
                }
                else{
                    DP[i][j] = DP[i - 1][j];

                    for(int k = arr[i] + 1 ; k <= MAX_INPUT ; k++){
                        if(DP[i - 1][k] != INT_MIN){
                            DP[i][j] = Math.max(DP[i][j], DP[i - 1][k] + 1);
                        }
                    }
                }
            }
        }

        int output = INT_MIN;
        for(int i = 0; i <= max_element ; i++){
            output = Math.max(output, DP[N][i]);
        }

        System.out.print(output);
    }
}