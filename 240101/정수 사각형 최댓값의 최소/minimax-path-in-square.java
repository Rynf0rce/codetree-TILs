import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static int[][] table = new int[MAX_RANGE][MAX_RANGE];
    public static int[][] DP = new int[MAX_RANGE][MAX_RANGE];
    public static int n;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                table[i][j] = sc.nextInt();
            }
        }

        DP[0][0] = table[0][0];

        for(int i = 1 ; i < n ; i++){
            DP[0][i] = Math.max(DP[0][i - 1], table[0][i]);
            DP[i][0] = Math.max(DP[i - 1][0], table[i][0]);
        }

        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j < n ; j++){
                DP[i][j] = Math.min(
                    Math.max(DP[i - 1][j], table[i][j]),
                    Math.max(DP[i][j - 1], table[i][j])
                );
            }
        }

        System.out.print(DP[n - 1][n - 1]);
    }
}