import java.util.*;
import java.io.*;

class vertex implements Comparable<vertex>{
    int idx;
    int weight;

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
    public static final int MAX_VERTEX = 20000;
    public static final int MAX_WEIGHT = Integer.MAX_VALUE;
    public static ArrayList<vertex>[] vertexList = new ArrayList[MAX_VERTEX + 1];
    public static boolean[] visited = new boolean[MAX_VERTEX + 1];
    public static int[] dist = new int[MAX_VERTEX + 1];
    public static PriorityQueue<vertex> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= n ; i++){
            vertexList[i] = new ArrayList<vertex>();
            dist[i] = MAX_WEIGHT;
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            vertexList[start].add(new vertex(end, weight));
            vertexList[end].add(new vertex(start, weight));
        }

        dist[k] = 0;
        pq.add(new vertex(k, dist[k]));

        while(!pq.isEmpty()){
            vertex curVertex = pq.poll();
            if(curVertex.weight != dist[curVertex.idx] || visited[curVertex.idx]){
                continue;
            }
            
            visited[curVertex.idx] = true;

            for(int i = 0 ; i < vertexList[curVertex.idx].size() ; i++){
                vertex postVertex = vertexList[curVertex.idx].get(i);
                dist[postVertex.idx] = Math.min(dist[postVertex.idx], curVertex.weight + postVertex.weight);
                pq.add(new vertex(postVertex.idx, dist[postVertex.idx]));
            }
        }

        for(int i = 1 ; i <= n ; i++){
            System.out.println(dist[i] == MAX_WEIGHT ? -1 : dist[i]);
        }   
    }
}