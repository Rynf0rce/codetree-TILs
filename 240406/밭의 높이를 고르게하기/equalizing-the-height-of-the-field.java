import java.util.*;
import java.io.*;

public class Main {
    public static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            int gap = Math.abs(Integer.parseInt(st.nextToken()) - H);
            if(pq.size() < T){
                pq.add(Math.abs(gap));
            }
            else if(pq.peek() > Math.abs(gap)) {
                pq.poll();
                pq.add(gap);
            }
        }

        int ans = 0;
        while(!pq.isEmpty()){
            ans += pq.poll();
        }
        System.out.print(ans);
    }
}