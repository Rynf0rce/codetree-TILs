import java.util.*;

public class Main {
    public static final int MAX_INPUT = 100;
    public static final int MIN_INT = -20;
    public static final int MAX_INT = 20;
    public static final int INVALUED = MAX_INPUT * MIN_INT - 1;
    
    public static int[] arr = new int[MAX_INPUT + 1];
    public static int[][] DP = new int[MAX_INPUT + 1][MAX_INT - MIN_INT + 1];
    public static boolean[][] visited = new boolean[MAX_INPUT + 1][MAX_INT - MIN_INT + 1];
    
    public static int N, M;

    public static void initilize(){
        for(int i = 0 ; i <= N ; i++){
            for(int j = 0 ; j <= MAX_INT - MAX_INT ; j++){
                DP[i][j] = INVALUED;
            }
        }
        DP[0][0] = 0;
    }

    public static int findOutcome(int idx, int sum){
        // System.out.println(sum);
        if(sum < MIN_INT || sum > MAX_INT){
            return 0;
        }

        if(idx == 0){
            if(sum == M){
                return 1;
            }
            else{
                return 0;
            }
        }

        // if(visited[idx][sum]){
        //     return DP[idx][sum];
        // }

        // visited[idx][sum] = true;

        // DP[idx][sum - MIN_INT]++;

        return findOutcome(idx - 1, sum - arr[idx]) + findOutcome(idx - 1, sum + arr[idx]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for(int i = 1 ; i <= N ; i++){
            arr[i] = sc.nextInt();
        }

        initilize();

        System.out.println(findOutcome(N, 0));
    }
}