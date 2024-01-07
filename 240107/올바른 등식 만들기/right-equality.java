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
            for(int j = 0 ; j <= MAX_INT - MIN_INT ; j++){
                DP[i][j] = INVALUED;
            }
        }
        DP[0][20] = 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt() + MAX_INT;

        for(int i = 1 ; i <= N ; i++){
            arr[i] = sc.nextInt();
        }

        initilize();

        for(int i = 1 ; i <= N ; i++){
            for(int j = 0 ; j <= MAX_INT - MIN_INT ; j++){
                if(DP[i - 1][j] == INVALUED){
                    continue;
                }


                if(!(j - arr[i] < 0) && !(j - arr[i] > MAX_INT - MIN_INT)){
                    if(DP[i][j - arr[i]] == INVALUED){
                        DP[i][j - arr[i]] = DP[i - 1][j];
                    }
                    else{
                        DP[i][j - arr[i]] += DP[i - 1][j];
                    }
                }

                if(!(j + arr[i] > MAX_INT - MIN_INT) && !(j + arr[i] < 0)){
                    if(DP[i][j + arr[i]] == INVALUED){
                        DP[i][j + arr[i]] = DP[i - 1][j];
                    }
                    else{
                        DP[i][j + arr[i]] += DP[i - 1][j];
                    }
                }

            }
        }

        System.out.print(DP[N][M] == INVALUED ? 0 : DP[N][M]);
    }

}