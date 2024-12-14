import java.io.*;
import java.util.*;

public class Main {
    static long[] prefix;
    static int[] A;
    static int n;

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

        // 가능한 모든 B를 고려
        // R1은 B보다 왼쪽에서 하나 선택, R2는 B보다 오른쪽에서 하나 선택
        // 여기서는 단순히 R1=1, R2=n과 같이 양끝을 택하는 그리디를 적용
        // 단, B는 R1,R2와 달라야 하므로 B≠1, B≠n이어야 의미가 있다.
        // 하지만 n=3 일 때는 B=2로 하면 R1=1, R2=3이 완벽히 들어맞는다.
        // n=7일 때는 B=7, R1=1, R2=2 로 해도 예제 정답 54를 얻을 수 있음.
        
        long ans=0;
        for (int B=1; B<=n; B++) {
            // R1,R2를 정하는 간단한 전략:
            // B가 1보다 크다면 왼쪽 끝(1)을 R1로 사용 가능
            // B가 n보다 작다면 오른쪽 끝(n)을 R2로 사용 가능
            // 만약 B=1이면 R1을 2로, R2를 n으로(또는 반대)
            // B=n이면 R1=1, R2=2와 같이 약간 조정

            int R1,R2;
            if (B==1) {
                if (n>=3) { 
                    R1=2; R2=n; 
                } else continue;
            } else if (B==n) {
                if (n>=3) {
                    R1=1; R2=2;
                } else continue;
            } else {
                R1=1; R2=n;
                // R1 또는 R2가 B와 같다면 조정 필요
                if (R1==B) R1=2; 
                if (R2==B && R2>R1) R2=n-1;
                if (R2==B && R2<R1) R2=n-1; 
                if (R1==R2 || R1==B || R2==B) continue; // 유효하지 않으면 스킵
            }

            if (R1==R2 || R1==B || R2==B) continue; // 같은 점이면 패스

            long score = getPathScore(R1,B,R1,R2) + getPathScore(R2,B,R1,R2);
            ans=Math.max(ans, score);
        }

        System.out.println(ans);
    }

    static long getPathScore(int Rstart,int B,int R1,int R2) {
        int start=Math.min(Rstart,B), end=Math.max(Rstart,B);
        long total=prefix[end]-prefix[start-1];
        if(R1>=start && R1<=end) total-=A[R1];
        if(R2>=start && R2<=end) total-=A[R2];
        return total;
    }
}
