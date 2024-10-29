import java.util.*;
import java.io.*;
public class Main {
    public static final int MAX_LENGTH = 1000;
    public static int[] arrCost = new int[MAX_LENGTH + 1];
    public static int[] packetCost = new int[MAX_LENGTH + 1];
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            arrCost[i] = Integer.parseInt(st.nextToken());
            packetCost[i] = Integer.parseInt(st.nextToken());
        }
        
        int ans = 0;
        for(int i = 0 ; i < N ; i++){
            int cnt = 0;
            int budget = B;
            for(int j = 0 ; j < N ; j++){
                int cost = i == j ? arrCost[j] / 2 : arrCost[j];
                pq.add(cost + packetCost[j]);
            }

            while(!pq.isEmpty()){
                int cost = pq.poll();
                if(budget - cost < 0){
                    break;
                }
                
                budget -= cost;
                cnt++;
            }

            ans = Math.max(ans, cnt);

            pq.clear();
        }

        System.out.print(ans);
    }
}