import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static int[] arr = new int[MAX_LENGTH];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        pq.add(arr[n - 1]);
        int sum = arr[n - 1];
        int cnt = 1;
        double ans = arr[n - 1];
        for(int i = n - 2 ; i >= 0 ; i--){
            pq.add(arr[i]);
            sum += arr[i];
            ans = Math.max(ans, (double)(sum - pq.peek()) / cnt);
            cnt++;
        }
        System.out.printf("%.2f", ans);
    }
}