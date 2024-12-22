import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(minBoxes(n));
    }

    public static int minBoxes(int n) {
        // 삼각수의 합 리스트 생성
        List<Integer> weights = new ArrayList<>();
        int k = 1;
        int sum = 0;

        while (true) {
            int triangle = k * (k + 1) / 2; // 삼각수 T_k
            sum += triangle; // 삼각수의 합 S_k
            if (sum > n) break;
            weights.add(sum);
            k++;
        }

        // 그리디 알고리즘
        int count = 0;
        for (int i = weights.size() - 1; i >= 0; i--) {
            int weight = weights.get(i);
            while (n >= weight) {
                n -= weight;
                count++;
            }
            if (n == 0) break;
        }

        return count;
    }
}
