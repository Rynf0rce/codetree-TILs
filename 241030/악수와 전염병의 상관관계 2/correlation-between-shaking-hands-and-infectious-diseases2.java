import java.util.*;
import java.io.*;

class event implements Comparable<event>{
    int left, right, time;
    public event(int left, int right, int time){
        this.left = left;
        this.right = right;
        this.time = time;
    }

    @Override
    public int compareTo(event e){
        return this.time - e.time;
    }
}

public class Main {
    public static final int MAX_DEV = 100;
    public static boolean[] infected = new boolean[MAX_DEV + 1];
    public static int[] chance = new int[MAX_DEV + 1];
    public static PriorityQueue<event> pq = new PriorityQueue<>();
    public static int K = 0;

    public static void infect(int odd, int even){
        if(chance[odd] > 0){
            if(!infected[even]){
                chance[even] = K;
            }
            infected[even] = true;
            chance[odd]--;
        }

        if(chance[even] > 0){
            if(!infected[odd]){
                chance[odd] = K;
            }
            infected[odd] = true;
            chance[even]--;
        }     
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // num of dev
        K = Integer.parseInt(st.nextToken()); // chance
        int P = Integer.parseInt(st.nextToken()); // infected
        int T = Integer.parseInt(st.nextToken()); // event

        infected[P] = true;
        chance[P] = K;

        for(int i = 0 ; i < T ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            event e = new event(x, y, t);
            pq.add(e);
        }

        while(!pq.isEmpty()){
            event e = pq.poll();
            // for(int j = 1 ; j <= N ; j++){
            //     System.out.print(chance[j] + " ");
            // }
            // System.out.println();
            infect(e.left, e.right);
            // for(int j = 1 ; j <= N ; j++){
            //     System.out.print(chance[j] + " ");
            // }
            // System.out.println();
            // System.out.println();
        }

        for(int i = 1 ; i <= N ; i++){ 
            System.out.print(infected[i] ? 1 : 0);
        }
    }
}