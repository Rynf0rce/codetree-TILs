import java.util.*;
import java.io.*;

class point implements Comparable<point>{
    int num, cnt;
    public point(int num, int cnt){
        this.num = num;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(point p){
        if(this.cnt == p.cnt){
            return p.num - this.num;
        }
        return p.cnt - this.cnt;
    }
}

public class Main {
    public static HashMap<Integer, Integer> hm = new HashMap<>();
    public static PriorityQueue<point> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            int num = Integer.parseInt(st.nextToken());
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            pq.add(new point(entry.getKey(), entry.getValue()));
        }

        while(k > 0){
            System.out.print(pq.poll().num + " ");
            k--;
        }
    }
}