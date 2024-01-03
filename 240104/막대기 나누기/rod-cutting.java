import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static final int MAX_NUM = 10000;
    public static final int INVALUED = -1;
    public static int[] valueArr = new int[MAX_LENGTH + 1];
    public static int[][] DP = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];
    public static int n;

    public static void initialize(){
        for(int i = 0 ; i <= MAX_LENGTH ; i++){
            for(int j = 0 ; j <= MAX_LENGTH ; j++){
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

        if(row - 1 >= 0 && col - row >= 0){
            n1 = DP[row - 1][col - row] + valueArr[row];
        }

        if(row - 1 >= 0){
            n2 = DP[row - 1][col];
        }

        if(col - row >= 0){
            n3 = DP[row][col - row] + valueArr[row];
        }

        return Math.max(Math.max(n0, n1), Math.max(n2, n3));
    }

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 1 ; i <= n ; i++){
            valueArr[i] = sc.nextInt();
        }

        initialize();

        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= n ; j++){
                DP[i][j] = calMaxValue(i, j);
            }
        }

        int maxVal = INVALUED;

        for(int i = 0 ; i <= n ; i++){
            maxVal = Math.max(maxVal, DP[n][i]);
        }

        // for(int i = 0 ; i <= n ; i++){
        //     for(int j = 0 ; j <= n ; j++){
        //         System.out.print(DP[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.print(maxVal);
    }
}