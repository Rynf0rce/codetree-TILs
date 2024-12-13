import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] x = new int[n+1];
        int[] y = new int[n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i][j] = i번 체크포인트 도달, j개 스킵 시 최소 거리
        int[][] dp = new int[n+1][k+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }
        
        dp[1][0] = 0; // 시작점

        // 맨해튼 거리 계산 함수
        int[][] dist = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                dist[i][j] = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                // i번째 도달을 위해 이전 체크포인트 l로부터 점프
                for (int l = 1; l < i; l++) {
                    int skipCount = (i - 1) - l; 
                    if (j - skipCount >= 0 && dp[l][j - skipCount] != INF) {
                        dp[i][j] = Math.min(dp[i][j], dp[l][j - skipCount] + dist[l][i]);
                    }
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
