import java.util.*;
import java.io.*;

class point implements Comparable<point>{
    int num, preidx, postidx;
    public point(int num, int preidx){
        this.num = num;
        this.preidx = preidx;
        this.postidx = -1;
    }
    @Override
    public int compareTo(point p){
        if(this.num == p.num){
            return this.preidx - p.preidx;
        }
        return this.num - p.num;
    }
}

public class Main {
    public static final int MAX_LENGTH = 1000;
    public static int[] arr = new int[MAX_LENGTH + 1];
    public static PriorityQueue<point> pq = new PriorityQueue<>();
    public static ArrayList<point> ansList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            int num = Integer.parseInt(st.nextToken());
            pq.add(new point(num, i));
        }

        int cnt = 1;
        while(!pq.isEmpty()){
            point p = pq.poll();
            p.postidx = cnt++;
            ansList.add(p);
        }

        // for(point p : ansList){
        //     System.out.println(p.num + " " + p.preidx + " " + p.postidx);
        // }

        Collections.sort(ansList, new Comparator<point>(){
            @Override
            public int compare(point p1, point p2){
                return p1.preidx - p2.preidx;
            }
        });

        for(point p : ansList){
            System.out.print(p.postidx + " ");
        }
    }
}