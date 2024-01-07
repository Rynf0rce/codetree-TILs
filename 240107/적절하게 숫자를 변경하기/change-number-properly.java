import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 500;
    public static final int MAX_CONDITION = 100;
    public static final int INVALUED = Integer.MIN_VALUE;
    public static int[] arr = new int[MAX_LENGTH + 1];
    public static int[][] DP = new int[MAX_LENGTH + 1][MAX_CONDITION + 1];
    public static boolean[][] visited  = new boolean[MAX_LENGTH + 1][MAX_CONDITION + 1];
    public static int N, M;

    public static void initilize(){
        for(int i = 0 ; i <= N ; i++){
            for(int j = 0 ; j <= M ; j++){
                DP[i][j] = INVALUED;
            }
        }
        // DP[0][0] = 0;
        // visited[0][0] = true;
    }

    public static int findSimilar(int idx, int condition){
        // System.out.println(idx + " " + condition + " " + arr[idx]);

        if(idx == 0){
            return 0;
        }

        if(condition < 0){
            return INVALUED;
        }

        if(visited[idx][condition]){
            return DP[idx][condition];
        }

        visited[idx][condition] = true;
        DP[idx][condition] = Math.max(DP[idx][condition], DP[idx - 1][condition]);

        for(int i = idx ; i > 0 ; i--){
            if(arr[idx] == arr[i - 1]){
                DP[idx][condition] = Math.max(DP[idx][condition], findSimilar(i - 1, condition) + 1);
            }
            else{
                DP[idx][condition] = Math.max(DP[idx][condition], findSimilar(i - 1, condition - 1) + 1);
            }
        }
        

        return DP[idx][condition];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for(int i = 1 ; i <= N ; i++){
            arr[i] = sc.nextInt();
        }

        initilize();

        System.out.println(findSimilar(N, M));
    }
}