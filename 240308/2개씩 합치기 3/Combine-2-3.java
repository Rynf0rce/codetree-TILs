import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 500;
    public static final int MAX_INT = (int) 1e9;
    public static int[] arr = new int[MAX_LENGTH + 1];
    public static int[][] merged = new int[MAX_LENGTH + 1][MAX_LENGTH  + 1];
    public static int[][] DP = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= n ; j++){
                DP[i][j] = MAX_INT;
            }
            DP[i][i] = 0;
        }

        for(int i = 1 ; i <= n ; i++){
            merged[i][i] = arr[i];
            for(int j = i + 1; j <= n ; j++){
                merged[i][j] = merged[i][j - 1] + arr[j];
            }
        }

        // for(int i = 1 ; i <= n ; i++){
        //     for(int j = 1 ; j <= n ; j++){
        //         System.out.print(merged[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        for(int gap = 2 ; gap <= n ; gap++){
            for(int i = 1 ; i <= n - gap + 1 ; i++){
                int j = i + gap - 1;
                for(int k = i ; k < j ; k++){
                    int cost = DP[i][k] + DP[k + 1][j] + merged[i][k] + merged[k + 1][j];
                    DP[i][j] = Math.min(DP[i][j], cost);
                }
            }
        }

        System.out.print(DP[1][n]);


    }
}