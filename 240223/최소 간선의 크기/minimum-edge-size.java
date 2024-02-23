import java.util.*;
import java.io.*;

class path implements Comparable<path>{
    int start, end;
    long weight;
    public path(int start, int end, long weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(path p){
        if(this.weight > p.weight){
            return -1;
        }
        else if(this.weight == p.weight){
            return 0;
        }
        else{
            return 1;
        }
    }
}

public class Main {
    public static final int MAX_NODE = 100000;
    public static final int MAX_WEIGTH = (int)1e9;
    public static int[] uf = new int[MAX_NODE + 1];
    public static PriorityQueue<path> pq = new PriorityQueue<>();

    public static int find(int idx){
        if(uf[idx] == idx){
            return idx;
        }
        int rootIdx = find(uf[idx]);
        uf[idx] = rootIdx;
        return rootIdx;
    }

    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        uf[rootA] = rootB;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= n ; i++){
            uf[i] = i;
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new path(start, end, weight));
        }

        while(!pq.isEmpty()){
            path curPath = pq.poll();
            union(curPath.start, curPath.end);
            if(find(a) == find(b)){
                System.out.print(curPath.weight);
                break;
            }
        }
    }
}