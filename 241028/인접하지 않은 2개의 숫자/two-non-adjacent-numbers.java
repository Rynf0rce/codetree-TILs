import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[] arr = new int[MAX_LENGTH + 1];
    public static int[] prefix = new int[MAX_LENGTH + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i <= n ; i++){
            prefix[i] = Math.max(arr[i], prefix[i - 1]);
        }

        int ans = 0;
        for(int i = n ; i > 2 ; i--){
            ans = Math.max(ans, arr[i] + prefix[i - 2]);
        }
        System.out.print(ans);
    }
}