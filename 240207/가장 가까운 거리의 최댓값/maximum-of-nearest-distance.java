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
    public static final int MAX_VERTEX = 100000;
    public static final int MAX_VAL = (int) 1e9;
    public static final int TARGET_VERTEX = 3;
    public static int[] targetArr = new int[TARGET_VERTEX + 1];
    public static ArrayList<vertex>[] vertexList = new ArrayList[MAX_VERTEX + 1];
    public static PriorityQueue<vertex> pq = new PriorityQueue<>();
    public static int[][] dist = new int[TARGET_VERTEX + 1][MAX_VERTEX + 1];

    public static void dijkstra(int start, int idx){
        pq.clear();
        dist[idx][start] = 0;
        pq.add(new vertex(start, dist[idx][start]));
        
        while(!pq.isEmpty()){
            vertex curVertex = pq.poll();

            if(curVertex.weight != dist[idx][curVertex.idx]){
                continue;
            }

            for(int i = 0 ; i < vertexList[curVertex.idx].size() ; i++){
                vertex postVertex = vertexList[curVertex.idx].get(i);
                if(dist[idx][postVertex.idx] > postVertex.weight + curVertex.weight){
                    dist[idx][postVertex.idx] = postVertex.weight + curVertex.weight;
                    pq.add(new vertex(postVertex.idx, postVertex.weight + curVertex.weight));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= n ; i++){
            vertexList[i] = new ArrayList<vertex>();
        }


        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= TARGET_VERTEX ; i++){
            targetArr[i] = Integer.parseInt(st.nextToken());
            for(int j = 1 ; j <= n ; j++){
                dist[i][j] = MAX_VAL;
            }
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            vertexList[start].add(new vertex(end, weight));
            vertexList[end].add(new vertex(start, weight));
        }

        for(int i = 1 ; i <= TARGET_VERTEX ; i++){
            dijkstra(targetArr[i], i);
        }

        int maxOfMin = 0;
        for(int j = 1 ; j <= n ; j++){
            int min = 10000;
            for(int i = 1 ; i <= TARGET_VERTEX ; i++){
                min = Math.min(min, dist[i][j]);
            }
            maxOfMin = Math.max(maxOfMin, min);
        }

        System.out.print(maxOfMin);

        // for(int i = 1 ; i <= TARGET_VERTEX ; i++){
        //     for(int j = 1 ; j <= n ; j++){
        //         System.out.print(dist[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        
    }
}