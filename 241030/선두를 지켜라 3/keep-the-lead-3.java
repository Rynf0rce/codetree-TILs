import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 1000000;
    public static int[] A = new int[MAX_LENGTH];
    public static int[] B = new int[MAX_LENGTH];

    public static int fuc(int idx){
        if(A[idx] > B[idx]){
            return 1;
        }
        else if(A[idx] < B[idx]){
            return 2;
        }
        else{
            return 3;
        }
    }

    public static void main(String[] args) throws IOException {
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

        int ans = 0;
        int flag = -1;
        for(int i = 1 ; i < dist ; i++){
            int culVal = fuc(i);
            if(flag != culVal){
                ans++;
                flag = culVal;
            }
        }
        System.out.print(ans);
    }
}