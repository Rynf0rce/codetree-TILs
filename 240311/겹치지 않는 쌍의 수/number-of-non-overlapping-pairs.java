import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_INT = 5000;
    public static int[] arr = new int[MAX_INT];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            for(int j = 0 ; j < num ; j++){
                int idx = Integer.parseInt(st.nextToken());
                arr[i] = arr[i] ^ (1 << idx);
            }
        }

        int cnt = 0;
        for(int i = 0 ; i < n - 1 ; i++){
            for(int j = i + 1 ; j < n ; j++){
                if( (arr[i] ^ arr[j]) == (arr[i] | arr[j]) ){
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
}