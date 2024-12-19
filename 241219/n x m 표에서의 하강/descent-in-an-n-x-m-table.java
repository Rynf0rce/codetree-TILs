import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 크기
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DP 배열 정의: dp[i][j][dir]
        int[][][] dp = new int[n][m][3];
        int INF = 1_000_000_000; // 오버플로우 방지를 위한 큰 값

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }

        // 첫 번째 행 초기화
        for (int j = 0; j < m; j++) {
            dp[0][j][0] = grid[0][j];
            dp[0][j][1] = grid[0][j];
            dp[0][j][2] = grid[0][j];
        }

        // DP 갱신
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 남서쪽에서 오는 경우 (dir = 0)
                if (j > 0) {
                    dp[i][j][0] = Math.min(dp[i][j][0], dp[i - 1][j - 1][1] + grid[i][j]);
                    dp[i][j][0] = Math.min(dp[i][j][0], dp[i - 1][j - 1][2] + grid[i][j]);
                }
                // 바로 위에서 오는 경우 (dir = 1)
                dp[i][j][1] = Math.min(dp[i][j][1], dp[i - 1][j][0] + grid[i][j]);
                dp[i][j][1] = Math.min(dp[i][j][1], dp[i - 1][j][2] + grid[i][j]);
                // 남동쪽에서 오는 경우 (dir = 2)
                if (j < m - 1) {
                    dp[i][j][2] = Math.min(dp[i][j][2], dp[i - 1][j + 1][0] + grid[i][j]);
                    dp[i][j][2] = Math.min(dp[i][j][2], dp[i - 1][j + 1][1] + grid[i][j]);
                }
            }
        }

        // 마지막 행에서 최소합 계산
        int minSum = INF;
        for (int j = 0; j < m; j++) {
            for (int dir = 0; dir < 3; dir++) {
                minSum = Math.min(minSum, dp[n - 1][j][dir]);
            }
        }

        System.out.println(minSum);
    }
}
