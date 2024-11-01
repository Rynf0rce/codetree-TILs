import java.util.*;
import java.io.*;

class point implements Comparable<point>{
    int arrive, spending, idx;
    public point(int arrive, int spending, int idx){
        this.arrive = arrive;
        this.spending = spending;
        this.idx = idx;
    }

    @Override
    public int compareTo(point p){
        return this.arrive - p.arrive;
    }
}

public class Main {
    public static PriorityQueue<point> timelineQueue = new PriorityQueue<>();
    public static PriorityQueue<point> waitingQueue = new PriorityQueue<>(new Comparator<point>(){
        @Override
        public int compare(point p1, point p2){
            return p1.idx - p2.idx;
        }
    });
    public static int time = 0;

    public static void simulation(){
        if(timelineQueue.isEmpty()){
            return;
        }

        while(!timelineQueue.isEmpty() && time >= timelineQueue.peek().arrive){
            waitingQueue.add(timelineQueue.poll());
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int arrive = Integer.parseInt(st.nextToken());
            int spending = Integer.parseInt(st.nextToken());
            timelineQueue.add(new point(arrive, spending, i));
        }

        int ans = 0;
        while(!timelineQueue.isEmpty()){
            point p = timelineQueue.poll();

            if(waitingQueue.isEmpty()){
                time = p.arrive + p.spending;
            }

            simulation();

            while(!waitingQueue.isEmpty()){
                point curPoint = waitingQueue.poll();
                ans = Math.max(ans, time - curPoint.arrive);
                time += curPoint.spending;
                simulation();
            }
        }
        System.out.print(ans);
    }
}