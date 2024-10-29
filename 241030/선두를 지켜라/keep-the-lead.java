import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 10000000;
    public static int[] A = new int[MAX_LENGTH];
    public static int[] B = new int[MAX_LENGTH];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int dist = 1;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            for(int j = 0 ; j < t ; j++){
                A[dist] = A[dist - 1] + v;
                dist++;
            }
        }

        int maxDist = dist;

        dist = 1;
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            for(int j = 0 ; j < t ; j++){
                B[dist] = B[dist - 1] + v;
                dist++;
            }
        }

        maxDist = Math.max(maxDist, dist);

        int flag = 0;
        int ans = 0;
        for(int i = 0 ; i < maxDist ; i++){
            if(flag == 0){
                if(A[i] > B[i]){
                    flag = 1;
                }
                else if(A[i] < B[i]){
                    flag = 2;
                }
                continue;
            }

            if(flag == 1 && A[i] < B[i]){
                flag = 2;
                ans++;
            }
            
            if(flag == 2 && A[i] > B[i]){
                flag = 1;
                ans++;
            }
        }
        System.out.print(ans);
    }
}