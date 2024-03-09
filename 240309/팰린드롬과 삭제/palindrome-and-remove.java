import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 2000;
    
    public static int[][] DP = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];
    public static String str = " ";
    public static int n = -1;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = String.valueOf(br.readLine());
        n = str.length();
        str = "#" + str;

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                DP[i][j] = MAX_LENGTH;
            }
            DP[i][i] = 0;
        }

        for(int i = 1 ; i < n ; i++){
            if(str.charAt(i) != str.charAt(i + 1)){
                DP[i][i + 1] = 1;
            }
        }
        
        int ans = 0;
        for(int gap = 3 ; gap <= n ; gap++){
            for(int start = 1 ; start <= n - gap + 1 ; start++){
                int end = start + gap - 1;

                if(str.charAt(start) != str.charAt(end)){
                    for(int k = start ; k < end ; k++){
                        DP[start][end] = Math.min(DP[start][end], DP[start][k] + DP[k + 1][end] + 1);
                    }
                }
                else{
                    DP[start][end] = Math.min(DP[start][end], DP[start + 1][end - 1]);
                }
            }
        }

        // for(int i = 1 ; i <= n ; i++){
        //     for(int j = 1 ; j <= n ; j++){
        //         System.out.print(DP[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        System.out.print(DP[1][n]);
    }
}