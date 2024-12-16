import java.io.*;
import java.util.*;

public class Main {
    static class Fenwick {
        int n; long[] fenw;
        Fenwick(int n){this.n=n;fenw=new long[n+1];}
        void update(int i, long v){
            for(;i<=n;i+=i&(-i)) fenw[i]+=v;
        }
        long sum(int i){
            long s=0;
            for(;i>0;i-=i&(-i)) s+=fenw[i];
            return s;
        }
        long range(int l,int r){
            if(r<l)return 0;
            return sum(r)-sum(l-1);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] t=br.readLine().split(" ");
        int N=Integer.parseInt(t[0]);
        int L=Integer.parseInt(t[1]);
        int C=Integer.parseInt(t[2]);
        int[] s=new int[N];
        for(int i=0;i<N;i++){
            s[i]=Integer.parseInt(br.readLine());
        }

        int max_s = 0;
        for(int v:s) if(v>max_s) max_s=v;
        
        // 속력 정렬
        Arrays.sort(s);

        // X[i], R[i] 계산
        long[] X=new long[N];
        int[] R=new int[N];
        for(int i=0;i<N;i++){
            long val=(long)s[i]*L;
            X[i]=val/max_s;
            R[i]=(int)(val%max_s);
        }

        // Σ X와 Σ i*X[i]를 위한 prefix sum
        long[] PX=new long[N+1];   // PX[i]=X[1]+...+X[i]
        long[] PX2=new long[N+1];  // PX2[i]=1*X[1]+2*X[2]+...+i*X[i]
        for (int i=1;i<=N;i++){
            PX[i]=PX[i-1]+X[i-1];
            PX2[i]=PX2[i-1]+X[i-1]*(i);
        }

        // Σ_{i<j}(X[j]-X[i]) = 2*PX2[N] - (N+1)*PX[N]
        long sumXDiff = 2*PX2[N] - (long)(N+1)*PX[N];

        // R 배열에 대한 inversion count (R[j]<R[i])
        // R의 범위: 0 ≤ R[i]<max_s
        Fenwick fenw=new Fenwick(max_s);
        long inversions=0;
        for(int i=0;i<N;i++){
            // i번째를 넣기 전에 fenw에 있던 값 중 R값이 R[i]보다 큰 것의 개수:
            // = fenw.range(R[i]+2, max_s) → 하지만 fenw는 누적이므로 아래와 같이
            // 여기서는 R[i]보다 큰 값의 개수를 구해야 한다.
            if(R[i]<max_s) inversions+=fenw.range(R[i]+2, max_s);
            fenw.update(R[i]+1,1);
        }

        long answer = sumXDiff - inversions;
        System.out.println(answer);
    }
}
