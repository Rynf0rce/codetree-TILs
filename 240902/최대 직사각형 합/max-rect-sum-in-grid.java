import java.util.*;

public class Main {
    public static final int MAX_EDGE = 300;
    public static final int MIN_VALUE = -1000;
    public static int[][] table = new int[MAX_EDGE + 1][MAX_EDGE + 1];
    public static int[][] prefixSum = new int[MAX_EDGE + 1][MAX_EDGE + 1];
    public static int[] DP = new int[MAX_EDGE + 1];
    public static int n;

    public static void initialize(){
        for(int i = 0 ; i <= n ; i++){
            DP[i] = 0;
        }
    }
    
    public static int valueInRectangle(int r1, int r2){
        int maxVal = MAX_EDGE * MAX_EDGE * MIN_VALUE;

        for(int i = 1 ; i <= n ; i++){
            int value = prefixSum[r2][i] - prefixSum[r1 - 1][i];
            DP[i] = Math.max(DP[i - 1] + value, value);
            maxVal = Math.max(maxVal, DP[i]);
        }

        return maxVal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int maxVal = MAX_EDGE * MAX_EDGE * MIN_VALUE;

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                table[i][j] = sc.nextInt();
            }
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(i == 1){
                    prefixSum[i][j] = table[i][j];
                }
                else{
                    prefixSum[i][j] = prefixSum[i - 1][j] + table[i][j];
                }
            }
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = i ; j <= n ; j++){
                maxVal = Math.max(maxVal, valueInRectangle(i, j));
            }
        }

        System.out.print(maxVal);
    }
}