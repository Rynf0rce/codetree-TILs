import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[] arr = new int[MAX_LENGTH + 1];
    public static int[] prefix = new int[MAX_LENGTH + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            prefix[i] = arr[i] + prefix[i - 1];
        }

        int ans = 0;
        for(int i = 0 ; i < n - m + 1 ; i++){
            ans = Math.max(ans, prefix[i + m] - prefix[i]);
        }
        System.out.print(ans);
    }
}