import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] A;
    static long[] prefix;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine().trim());
        A=new int[n+1];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            A[i]=Integer.parseInt(st.nextToken());
        }

        prefix=new long[n+1];
        for(int i=1;i<=n;i++){
            prefix[i]=prefix[i-1]+A[i];
        }

        long ans = Math.max(caseBAtEnd(), caseBAtStart());
        System.out.println(ans);
    }

    // B = n일 때 (R1 < R2 < B)
    // 점수 = (prefix[n]-prefix[R1-1]-A[R1]) + (prefix[n]-prefix[R2-1]-2*A[R2])
    //       = X(R1) + Y(R2) 형태
    static long caseBAtEnd() {
        // X(R) = prefix[n]-prefix[R-1]-A[R]
        // Y(R) = prefix[n]-prefix[R-1]-2*A[R]
        // R1<R2 이므로 R2를 증가시키면서 R1 후보에 대한 최대 X(R1)을 갱신
        if(n<3) return 0; 
        long maxScore = Long.MIN_VALUE;
        long maxX = Long.MIN_VALUE;

        // R2는 최소 2부터 가능(R1=1 고정 후 시작 가능)
        // 시작할 때 R1=1일 때의 X(1)을 초기 maxX로 둔다
        maxX = X_end(1);
        for (int R2=2; R2<=n-1; R2++) {
            // 현재 R2에 대해 maxScore 갱신
            maxScore = Math.max(maxScore, maxX + Y_end(R2));
            // R2를 다음 턴에 R1로 사용 가능하므로 maxX 갱신
            maxX = Math.max(maxX, X_end(R2));
        }

        return maxScore;
    }

    static long X_end(int R) {
        return prefix[n]-prefix[R-1]-A[R];
    }

    static long Y_end(int R) {
        return prefix[n]-prefix[R-1]-2L*A[R];
    }

    // B = 1일 때 (B < R1 < R2)
    // 점수 = (prefix[R1]-2*A[R1]) + (prefix[R2]-A[R2]) = X(R1) + Y(R2)
    // R1<R2 이므로 R2를 증가시키며 최대 X(R1)을 추적
    static long caseBAtStart() {
        if(n<3) return 0;
        long maxScore = Long.MIN_VALUE;
        long maxX = X_start(2); // R1=2부터 시작 가능

        for (int R2=3; R2<=n-1; R2++) {
            maxScore = Math.max(maxScore, maxX + Y_start(R2));
            maxX = Math.max(maxX, X_start(R2));
        }

        return maxScore;
    }

    static long X_start(int R) {
        return prefix[R]-2L*A[R];
    }

    static long Y_start(int R) {
        return prefix[R]-A[R];
    }
}
