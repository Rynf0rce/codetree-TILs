import java.io.*;

public class Main {
    static final int MOD = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(countDecodings(s));
    }

    public static int countDecodings(String s) {
        int n = s.length();

        // 숫자가 없으면 변환 불가
        if (n == 0 || s.charAt(0) == '0') return 0;

        // DP 배열 정의
        int[] dp = new int[n + 1];
        dp[0] = 1; // 아무 것도 변환하지 않는 경우
        dp[1] = 1; // 첫 번째 숫자는 변환 가능 (이미 0이 아닌 경우)

        // DP 점화식 계산
        for (int i = 2; i <= n; i++) {
            // 현재 숫자
            int oneDigit = s.charAt(i - 1) - '0';
            int twoDigits = (s.charAt(i - 2) - '0') * 10 + oneDigit;

            // 한 자리 숫자 변환 가능
            if (oneDigit >= 1) {
                dp[i] = (dp[i] + dp[i - 1]) % MOD;
            }

            // 두 자리 숫자 변환 가능
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] = (dp[i] + dp[i - 2]) % MOD;
            }
        }

        return dp[n];
    }
}
