import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_CHECK_POINT = 100;
    public static int[][] DP = new int[MAX_CHECK_POINT + 2][2];
    public static int[] xArr = new int[MAX_CHECK_POINT];
    public static int[] yArr = new int[MAX_CHECK_POINT];
    public static final int INVALID = (int)1e9;

    public static int dist(int idx1, int idx2){
        return Math.abs(xArr[idx1] - xArr[idx2]) + Math.abs(yArr[idx1] - yArr[idx2]);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            xArr[i] = Integer.parseInt(st.nextToken());
            yArr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i <= N ; i++){
            for(int j = 0 ; j < 2 ; j++){
                DP[i][j] = INVALID;
            }
        }

        DP[0][0] = 0;

        // DP[x][0] = DP[x - 1][0] + dist between x - 1 and x
        // DP[x][1] = Math.max(DP[x - 2][0] + dist between x - 2 and x, DP[x - 1][1] + dist between x - 1 and x)
        for(int i = 0 ; i < N ; i++){
            DP[i + 1][0] = DP[i][0] + dist(i, i + 1); 
            DP[i + 2][1] = Math.min(DP[i + 2][1], Math.min(DP[i + 1][1] + dist(i + 1, i + 2), DP[i][0] + dist(i, i + 2)));
        }

        // for(int i = 0 ; i < N ; i++){
        //     for(int j = 0 ; j < 2 ; j++){
        //         System.out.print(DP[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        System.out.print(DP[N - 1][1]);
    }
}