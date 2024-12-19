import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기
        int n = Integer.parseInt(st.nextToken()); // 동전의 개수
        int m = Integer.parseInt(st.nextToken()); // 목표 금액

        int[] coins = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        // DP 배열 정의
        int[] dp = new int[m + 1];
        dp[0] = 1; // 0원을 만드는 방법은 1가지 (아무것도 사용하지 않음)

        // DP 점화식 계산
        for (int coin : coins) {
            for (int i = coin; i <= m; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % MOD;
            }
        }

        // 결과 출력
        System.out.println(dp[m]);
    }
}
