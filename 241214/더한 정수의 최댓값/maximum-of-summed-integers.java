import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n+1];
        for(int i=1;i<=n;i++) arr[i]=sc.nextInt();
        
        long[] P=new long[n+1]; // prefix sum
        for(int i=1;i<=n;i++) P[i]=P[i-1]+arr[i];
        
        // Scenario A: R1<R2<B
        // We need min of (P[R1]+P[R2]+arr[R2]) for R1<R2.
        // Precompute minPairA[i]: minimal (P[R1]+P[i]+arr[i]) for 1<i<=n
        long INF=Long.MAX_VALUE/2;
        long minP = INF;
        long[] minPairA=new long[n+1]; // min pair cost up to i
        Arrays.fill(minPairA, INF);
        for(int i=1;i<=n;i++){
            // R2=i
            // cost(R1,R2)=P[R1]+P[i]+arr[i], need min P[R1] for R1<i
            if(i>1 && minP!=INF){
                long cost=minP+P[i]+arr[i];
                minPairA[i]=Math.min(minPairA[i-1], cost);
            } else {
                minPairA[i]=(i==1?INF:minPairA[i-1]);
            }
            // update minP = min of P[j] for j<i
            if(i>=1) minP=Math.min(minP,P[i]);
        }

        // Scenario B: R1<B<R2
        // scenario B for B = arr[B] + (max_{R2>B}(P[R2]-arr[R2])) - (min_{R1<B}(P[R1]))
        long[] prefixMinP=new long[n+1];
        prefixMinP[1]=P[1];
        for(int i=2;i<=n;i++){
            prefixMinP[i]=Math.min(prefixMinP[i-1],P[i]);
        }

        long[] suffixMaxPA=new long[n+2]; 
        // suffix max of (P[i]-arr[i])
        suffixMaxPA[n+1]= -INF;
        for(int i=n;i>=1;i--){
            suffixMaxPA[i]=Math.max(suffixMaxPA[i+1], P[i]-arr[i]);
        }

        // Scenario C: B<R1<R2
        // scenario C for B = -2*P[B-1] + max_{R1<R2, R1,R2>B}(A1[R1]+A2[R2])
        // Precompute maxPairC:
        long[] A1=new long[n+1];
        long[] A2=new long[n+1];
        for(int i=1;i<=n;i++){
            A1[i]=P[i]-2L*arr[i];
            A2[i]=P[i]-arr[i];
        }

        // We want max of A1[R1]+A2[R2] for R1<R2.
        // Similar to scenario A logic, but we find max pairs:
        long maxA1 = -INF;
        long[] pairCostC=new long[n+1];
        Arrays.fill(pairCostC, -INF);
        // For pair (R1<R2), if we fix R2=i, we want max A1[R1] for R1<i.
        long[] maxPairC=new long[n+1];
        Arrays.fill(maxPairC, -INF);
        long currentMaxA1=-INF;
        for(int i=1;i<=n;i++){
            if(i>1 && currentMaxA1!=-INF){
                pairCostC[i]=A2[i]+currentMaxA1;
            }
            maxPairC[i]=(i==1?pairCostC[i]:Math.max(maxPairC[i-1], pairCostC[i]));
            currentMaxA1=Math.max(currentMaxA1, A1[i]);
        }
        
        // Now compute the final answer:
        long answer=-INF;
        for(int B=1;B<=n;B++){
            // scenario A: need B>2 to form pairs (R1,R2<B)
            if(B>=3 && minPairA[B-1]!=INF){
                long valA=2*P[B]-minPairA[B-1];
                answer=Math.max(answer,valA);
            }
            // scenario B: need B not at ends, and also need R1<B and R2>B
            if(B>1 && B<n){
                long prefixMin = prefixMinP[B-1]; // min P[R1], R1<B
                long suffixMax = suffixMaxPA[B+1]; // max(P[R2]-arr[R2]), R2>B
                if(prefixMin!=INF && suffixMax!=-INF) {
                    long valB = arr[B] + suffixMax - prefixMin;
                    answer=Math.max(answer,valB);
                }
            }
            // scenario C: B<R1<R2 means at least we need B<n-1 for pairs
            if(B<=n-2 && maxPairC[n]>=-INF) {
                // we use maxPairC[B+1], pairs must start after B+1
                if(B+1<=n && maxPairC[n]>=-INF && B+1<=n) {
                    if(B+2<=n && maxPairC[B+2]!=-INF) {
                        long valC = -2*P[B-1] + maxPairC[B+2];
                        answer=Math.max(answer,valC);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
