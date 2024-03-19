import java.util.*;
import java.io.*;
public class Main {
    public static final int MAX_LENGTH = 1000;
    public static int[] arr = new int[MAX_LENGTH];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 0, n);
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            ans += arr[i] * (n - i);
        }
        System.out.print(ans);
    }
}