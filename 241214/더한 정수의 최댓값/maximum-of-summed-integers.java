import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n+1];
        for(int i=1;i<=n;i++) arr[i]=sc.nextInt();
        
        long[] P=new long[n+1]; // prefix sum
        for(int i=1;i<=n;i++) P[i]=P[i-1]+arr[i];
        
        long INF=Long.MAX_VALUE/2;

        // 시나리오 A 준비 (B=z)
        // Score_A = 2*P[z] - min_{x<y<z}(P[x-1]+P[y-1]+arr[x]+2*arr[y])
        // 이를 효율적으로: 
        // W_A(x,y)= (P[x-1]+arr[x]) + (P[y-1]+2*arr[y])
        // M1[i] = min_{j<i}(P[j-1]+arr[j])
        // 그 다음 M2[i] = min(M2[i-1], M1[i] + P[i-1]+2*arr[i])
        long[] M1=new long[n+1];
        Arrays.fill(M1, INF);
        long minU=INF; 
        // U[i]=P[i-1]+arr[i]
        for (int i=1;i<=n;i++){
            minU = Math.min(minU, P[i-1]+arr[i]);
            M1[i]=minU;
        }
        long[] M2=new long[n+1];
        Arrays.fill(M2, INF);
        for(int i=2;i<=n;i++){
            M2[i]=Math.min(M2[i-1], M1[i-1] + (P[i-1]+2L*arr[i]));
        }
        
        long maxA=-INF;
        // z must be > 2 to have x<y<z
        for(int z=3; z<=n; z++){
            if(M2[z-1]!=INF){
                long valA = 2*P[z] - M2[z-1];
                maxA=Math.max(maxA,valA);
            }
        }

        // 시나리오 B (B=y)
        // Score_B(y) = (P[y]-min_{x<y}(P[x-1]+arr[x])) + (max_{z>y}(P[z]-arr[z]) - P[y-1])
        long[] prefixMinForB=new long[n+1];
        Arrays.fill(prefixMinForB, INF);
        long currentMin=INF; 
        for(int i=1;i<=n;i++){
            long val = P[i-1]+arr[i];
            currentMin = Math.min(currentMin,val);
            prefixMinForB[i]=currentMin;
        }
        
        long[] suffixMaxForB=new long[n+2];
        Arrays.fill(suffixMaxForB, -INF);
        long currentMax=-INF;
        for(int i=n;i>=1;i--){
            long val=P[i]-arr[i];
            currentMax=Math.max(currentMax,val);
            suffixMaxForB[i]=currentMax;
        }
        
        long maxB=-INF;
        // y must be such that there exists x<y and z>y, so 2<=y<=n-1
        for(int y=2;y<=n-1;y++){
            long leftTerm = P[y]-prefixMinForB[y-1]; 
            if(suffixMaxForB[y+1]!=-INF){
                long rightTerm = suffixMaxForB[y+1]-P[y-1];
                long valB = leftTerm+rightTerm;
                maxB=Math.max(maxB,valB);
            }
        }

        // 시나리오 C (B=x)
        // Score_C(x) = -2*P[x-1] + max_{y> x < z}( (P[y]-2*arr[y])+(P[z]-arr[z]) )
        // A1[i]=P[i]-2*arr[i], A2[i]=P[i]-arr[i]
        // max_{y<z}(A1[y]+A2[z])를 suffix 이용해서 O(n)에 가능.
        long[] A1=new long[n+1];
        long[] A2=new long[n+1];
        for(int i=1;i<=n;i++){
            A1[i]=P[i]-2L*arr[i];
            A2[i]=P[i]-arr[i];
        }
        
        // M3[i] = max_{j≥i} A2[j]
        long[] M3=new long[n+2];
        Arrays.fill(M3, -INF);
        currentMax=-INF;
        for(int i=n;i>=1;i--){
            currentMax=Math.max(currentMax,A2[i]);
            M3[i]=currentMax;
        }
        
        // M4[i] = max_{j≥i}(A1[j]+M3[j+1])
        long[] M4=new long[n+2];
        Arrays.fill(M4,-INF);
        currentMax=-INF;
        for(int i=n;i>=1;i--){
            if(i+1<=n) {
                long val = A1[i]+M3[i+1];
                currentMax = Math.max(currentMax,val);
            }
            M4[i]=currentMax;
        }
        
        long maxC=-INF;
        // x must allow at least y>x and z>y, so x ≤ n-2
        for(int x=1; x<=n-2; x++){
            if(M4[x+1]!=-INF){
                long valC = -2*P[x-1] + M4[x+1];
                maxC=Math.max(maxC,valC);
            }
        }

        long answer=Math.max(maxA, Math.max(maxB, maxC));
        System.out.println(answer);
    }
}
