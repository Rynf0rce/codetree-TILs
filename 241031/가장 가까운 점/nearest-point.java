import java.util.*;
import java.io.*;

class point implements Comparable<point>{
    int x, y, dist;
    public point(int x, int y){
        this.x = x;
        this.y = y;
        this.dist = Math.abs(x) + Math.abs(y);
    }

    @Override
    public int compareTo(point p){
        if(this.dist == p.dist){
            if(this.x == p.x){
                return this.y - p.y;
            }
            return this.x - p.x;
        }
        return this.dist - p.dist;
    }
}

public class Main {
    public static PriorityQueue<point> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new point(x, y));
        }

        while(m > 0){
            point p = pq.poll();
            pq.add(new point(p.x + 2, p.y + 2));
            m--;
        }

        System.out.print(pq.peek().x + " " + pq.peek().y);
    }
}