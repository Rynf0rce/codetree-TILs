import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 1000;
    public static int[] arr = new int[MAX_LENGTH + 1];
    public static int[] preSum = new int[MAX_LENGTH + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i <= n ; i++){
            preSum[i] = arr[i - 1] + preSum[i - 1];
        }

        int ans = -1000;
        for(int i = 1 ; i <= n ; i++){
            for(int j = i ; j <= n ; j++){
                ans = Math.max(ans, preSum[j] - preSum[i - 1]);
            }
        }
        System.out.print(ans);
    }
}