import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 50;
    public static int[] arr = new int[MAX_LENGTH];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int weight = 0;
        int ans = 1;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            weight += arr[i];
            if(weight > m){
                ans++;
                weight = arr[i];
            }
        }
        System.out.println(ans);
    }
}