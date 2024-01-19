import java.util.*;

public class Main {
    public static final int MAX_EDGE = 1000;
    public static char[][] table = new char[MAX_EDGE + 1][MAX_EDGE + 1];
    public static int[][] preSum_A = new int[MAX_EDGE + 1][MAX_EDGE + 1];
    public static int[][] preSum_B = new int[MAX_EDGE + 1][MAX_EDGE + 1];
    public static int[][] preSum_C = new int[MAX_EDGE + 1][MAX_EDGE + 1];
    public static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int k = sc.nextInt();

        for(int i = 1 ; i <= n ; i++){
            String str = sc.next();
            for(int j = 1 ; j <= m ; j++){
                table[i][j] = str.charAt(j - 1);
            }
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(table[i][j] == 'a'){
                    preSum_A[i][j] = 1 + preSum_A[i - 1][j] + preSum_A[i][j - 1] - preSum_A[i - 1][j - 1];
                    preSum_B[i][j] = preSum_B[i - 1][j] + preSum_B[i][j - 1] - preSum_B[i - 1][j - 1];
                    preSum_C[i][j] = preSum_C[i - 1][j] + preSum_C[i][j - 1] - preSum_C[i - 1][j - 1];
                }
                else if(table[i][j] == 'b'){
                    preSum_A[i][j] = preSum_A[i - 1][j] + preSum_A[i][j - 1] - preSum_A[i - 1][j - 1];
                    preSum_B[i][j] = 1 + preSum_B[i - 1][j] + preSum_B[i][j - 1] - preSum_B[i - 1][j - 1];
                    preSum_C[i][j] = preSum_C[i - 1][j] + preSum_C[i][j - 1] - preSum_C[i - 1][j - 1];
                }
                else{
                    preSum_A[i][j] = preSum_A[i - 1][j] + preSum_A[i][j - 1] - preSum_A[i - 1][j - 1];
                    preSum_B[i][j] = preSum_B[i - 1][j] + preSum_B[i][j - 1] - preSum_B[i - 1][j - 1];
                    preSum_C[i][j] = 1 + preSum_C[i - 1][j] + preSum_C[i][j - 1] - preSum_C[i - 1][j - 1];
                }
            }
        }

        for(int i = 0 ; i < k ; i++){
            int r1 = sc.nextInt();
            int c1 = sc.nextInt();
            int r2 = sc.nextInt();
            int c2 = sc.nextInt();

            System.out.print(preSum_A[r2][c2] + preSum_A[r1 - 1][c1 - 1] - preSum_A[r2][c1 - 1] - preSum_A[r1 - 1][c2] + " ");
            System.out.print(preSum_B[r2][c2] + preSum_B[r1 - 1][c1 - 1] - preSum_B[r2][c1 - 1] - preSum_B[r1 - 1][c2] + " ");
            System.out.print(preSum_C[r2][c2] + preSum_C[r1 - 1][c1 - 1] - preSum_C[r2][c1 - 1] - preSum_C[r1 - 1][c2] + "\n");
        }
    }
}