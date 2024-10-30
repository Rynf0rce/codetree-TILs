import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] arr = new int[MAX_LENGTH * 2];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < 2 * n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 0, 2 * n);
        
        int ans = (int)1e9;
        for(int i = 0 ; i < n ; i++){
            ans = Math.min(ans, arr[n + i] - arr[i]);
        }
        System.out.print(ans);
    }
}