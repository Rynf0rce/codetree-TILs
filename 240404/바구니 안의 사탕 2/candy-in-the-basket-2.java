import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[] arr = new int[MAX_LENGTH + 1];
    public static int[] prefix = new int[MAX_LENGTH + 1];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int cnt = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            arr[idx] += cnt;
        }

        for(int i = 1 ; i <= MAX_LENGTH ; i++){
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int ans = 0;
        for(int i = 1 ; i <= MAX_LENGTH - 2 * K ; i++){
            ans = Math.max(ans, prefix[i + 2 * K] - prefix[i - 1]);
        }
        System.out.print(ans);
    }
}