import java.util.*;

public class Main {
    public static final int MAX_INPUT = 500;
    public static final int MIN_INT = -1000;
    public static final int INVALUED = MAX_INPUT * (MIN_INT + 1);
    public static int[][] DP = new int[MAX_INPUT + 1][(MAX_INPUT + 1) / 2];
    public static int[] arr = new int[MAX_INPUT + 1];
    public static int[] sumArr = new int[MAX_INPUT + 1];
    public static int N, M;

    public static int topDown(int idx, int section){
        if(section == 0){
            return 0;
        }

        if(idx < 0){
            return INVALUED;
        }

        if(DP[idx][section] != INVALUED){
            return DP[idx][section];
        }

        DP[idx][section] = topDown(idx - 1, section);
                
        for(int i = idx ; i > 0 ; i--){
            DP[idx][section] = Math.max(DP[idx][section], topDown(i - 2, section - 1) + sumArr[idx] - sumArr[i - 1]);
        }

        return DP[idx][section];
    }

    public static void initialize(){
        for(int i = 0 ; i <= N ; i++){
            for(int j = 0 ; j <= M ; j++){
                DP[i][j] = INVALUED;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for(int i = 1 ; i <= N ; i++){
            arr[i] = sc.nextInt();
        }

        initialize();

        for(int i = 1 ; i <= N ; i++){
            sumArr[i] = sumArr[i - 1] + arr[i];
        }

        System.out.println(topDown(N, M));
    }
}