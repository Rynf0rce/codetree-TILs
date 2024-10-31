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
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        double ans = sum / n;
        for(int i = 0 ; i < n - 2; i++){
            for(int j = i + 1 ; j < n ; j++){
                pq.add(arr[j]);
            }

            boolean triger = true;
            int val = 0;
            int cnt = 0;
            while(!pq.isEmpty()){
                int num = pq.poll();
                if(triger){
                    triger = false;
                    continue;
                }

                val += num;
                cnt++;
            }
            ans = Math.max(ans, val / cnt);
        }
        System.out.printf("%.2f", ans);
    }
}