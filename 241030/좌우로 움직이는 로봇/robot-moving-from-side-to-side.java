import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 50000;
    public static int[] A = new int[MAX_LENGTH + 1];
    public static int[] B = new int[MAX_LENGTH + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int A_loc = 1;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            for(int j = 0 ; j < t ; j++){
                if(d == 'L'){
                    A[A_loc] = A[A_loc - 1] - 1;
                }
                else{
                    A[A_loc] = A[A_loc - 1] + 1;
                }
                A_loc++;
            }
        }

        int B_loc = 1;
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            for(int j = 0 ; j < t ; j++){
                if(d == 'L'){
                    B[B_loc] = B[B_loc - 1] - 1;
                }
                else{
                    B[B_loc] = B[B_loc - 1] + 1;
                }
                B_loc++;
            }
        }

        int A_pos = 0;
        int B_pos = 0;
        boolean flag = true;
        int ans = 0;
        for(int i = 1 ; i <= Math.max(A_loc, B_loc) ; i++){
            if(i <= A_loc){
                A_pos = A[i];
            }

            if(i <= B_loc){
                B_pos = B[i];
            }
            
            if(A_pos == B_pos){
                if(flag){
                    ans++;
                }
                flag = false;
                continue;
            }
            
            flag = true;
        }
        System.out.println(ans);
    }
}