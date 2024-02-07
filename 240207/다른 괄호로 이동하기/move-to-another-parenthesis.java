import java.util.*;
import java.io.*;

public class Main { 
    public static final int MAX_EDGE = 30;
    public static char[][] table = new char[MAX_EDGE + 1][MAX_EDGE + 1];
    public static int[][] DP = new int[MAX_EDGE + 1][MAX_EDGE + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= N ; i++){
            String str = br.readLine();
            for(int j = 1 ; j <= N ;j++){
                table[i][j] = str.charAt(j - 1);
            }
        }

        for(int i = 2; i <= N ; i++){
            DP[i][1] = (table[i - 1][1] == table[i][1] ? A : B) + DP[i - 1][1];
            DP[1][i] = (table[1][i - 1] == table[1][i] ? A : B) + DP[1][i - 1];
            
        }

        for(int i = 2 ; i <= N ; i++){
            for(int j = 2 ; j <= N ; j++){
                int upVal = table[i - 1][j] == table[i][j] ? A : B;
                int leftVal = table[i][j - 1] == table[i][j] ? A : B;
                DP[i][j] = Math.min(DP[i - 1][j] + upVal, DP[i][j - 1] + leftVal);
            }
        }

        int ans = 0;
        for(int i = 0 ; i <= N ; i++){
            for(int j = 0 ; j <= N ; j++){
                ans = Math.max(ans, DP[i][j]);
            }
        }

        System.out.println(ans);
    }
}