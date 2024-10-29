import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 10000000;
    public static int[] A = new int[MAX_LENGTH];
    public static int[] B = new int[MAX_LENGTH];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cnt = 1;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            char c = st.nextToken().charAt(0);
            int dis = Integer.parseInt(st.nextToken());
            for(int j = 0 ; j < dis ; j++){
                if(c == 'R'){
                    A[cnt] = A[cnt - 1] + 1;
                }
                else{
                    A[cnt] = A[cnt - 1] - 1;
                }
                cnt++;
            }
        }

        int max_dist = cnt;

        cnt = 1;
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            char c = st.nextToken().charAt(0);
            int dis = Integer.parseInt(st.nextToken());
            for(int j = 0 ; j < dis ; j++){
                if(c == 'R'){
                    B[cnt] = B[cnt - 1] + 1;
                }
                else{
                    B[cnt] = B[cnt - 1] - 1;
                }
                cnt++;
            }
        }

        max_dist = Math.max(max_dist, cnt);

        int ans = -1;
        for(int i = 1 ; i < max_dist ; i++){
            // System.out.println(A[i] + " " + B[i]);
            if(A[i] == B[i]){
                ans = i;
                break;
            }
        }
        System.out.print(ans);
    }
}