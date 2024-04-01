import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LOC = 10000;
    public static int[] arr = new int[MAX_LOC + 1];
    public static int[] prefix = new int[MAX_LOC + 1];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int idx = Integer.parseInt(st.nextToken());
            int value = String.valueOf(st.nextToken()).charAt(0) == 'G' ? 1 : 2;
            arr[idx] = value;
        }

        for(int i = 1 ; i <= MAX_LOC ; i++){
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int ans = 0;
        for(int i = 1 ; i <= MAX_LOC - K ; i++){
            ans = Math.max(ans, prefix[i + K] - prefix[i - 1]);
        }
        System.out.print(ans);
    }
}