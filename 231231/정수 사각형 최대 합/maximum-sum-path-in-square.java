import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static int[][] table = new int[MAX_RANGE][MAX_RANGE];
    public static int[] arrRow = new int[]{0, 1};
    public static int[] arrCol = new int[]{1, 0};
    public static int[][] DP = new int[MAX_RANGE][MAX_RANGE];
    public static int N;

    public static void initialize(){
        DP[0][0] = table[0][0];
        for(int i = 1; i < N ; i++){
            DP[i][0] =  DP[i - 1][0] + table[i][0];
        }

        for(int i = 1; i < N ; i++){
            DP[0][i] =  DP[0][i - 1] + table[0][i];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                table[i][j] = sc.nextInt();
            }
        }

        initialize();

        for(int i = 1 ; i < N ; i++){
            for(int j = 1 ; j < N ; j++){
                DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]) + table[i][j];
            }
        }

        System.out.print(DP[N - 1][N - 1]);
    }
}