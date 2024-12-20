import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 소수의 개수를 계산하여 출력
        System.out.println(countPrimesInRange(a, b));
    }

    public static int countPrimesInRange(int a, int b) {
        // 1. 에라토스테네스의 체로 sqrt(b)까지 소수 구하기
        int sqrtB = (int) Math.sqrt(b);
        boolean[] isPrime = new boolean[sqrtB + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // 0과 1은 소수가 아님

        for (int i = 2; i * i <= sqrtB; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= sqrtB; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 2. a 이상 b 이하의 소수를 판별하기 위한 배열
        boolean[] isPrimeInRange = new boolean[b - a + 1];
        Arrays.fill(isPrimeInRange, true);

        // 3. sqrt(b)까지의 소수를 사용하여 범위 [a, b]에서 소수 제거
        for (int i = 2; i <= sqrtB; i++) {
            if (isPrime[i]) {
                // i의 배수를 제거
                int start = Math.max(i * i, (a + i - 1) / i * i); // i^2 또는 범위 내에서 가장 작은 배수
                for (int j = start; j <= b; j += i) {
                    isPrimeInRange[j - a] = false;
                }
            }
        }

        // 4. [a, b] 범위에서 소수의 개수 계산
        int primeCount = 0;
        for (int i = 0; i < isPrimeInRange.length; i++) {
            if (isPrimeInRange[i]) {
                primeCount++;
            }
        }

        return primeCount;
    }
}
