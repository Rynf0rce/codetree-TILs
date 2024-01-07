import java.util.*;

public class Main {
    public static final int MAX_SELECT = 100;
    public static final int MAX_CARD = 2 * MAX_SELECT;
    public static final int INVALUED = Integer.MIN_VALUE;

    public static int[] redArr = new int[MAX_CARD + 1];
    public static int[] blueArr = new int[MAX_CARD + 1];

    public static int[][] DP = new int[MAX_CARD + 1][MAX_SELECT + 1];
    public static boolean[][] visited = new boolean[MAX_CARD + 1][MAX_SELECT + 1];

    public static int N;

    public static void initilize(){
        for(int i = 0 ; i <= 2 * N ; i++){
            for(int j = 0 ; j <= N ; j++){
                DP[i][j] = INVALUED;
            }
        }
    }

    public static int findMax(int idx, int red){
        if(red < 0 || (idx == 0 && red > 0)){
            return INVALUED;
        }

        if(idx == 0){
            return 0;
        }

        if(visited[idx][red]){
            return DP[idx][red];
        }

        visited[idx][red] = true;

        DP[idx][red] = findMax(idx - 1, red) + blueArr[idx];

        DP[idx][red] = Math.max(DP[idx][red], findMax(idx - 1, red - 1) + redArr[idx]);

        return DP[idx][red];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i = 1 ; i <= 2 * N ; i++){
            redArr[i] = sc.nextInt();
            blueArr[i] = sc.nextInt();
        }

        initilize();

        System.out.println(findMax(2 * N, N));

        // for(int i = 0 ; i <= 2 * N ; i++){
        //     for(int j = 0 ; j <= N ; j++){
        //         System.out.print(DP[i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }
}