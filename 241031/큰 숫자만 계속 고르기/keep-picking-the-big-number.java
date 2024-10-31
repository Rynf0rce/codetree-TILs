import java.util.*;
import java.io.*;

public class Main {
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            pq.add(Integer.parseInt(st.nextToken()) * -1);
        }

        for(int i = 0 ; i < m ; i++){
            int num = (pq.poll() * -1) - 1;
            pq.add(num * -1);
        }

        System.out.print(pq.peek() * -1);
    }
}