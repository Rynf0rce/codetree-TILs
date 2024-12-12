import java.util.*;
import java.io.*;

public class Main {
    public static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public static int total = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            total += num;
            pq.add(num);
        }

        int ans = 0;
        while(pq.size() > 1){
            int num = pq.poll();
            ans += (total - num) * num;
            total -= num;
        }
        System.out.print(ans);
    }
}