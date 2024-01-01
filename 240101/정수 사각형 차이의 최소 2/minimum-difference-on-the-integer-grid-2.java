import java.util.*;

 public class Main {
    public static final int MAX_RANGE = 100;
    public static final int MAX_INT = MAX_RANGE * 3;
    public static int[][] table = new int[MAX_RANGE][MAX_RANGE];
    public static int[][] DP = new int[MAX_RANGE][MAX_RANGE];
    public static int n;

    public static int conFnc(int minimal){
        if(table[0][0] < minimal || table[n - 1][n - 1] < minimal){
            return 0;
        }

        DP[0][0] = table[0][0];

        for(int i = 1 ; i < n ; i++){
            if(table[0][i] < minimal){
                DP[0][i] = MAX_INT;
            }
            else{
                DP[0][i] = Math.max(DP[0][i - 1], table[0][i]);
            }

            if(table[i][0] < minimal){
                DP[i][0] = MAX_INT;
            }
            else{
                DP[i][0] = Math.max(DP[i - 1][0], table[i][0]);
            }
        }

        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j < n ; j++){
                if(table[i][j] < minimal){
                    DP[i][j] = MAX_INT;
                }
                else{
                    int upMaxVal = Math.max(DP[i - 1][j], table[i][j]);
                    int rightMaxVal = Math.max(DP[i][j - 1], table[i][j]);
                    DP[i][j] = Math.min(upMaxVal, rightMaxVal);
                }
            }
        }

        int output = DP[n - 1][n - 1] - minimal;
        return (output < 1 ? 0 : DP[n - 1][n - 1] - minimal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int minVal = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                table[i][j] = sc.nextInt();
            }
        }

        for(int i = 1 ; i <= 100 ; i++){
            int output = conFnc(i);
            if(output == 0){
                break;
            }

            minVal = Math.min(minVal, output);
        }

        System.out.println(minVal);
    }
}