import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 200;
    public static final int MAX_INT = (int)2e9;
    public static int[] arr = new int[MAX_LENGTH + 1];

    // DP[i가 선택][j가 선택][k 버렸던 수];
    public static int[][][] DP = new int[MAX_LENGTH + 1][MAX_LENGTH + 1][MAX_LENGTH];
    public static int n = -1;
    public static int m = -1;

    public static int getPoint(int i, int j){
        if(i == 0 || j == 0){
            return 0;
        }

        return Math.abs(arr[i] - arr[j]);
    }

    public static void bitonic(int depth){
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= n ; j++){
                int next = Math.max(i, j) + 1;

                if(next > n || DP[i][j][depth] == MAX_INT){
                    continue;
                }

                DP[i][next][depth] = Math.min(DP[i][next][depth], DP[i][j][depth] + getPoint(j, next));
                DP[next][j][depth] = Math.min(DP[next][j][depth], DP[i][j][depth] + getPoint(i, next));

                if(depth + 1 <= m && depth + 1 <= next){
                    DP[i][next][depth + 1] = Math.min(DP[i][next][depth], DP[i][j][depth]);
                    DP[next][j][depth + 1] = Math.min(DP[next][j][depth], DP[i][j][depth]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= n ; j++){
                for(int k = 0 ; k <= m ; k++){
                    DP[i][j][k] = MAX_INT;
                }
            }
        }

        DP[0][0][0] = 0;

        for(int i = 0 ; i <= m ; i++){
            bitonic(i);
        }

        int ans = MAX_INT;
        for(int i = 0 ; i <= n ; i++){
            ans = Math.min(ans, DP[i][n][m]);
            ans = Math.min(ans, DP[n][i][m]);
        }

        // for(int i = 0 ; i <= n ; i++){
        //     for(int j = 0 ; j <= n ; j++){
        //         System.out.print(DP[i][j][0] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.print(ans);

    }
}