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
    public static final int MAX_VERTEX = 1000;
    public static final int MAX_INT = (int)1e9;
    public static int[] dist = new int[MAX_VERTEX + 1];
    public static int[] pathArr = new int[MAX_VERTEX + 1];
    public static ArrayList<vertex>[] vertexList = new ArrayList[MAX_VERTEX + 1];
    public static PriorityQueue<vertex> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= n ; i++){
            vertexList[i] = new ArrayList<vertex>();
            dist[i] = MAX_INT;
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            vertexList[start].add(new vertex(end, weight));
            vertexList[end].add(new vertex(start, weight));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        dist[A] = 0;
        pq.add(new vertex(A, dist[A]));
        while(!pq.isEmpty()){
            vertex curVertex = pq.poll();
            if(curVertex.weight != dist[curVertex.idx]){
                continue;
            }

            for(int i = 0 ; i < vertexList[curVertex.idx].size() ; i++){
                vertex postVertex = vertexList[curVertex.idx].get(i);
                if(dist[postVertex.idx] > curVertex.weight + postVertex.weight){
                    dist[postVertex.idx] = curVertex.weight + postVertex.weight;
                    pathArr[postVertex.idx] = curVertex.idx;
                    pq.add(new vertex(postVertex.idx, dist[postVertex.idx]));
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int path = B;
        ans.add(path);

        while(pathArr[path] != 0){
            path = pathArr[path];
            ans.add(path);
        }

        System.out.println(dist[B]);
        for(int i = ans.size() - 1 ; i >= 0 ; i--){
            System.out.print(ans.get(i) + " ");
        }
    }
}