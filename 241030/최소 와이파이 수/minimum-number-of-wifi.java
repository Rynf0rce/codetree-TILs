import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[] arr = new int[MAX_LENGTH * 2 + 1];
    public static boolean[] visited = new boolean[MAX_LENGTH * 2 + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] == 1 && !visited[i]){
                for(int j = i ; j <= i + 2 * m ; j++){
                    visited[j] = true;
                }
                ans++;
            }
        }
        System.out.print(ans);
    }
}