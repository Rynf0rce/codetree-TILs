import java.util.*;
import java.io.*;

class info implements Comparable<info>{
    int x, y, dist, idx;
    public info(int x, int y, int idx){
        this.x = x;
        this.y = y;
        this.idx = idx;
        this.dist = Math.abs(x) + Math.abs(y);
    }

    @Override
    public int compareTo(info i){
        return this.dist - i.dist;
    }

    public void print(){
        System.out.println(idx);
    }
}

public class Main {
    public static PriorityQueue<info> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new info(a, b, i));
        }

        while(!pq.isEmpty()){
            pq.poll().print();
        }
    }
}