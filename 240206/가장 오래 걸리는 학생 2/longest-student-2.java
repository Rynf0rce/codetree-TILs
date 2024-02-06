import java.util.*;
import java.io.*;

class vertex implements Comparable<vertex>{
    int idx, weight;
    
    public vertex(int idx, int weight){
        this.idx = idx;
        this.weight = weight;
    }

    @Override
    public int compareTo(vertex v){
        return this.weight - v.weight;
    }
}

public class Main {
    public static final int MAX_VERTEX = 100000;
    public static final int MAX_INT = (int)1e9;
    public static ArrayList<vertex>[] houseList = new ArrayList[MAX_VERTEX + 1];
    public static int[] dist = new int[MAX_VERTEX + 1];
    public static PriorityQueue<vertex> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            houseList[i] = new ArrayList<vertex>();
            dist[i] = MAX_INT;
        }
        
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            houseList[end].add(new vertex(start, weight)); // 각 집에서 학교까지 도달하는 하는 최단 거리 = 학교에서 각 집에 도달하는 최단거리 
        }

        dist[n] = 0;
        pq.add(new vertex(n, dist[n]));

        while(!pq.isEmpty()){
            vertex curVertex = pq.poll();
            if(curVertex.weight != dist[curVertex.idx]){
                continue;
            }

            for(int i = 0 ; i < houseList[curVertex.idx].size() ; i++){
                vertex postVertex = houseList[curVertex.idx].get(i);
                if(dist[postVertex.idx] > curVertex.weight + postVertex.weight){
                    dist[postVertex.idx] = curVertex.weight + postVertex.weight;
                    pq.add(new vertex(postVertex.idx, dist[postVertex.idx]));
                }
            }
        }

        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            ans = Math.max(ans, dist[i]);
        }

        System.out.print(ans);
    }
}