import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine()); // 장애물의 개수

        boolean[][] horizontalBlock = new boolean[n + 1][m]; // 가로 장애물
        boolean[][] verticalBlock = new boolean[n][m + 1]; // 세로 장애물

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (a == c) {
                // 가로 장애물
                horizontalBlock[a][Math.min(b, d)] = true;
            } else {
                // 세로 장애물
                verticalBlock[Math.min(a, c)][b] = true;
            }
        }

        System.out.println(countPaths(n, m, horizontalBlock, verticalBlock));
    }

    public static long countPaths(int n, int m, boolean[][] horizontalBlock, boolean[][] verticalBlock) {
        long[][] dp = new long[n + 1][m + 1];
        dp[0][0] = 1;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i > 0 && !verticalBlock[i - 1][j]) {
                    dp[i][j] += dp[i - 1][j]; // 위쪽에서 오는 경로
                }
                if (j > 0 && !horizontalBlock[i][j - 1]) {
                    dp[i][j] += dp[i][j - 1]; // 왼쪽에서 오는 경로
                }
            }
        }

        return dp[n][m];
    }
}
