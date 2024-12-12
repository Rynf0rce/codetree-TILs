import java.util.*;
import java.io.*;

public class Main {
    public static PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
    public static double total = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()){
            double num = Double.parseDouble(st.nextToken());
            total += num;
            pq.add(num);
        }

        double ans = 0;
        while(pq.size() > 1){
            double num = pq.poll();
            ans += (total - num) * num;
            total -= num;
        }
        System.out.printf("%.0f", ans);
    }
}