import java.util.*;
import java.io.*;

public class Main {
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            pq.add(-1 * Integer.parseInt(st.nextToken()));
        }

        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            
            if(first == second){
                continue;
            }

            pq.add((first - second));
        }

        System.out.print(pq.isEmpty() ? -1 : (pq.peek() * -1));
    }
}