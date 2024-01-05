import java.util.*;

public class Main {
    public static final int MAX_INPUT = 100;
    public static final int MAX_TIME = 100;
    public static final int INVALUED = -1;

    public static int[][] DP = new int[MAX_INPUT + 1][MAX_INPUT * MAX_TIME + 1];

    public static int[] expArr = new int[MAX_INPUT + 1];
    public static int[] timeArr = new int[MAX_INPUT+ 1];

    public static int n, m, totalTime; // 입력 수, 목표 경험치.

    public static void initialize(){
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= totalTime ; j++){
                DP[i][j] = INVALUED;
            }
        }

        DP[0][0] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1 ; i <= n ; i++){
            expArr[i] = sc.nextInt();
            timeArr[i] = sc.nextInt();
            totalTime += timeArr[i];
        }

        initialize();

        for(int i = 1 ; i <= n ; i++){
            for(int j = totalTime ; j >= 0 ; j--){
                if(DP[i - 1][j] != INVALUED){
                    DP[i][j] = DP[i - 1][j];
                }

                if(j >= timeArr[i] && DP[i - 1][j - timeArr[i]] != INVALUED){
                    DP[i][j] = Math.max(DP[i][j], DP[i - 1][j - timeArr[i]] + expArr[i]);
                }
            }
        }

        // for(int i = 0 ; i <= n ; i++){
        //     for(int j = 0 ; j <= totalExp ; j++){
        //         System.out.print(DP[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        int output = INVALUED;

        for(int i = 0 ; i <= totalTime ; i++){
            if(DP[n][i] != INVALUED && DP[n][i] >= m){
                output = i;
                break;
            }
        }

        System.out.print(output == INVALUED ? -1 : output);
    }
}