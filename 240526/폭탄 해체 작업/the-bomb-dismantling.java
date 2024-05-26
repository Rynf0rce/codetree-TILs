import java.util.*;
import java.io.*;

class bomb implements Comparable<bomb>{
    int point;
    int time;

    public bomb(int point, int time){
        this.point = point;
        this.time = time;
    }

    @Override
    public int compareTo(bomb b){
        if(this.time == b.time){
            return b.point - this.point;
        }
        else{
            return b.time - this.time;
        }
    }
}

public class Main {
    public static PriorityQueue<bomb> bombQueue = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int maxTime = 0;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine() , " ");
            int point = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            bombQueue.add(new bomb(point, time));
        }
        
        int time = bombQueue.peek().time;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0;

        for(int i = time ; i >= 1 ; i--){
            while(!bombQueue.isEmpty() && bombQueue.peek().time == i){
                pq.add(bombQueue.poll().point);
                // System.out.println("time : " + i);
            }
            
            if(!pq.isEmpty()){
                ans += pq.poll();
            }
        }

        bw.write(ans + "");

        br.close();
        bw.close();

    }
}