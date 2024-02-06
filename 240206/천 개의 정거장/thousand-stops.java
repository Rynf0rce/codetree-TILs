import java.util.*;
import java.io.*;

class vertex implements Comparable<vertex>{
    int idx, weight, bus;

    public vertex(int idx, int weight, int bus){
        this.idx = idx;
        this.weight = weight;
        this.bus = bus;
    }

    @Override
    public int compareTo(vertex v){
        return this.weight - v.weight;
    }
}

public class Main{
    public static final int MAX_VERTEX = 1000;
    public static final int MAX_COST = (int)1e9;
    public static ArrayList<vertex>[] vertexList = new ArrayList[MAX_VERTEX + 1];
    public static PriorityQueue<vertex> pq = new PriorityQueue<>();
    public static int[] pathArr = new int[MAX_VERTEX + 1];
    public static int[] dist = new int[MAX_VERTEX + 1];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= MAX_VERTEX ; i++){
            vertexList[i] = new ArrayList<vertex>();
            dist[i] = MAX_COST;
        }

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int cost = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            int preIdx = -1;
            for(int j = 0 ; j < num ; j++){
                if(preIdx == -1){
                    preIdx = Integer.parseInt(st.nextToken());
                }
                else{
                    int curIdx = Integer.parseInt(st.nextToken());
                    vertexList[preIdx].add(new vertex(curIdx, cost, i));
                    preIdx = curIdx;
                }
            }
        }

        dist[A] = 0;
        pathArr[A] = -1;
        pq.add(new vertex(A, dist[A], -1));
        while(!pq.isEmpty()){
            vertex curVertex = pq.poll();
            if(curVertex.weight != dist[curVertex.idx]){
                continue;
            }

            for(int i = 0 ; i < vertexList[curVertex.idx].size() ; i++){
                vertex postVertex = vertexList[curVertex.idx].get(i);
                if(curVertex.bus == postVertex.bus && dist[postVertex.idx] > curVertex.weight){
                    dist[postVertex.idx] = dist[curVertex.idx];
                    pathArr[postVertex.idx] = curVertex.idx;
                    pq.add(new vertex(postVertex.idx, dist[postVertex.idx], postVertex.bus));
                }
                else if(dist[postVertex.idx] > curVertex.weight + postVertex.weight){
                    dist[postVertex.idx] = curVertex.weight + postVertex.weight;
                    pathArr[postVertex.idx] = curVertex.idx;
                    pq.add(new vertex(postVertex.idx, dist[postVertex.idx], postVertex.bus));
                }
            }

            // for(int i = 1 ; i <= 5 ; i++){
            //     System.out.print(dist[i] + " ");
            // }
            // System.out.println();
            // for(int i = 1 ; i <= 5 ; i++){
            //     System.out.print(pathArr[i] + " ");
            // }
            // System.out.println();
        }
        
        int time = 1;
        int path = B;
        while(pathArr[path] != A){
            path = pathArr[path];
            time++;
        }
        System.out.print(dist[B] + " " + time);

        // for(int i = 1 ; i <= 5 ; i++){
        //     System.out.print(dist[i] + " ");
        // }

        // System.out.println(dist[B]);
    }
}