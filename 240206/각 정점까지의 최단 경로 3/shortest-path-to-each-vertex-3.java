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
        if(this.weight == v.weight){
            return this.idx - v.idx;
        }
        else{
            return this.weight - v.weight;
        }
    }
}

public class Main {
    public static final int MAX_VERTEX = 100;
    public static final int MAX_VAL = Integer.MAX_VALUE;
    public static int[] dist = new int[MAX_VERTEX + 1];
    public static boolean[] visited = new boolean[MAX_VERTEX + 1];
    public static ArrayList<vertex>[] vertexList = new ArrayList[MAX_VERTEX + 1];
    public static PriorityQueue<vertex> vertexQueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            vertexList[i] = new ArrayList<vertex>();
            dist[i] = MAX_VAL;
        }

        for(int i = 1 ; i <= m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int startIdx = Integer.parseInt(st.nextToken());
            int endIdx = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            vertexList[startIdx].add(new vertex(endIdx, weight));
        }

        dist[1] = 0;

        for(int i = 1 ; i <= n ; i++){
            int curVal = MAX_VAL;
            int curIdx = -1;

            for(int j = 1 ; j <= n ; j++){
                if(!visited[j] && curVal > dist[j]){
                    curVal = dist[j];
                    curIdx = j;
                }
            }

            if(curIdx == -1){
                break;
            }

            visited[curIdx] = true;
            for(int j = 0 ; j < vertexList[curIdx].size() ; j++){
                vertex postVertex = vertexList[curIdx].get(j);
                dist[postVertex.idx] = Math.min(dist[postVertex.idx], dist[curIdx] + postVertex.weight);
            }
        }

        for(int i = 2 ; i <= n ; i++){
            System.out.println(dist[i] == MAX_VAL ? -1 : dist[i]);
        }
    }
}