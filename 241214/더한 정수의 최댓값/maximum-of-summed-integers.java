import java.io.*;
import java.util.*;

public class Main {
    static long[] prefix;
    static int[] A;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        A = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        prefix = new long[n+1];
        for (int i=1; i<=n; i++) {
            prefix[i] = prefix[i-1] + A[i];
        }

        long ans = Math.max(caseBAtEnd(), caseBAtStart());
        System.out.println(ans);
    }

    // B = n일 때 (R1 < R2 < B) 경우 최대 점수
    // 점수 = (prefix[n]-prefix[R1-1]-A[R1]) + (prefix[n]-prefix[R2-1]-2*A[R2])
    // R2에 대해 순회하며, R1<R2 조건에서 가능한 최대값을 탐색
    static long caseBAtEnd() {
        // X(R) = prefix[n]-prefix[R-1]-A[R]
        // Y(R) = prefix[n]-prefix[R-1]-2*A[R]
        // 점수 = X(R1)+Y(R2), R1<R2
        long best = Long.MIN_VALUE;
        long maxX = Long.MIN_VALUE;

        // 먼저 R1=1 일 때 X(1)을 초기 maxX로 둔다(이후 R2=2부터 시작)
        maxX = X_end(1);
        for (int R2=2; R2<=n-1; R2++) {
            best = Math.max(best, maxX + Y_end(R2));
            // R2를 다음 턴에 R1 후보로 사용하기 위해 maxX 갱신
            maxX = Math.max(maxX, X_end(R2));
        }
        return best;
    }

    static long X_end(int R) {
        return prefix[n] - prefix[R-1] - A[R];
    }

    static long Y_end(int R) {
        return prefix[n] - prefix[R-1] - 2L*A[R];
    }

    // B = 1일 때 (B < R1 < R2) 경우 최대 점수
    // 점수 = (prefix[R1]-2*A[R1]) + (prefix[R2]-A[R2]) = X(R1)+Y(R2)
    // R1<R2이므로 R2를 순회하며 R1에 대해 최대 X(R1) 유지
    static long caseBAtStart() {
        // X(R)=prefix[R]-2*A[R], Y(R)=prefix[R]-A[R]
        // R2는 최소 3부터 가능(R1≥2, R1<R2 이므로 R2≥3)
        if (n < 3) return Long.MIN_VALUE; // 안전장치

        long best = Long.MIN_VALUE;
        long maxX = X_start(2); // R1=2를 초기값

        for (int R2=3; R2<=n-1; R2++) {
            best = Math.max(best, maxX + Y_start(R2));
            maxX = Math.max(maxX, X_start(R2));
        }
        return best;
    }

    static long X_start(int R) {
        return prefix[R] - 2L*A[R];
    }

    static long Y_start(int R) {
        return prefix[R] - A[R];
    }
}
