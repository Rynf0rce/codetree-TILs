import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;

    public static int[][] table = new int[MAX_RANGE][MAX_RANGE];
    public static int[][] DP = new int[MAX_RANGE][MAX_RANGE];

    public static int N;

    public static void initialize(){
        DP[0][0] = table[0][0];
        for(int i = 1 ; i < N ; i++){
            DP[i][0] = Math.min(table[i][0], DP[i - 1][0]);
        }

        for(int i = 1 ; i < N ; i++){
            DP[0][i] = Math.min(table[0][i], DP[0][i - 1]);
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
                int cost = table[i][j];
                int preMaxCost = Math.max(DP[i - 1][j], DP[i][j - 1]);

                if(cost <= preMaxCost){
                    DP[i][j] = cost;
                }
                else{
                    DP[i][j] = preMaxCost;
                }
            }
        }

        System.out.println(DP[N - 1][N - 1]);
    }
}