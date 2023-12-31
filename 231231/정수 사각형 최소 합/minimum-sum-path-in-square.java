import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static int[][] table = new int[MAX_RANGE][MAX_RANGE];
    public static int[][] DP = new int[MAX_RANGE][MAX_RANGE];
    public static int N;

    public static void initialize(){
        DP[0][N - 1] = table[0][N - 1];
        for(int i = N - 2 ; i >= 0 ; i--){
            DP[0][i] = DP[0][i + 1] + table[0][i];
        }

        for(int i = 1 ; i < N ; i++){
            DP[i][N - 1] = DP[i - 1][N - 1] + table[i][N - 1];
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
            for(int j = N - 2 ; j >= 0 ; j--){
                DP[i][j] = Math.min(DP[i-1][j], DP[i][j+1]) + table[i][j];
            }
        }

        System.out.print(DP[N-1][0]);
    }
}