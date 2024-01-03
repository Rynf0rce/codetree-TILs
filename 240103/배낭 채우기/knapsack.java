import java.util.*;

public class Main {
    public static int MAX_JEWEL = 100;
    public static int MAX_WEIGHT = 10000;
    public static int INVALUED = Integer.MIN_VALUE;
    public static int[] weightArr = new int[MAX_JEWEL + 1];
    public static int[] valueArr = new int[MAX_JEWEL + 1];
    public static int[][] DP = new int[MAX_JEWEL + 1][MAX_WEIGHT + 1];
    public static int N, M;

    public static void initialize(){
        for(int i = 0 ; i <= N ; i++){
            for(int j = 1 ; j <= M ; j++){
                DP[i][j] = INVALUED;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for(int i = 1 ; i <= N ; i++){
            weightArr[i] = sc.nextInt();
            valueArr[i] = sc.nextInt();
        }

        initialize();

        for(int i = 1; i <= N ; i++){
            for(int j = 1 ; j <= M ; j++){
                DP[i][j] = Math.max(DP[i][j], DP[i - 1][j]);
                if(j >= weightArr[i] && DP[i - 1][j - weightArr[i]] != INVALUED){
                    DP[i][j] = Math.max(DP[i][j], DP[i - 1][j - weightArr[i]] + valueArr[i]);
                }
            }
        }

        // for(int i = 1; i <= N ; i++){
        //     for(int j = 0 ; j <= M ; j++){
        //         System.out.print(DP[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        int maxVal = INVALUED;
        for(int i = 1 ; i <= M ; i++){
            maxVal = Math.max(maxVal, DP[N][i]);
        }

        System.out.print(maxVal);
    }
}