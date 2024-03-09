import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] arr = new int[MAX_LENGTH + 1];
    public static int[] DP = new int[MAX_LENGTH + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            int j = i;
            while(j < n && arr[j] < arr[j + 1]){
                j++;
            }
            ans = Math.max(ans, j - i + 1);
        }

        for(int i = 1 ; i <= n ; i++){
            int j = i;
            while(j < n && arr[j] > arr[j + 1]){
                j++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        System.out.println(ans);
    }
}