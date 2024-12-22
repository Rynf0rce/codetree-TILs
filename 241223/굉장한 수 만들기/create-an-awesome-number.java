import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(minBoxes(n));
    }

    public static int minBoxes(int n) {
        List<Integer> weights = new ArrayList<>();
        int currentWeight = 0, step = 1;
        while (currentWeight <= n) {
            currentWeight += step * (step + 1) / 2; // 박스 무게: 계단식 합
            if (currentWeight > n) break;
            weights.add(currentWeight);
            step++;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int weight : weights) {
            for (int i = weight; i <= n; i++) {
                dp[i] = Math.min(dp[i], dp[i - weight] + 1);
            }
        }

        return dp[n];
    }
}
