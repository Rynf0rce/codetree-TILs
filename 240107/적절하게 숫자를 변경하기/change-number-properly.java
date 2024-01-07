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
                visited[i][j] = false;
            }
        }
        DP[0][0] = 0;
        visited[0][0] = true;
    }

    public static void setZero(){
        int curVal = arr[0];
        int cnt = 1;
        for(int i = 1 ; i <= N ; i++){
            if(curVal == arr[i]){
                cnt++;
            }
            else{
                cnt = 1;
                curVal = arr[i];
            }
            DP[i][0] = Math.max(DP[i - 1][0], cnt);
            visited[i][0] = true;
        }
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
        if(condition > 0){
            DP[idx][condition] = Math.max(DP[idx][condition], DP[idx - 1][condition - 1]);
        }
        

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

        setZero();

        System.out.println(findSimilar(N, M));

        // int maxVal = INVALUED;

        // for(int i = N ; i >= 0 ; i--){
        //     // initilize();
        //     maxVal = Math.max(maxVal, findSimilar(i, M));
        // }

        // System.out.println(maxVal);


        // for(int i = 1 ; i <= N ; i++){
        //     for(int j = 0 ; j <= M ; j++){
        //         System.out.print(DP[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
    }
}