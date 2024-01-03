import java.util.*;

public class Main {
    public static final int MAX_JEWEL = 100;
    public static final int MAX_WEIGHT = 10000;
    public static final int INVALUED = -1;

    public static int[] weightArr = new int[MAX_JEWEL + 1];
    public static int[] valueArr = new int[MAX_JEWEL + 1];

    public static int[][] DP = new int[MAX_JEWEL + 1][MAX_WEIGHT + 1];
    public static int N, M;

    public static void initialize(){
        for(int i = 0 ; i <= MAX_JEWEL ; i++){
            for(int j = 0 ; j <= MAX_WEIGHT ; j++){
                DP[i][j] = INVALUED;
            }
        }
        DP[0][0] = 0;
    }

    public static int calMaxValue(int row, int col){
        int n0 = DP[row][col];
        int n1 = INVALUED;
        int n2 = INVALUED;
        int n3 = INVALUED;

        if(row - 1 >= 0 && col - weightArr[row] >= 0){
            n1 = DP[row - 1][col - weightArr[row]] + valueArr[row];
        }

        if(row - 1 >= 0){
            n2 = DP[row - 1][col];
        }

        if(col -  weightArr[row] >= 0){
            n3 = DP[row][col -  weightArr[row]] + valueArr[row];
        }

        return Math.max(Math.max(n0, n1), Math.max(n2, n3));
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

        for(int i = 0 ; i <= N ; i++){
            for(int j = 0 ; j <= M ; j++){
                DP[i][j] = calMaxValue(i, j);
            }
        }

        int maxVal = INVALUED;

        for(int i = 0 ; i <= M ; i++){
            maxVal = Math.max(maxVal, DP[N][i]);
        }

        for(int i = 0 ; i <= N ; i++){
            for(int j = 0 ; j <= M ; j++){
                System.out.print(DP[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print(maxVal);
    }
}