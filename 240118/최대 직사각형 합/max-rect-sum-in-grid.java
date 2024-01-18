import java.util.*;

public class Main {
    public static final int MAX_EDGE = 300;
    public static final int MIN_VALUE = -1000;
    public static int[][] table = new int[MAX_EDGE + 1][MAX_EDGE + 1];
    public static int[][] prefixSum = new int[MAX_EDGE + 1][MAX_EDGE + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxVal = MIN_VALUE * MAX_EDGE * MAX_EDGE;

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                table[i][j] = sc.nextInt();
                maxVal = Math.max(maxVal, table[i][j]);
            }
        }

        if(maxVal <= 0){
            System.out.print(maxVal);
            System.exit(0);
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(prefixSum[i - 1][j - 1] == 0){
                    prefixSum[i][j] = Math.max(prefixSum[i - 1][j] + table[i][j], prefixSum[i][j - 1] + table[i][j]);
                }
                else{
                    prefixSum[i][j] = table[i][j] - prefixSum[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1];
                }
                if(prefixSum[i][j] < 0){
                    prefixSum[i][j] = 0;
                }
            }
        }

        // for(int i = 0 ; i <= n ; i++){
        //     for(int j = 0 ; j <= n ; j++){
        //         System.out.print(prefixSum[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                for(int k = i ; k <= n ; k++){
                    for(int h = j ; h <= n ; h++){
                        maxVal = Math.max(maxVal, prefixSum[k][h] + prefixSum[i - 1][j - 1] - prefixSum[i - 1][h] - prefixSum[k][j - 1]);
                    }
                }
            }
        }
        System.out.print(maxVal);
    }
}