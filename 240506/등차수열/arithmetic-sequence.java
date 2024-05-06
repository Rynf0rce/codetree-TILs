import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[] arr = new int[MAX_LENGTH];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = 100;
        int end = 0;
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            start = Math.min(start, arr[i]);
            end = Math.max(end, arr[i]);
        }

        int ans = 0;
        for(int k = start ; k <= end ; k++){
            int cnt = 0;
            for(int i = 0 ; i < n - 1 ; i++){
                for(int j = i + 1 ; j < n ; j++){
                    if(arr[j] - k == k - arr[i]){
                        cnt++;
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.print(ans);
    }
}