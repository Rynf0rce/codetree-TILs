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
            return this.time - b.time;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        PriorityQueue<bomb> pq = new PriorityQueue<>();
        
        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine() , " ");
            int point = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            pq.add(new bomb(point, time));
        }

        int ans = 0;
        while(!pq.isEmpty()){
            bomb highPointBomb = pq.poll();
            while(!pq.isEmpty() && pq.peek().time == highPointBomb.time){
                pq.poll();
            }
            // System.out.println(highPointBomb.point + " " + highPointBomb.time);
            ans += highPointBomb.point;
        }

        bw.write(ans + "");

        br.close();
        bw.close();

    }
}