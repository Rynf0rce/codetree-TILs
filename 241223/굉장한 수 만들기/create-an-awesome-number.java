import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(minBoxes(n));
    }

    public static int minBoxes(int n) {
        // 1. 삼각수 계산
        List<Integer> triangularNumbers = new ArrayList<>();
        int k = 1;
        while (true) {
            int triangle = k * (k + 1) / 2; // T_k = k(k+1)/2
            if (triangle > n) break;
            triangularNumbers.add(triangle);
            k++;
        }

        // 2. DP 배열 초기화
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); // 큰 값으로 초기화
        dp[0] = 0; // 무게 0은 상자가 필요 없음

        // 3. DP 점화식 계산
        for (int triangle : triangularNumbers) {
            for (int i = triangle; i <= n; i++) {
                dp[i] = Math.min(dp[i], dp[i - triangle] + 1);
            }
        }

        // 4. 결과 반환
        return dp[n];
    }
}
