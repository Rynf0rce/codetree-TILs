import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 2000;
    public static final long MAX_LONG = (long)1e10;
    public static int[] arr = new int[MAX_LENGTH + 1];
    public static long[][] DP = new long[MAX_LENGTH + 1][MAX_LENGTH + 1];
    public static int n = -1;

    public static int getPoint(int a, int b){
        if(a == 0 || b == 0){
            return 0;
        }
        return Math.abs(arr[a] - arr[b]);
    }

    public static long bitonic(){
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= n ; j++){
                DP[i][j] = MAX_LONG;
            }
        }

        DP[0][0] = 0;

        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= n ; j++){
                int next = Math.max(i, j) + 1;
                if(next > n){
                    continue;
                }

                DP[next][j] = Math.min(DP[next][j], DP[i][j] + getPoint(i, next));
                DP[i][next] = Math.min(DP[i][next], DP[i][j] + getPoint(j, next));
            }
        }

        long ans = MAX_LONG;
        for(int i = 0 ; i <= n ; i++){
            ans = Math.min(ans, DP[i][n]);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(bitonic());
    }
}