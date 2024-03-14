import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_POINT = 16;
    public static final int MAX_INT = (int)1e7;
    public static int[][] dist = new int[MAX_POINT][MAX_POINT];
    public static int[][] DP = new int[1 << MAX_POINT][MAX_POINT];
    public static int n = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++){
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < (1 << n) ; i++){
            for(int j = 0 ; j < n ; j++){
                DP[i][j] = MAX_INT;
            }
        }

        DP[1][0] = 0;

        for(int i = 0 ; i < (1 << n) ; i++){
            for(int j = 0 ; j < n ; j++){
                if(((i >> j) & 1) == 0){
                    continue;
                }

                for(int k = 0 ; k < n ; k++){
                    if(((i >> k) & 1) == 1 || dist[j][k] == 0){
                        continue;
                    }

                    DP[i + (1 << k)][k] = Math.min(DP[i + (1 << k)][k], DP[i][j] + dist[j][k]);
                }
            }
        }

        int ans = MAX_INT;
        for(int i = 0 ; i < n ; i++){
            if(dist[i][0] == 0){
                continue;
            }
            ans = Math.min(ans, DP[(1 << n) - 1][i] + dist[i][0]);
        }
        System.out.print(ans);
    }
}