import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 1000;
    public static final int INVAILD = (int)-1e9;
    public static int[] arr = new int[MAX_LENGTH + 1];
    public static int[][] DP = new int[MAX_LENGTH + 1][4];
    public static int n = -1;

    public static boolean inRange(int row, int col){
        return row >= 0 && col >= 0 && row <= n && col <= 3;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= 3 ; j++){
                DP[i][j] = INVAILD;
            }
        }

        DP[0][0] = 0;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 0 ; j <= 3 ; j++){
                int afterOne = inRange(i - 1, j - 1) ? DP[i - 1][j - 1] : INVAILD;
                int afterTwo = inRange(i - 2, j) ? DP[i - 2][j] : INVAILD;

                DP[i][j] = Math.max(DP[i][j], Math.max(afterOne, afterTwo) + arr[i]);
            }
        }

        // for(int i = 0 ; i <= n ; i++){
        //     for(int j = 0 ; j <= 3 ; j++){
        //         System.out.print(DP[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        int ans = 0;
        for(int i = 0 ; i <= 3 ; i++){
            ans = Math.max(ans, DP[n][i]);
        }
        System.out.print(ans);

    }
}