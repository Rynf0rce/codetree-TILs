import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_ROOM = 1003;
    public static final int MAX_INT = (int)1e9;
    public static int[] arr = new int[MAX_ROOM + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = MAX_INT;
        for(int i = 1 ; i <= n ; i++){
            int cnt = 0;
            int idx = i;
            int sum = 0;
            while(cnt < n){
                sum += arr[idx] * cnt;
                idx++;
                cnt++;
                if(idx > n){
                    idx = 1;
                }
            }
            ans = Math.min(ans, sum);
        }
        System.out.print(ans);
    }
}