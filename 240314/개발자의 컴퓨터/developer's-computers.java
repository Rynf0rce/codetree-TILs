import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_TIME = 1000;
    public static int[] arr = new int[MAX_TIME + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            for(int j = start ; j <= end ; j++){
                arr[j] += num;
            }
        }

        int ans = 0;
        for(int i = 1 ; i <= MAX_TIME ; i++){
            ans = Math.max(ans, arr[i]);
        }
        System.out.print(ans);
    }
}