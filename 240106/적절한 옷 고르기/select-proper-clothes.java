import java.util.*;

public class Main {
    public static final int MAX_CLOTH = 200;
    public static final int MAX_DAY = 200;
    public static final int INVALUED = Integer.MIN_VALUE;
    public static int[][] DP = new int[MAX_CLOTH][MAX_DAY + 1];
    public static int[][] clothArr = new int[MAX_CLOTH][MAX_DAY + 1];
    public static int N, M;

    public static void initilize(){
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j <= M ; j++){
                DP[i][j] = INVALUED;
                clothArr[i][j] = INVALUED;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        initilize();

        for(int i = 0 ; i < N ; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int point = sc.nextInt();
            for(int j = start ; j <= end ; j++){
                clothArr[i][j] = point;
                if(j == 1){
                    DP[i][j] = 0;
                }
            }
        }

        for(int j = 2 ; j <= M ; j++){
            for(int i = 0 ; i < N ; i++){
                if(clothArr[i][j] == INVALUED){
                    continue;
                }

                for(int k = 0 ; k < N ; k++){
                    if(DP[k][j - 1] == INVALUED){
                        continue;
                    }

                    DP[i][j] = Math.max(DP[i][j], DP[k][j - 1] + Math.abs(clothArr[k][j - 1] - clothArr[i][j]));
                }
            }
        }

        int maxVal = INVALUED;

        for(int i = 0 ; i < N ; i++){
            maxVal = Math.max(maxVal, DP[i][M]);
        }

        System.out.print(maxVal);
    }
}