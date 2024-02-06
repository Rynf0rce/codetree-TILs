import java.util.*;
import java.io.*;

class vertex implements Comparable<vertex>{
    int idx;
    int bus;
    long weight;
    HashSet<Integer> hs;

    public vertex(int idx, int bus, long weight){
        this.idx = idx;
        this.bus = bus;
        this.weight = weight;
        this.hs = new HashSet<>();
    }

    
    @Override
    public int compareTo(vertex v){
        if(this.weight > v.weight){
            return 1;
        }
        else if(this.weight == v.weight){
            return 0;
        }
        else{
            return -1;
        }
    }

}

public class Main {
    public static final int MAX_VERTEX = 1000;
    public static final long MAX_VALUE = (long)1e13;
    public static ArrayList<vertex>[] vertexList = new ArrayList[MAX_VERTEX + 1];
    public static long[] costArr = new long[MAX_VERTEX + 1];
    public static boolean[] visited = new boolean[MAX_VERTEX + 1];
    public static int[] cntArr = new int[MAX_VERTEX + 1];
    public static PriorityQueue<vertex> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= MAX_VERTEX ; i++){
            vertexList[i] = new ArrayList<vertex>();
            costArr[i] = MAX_VALUE;
        }

        for(int i = 1 ; i <= N ; i++){
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
                    vertexList[preIdx].add(new vertex(curIdx, 1, cost));
                    preIdx = curIdx;
                }
            }
        }

        //costArr[A] = 0;
        // pq.add(new vertex(A, 0, 0)); // idx, bus, weight;
        vertex temp = new vertex(A, 0, 0);
        pq.add(temp);
        while(!pq.isEmpty()){
            vertex curVertex = pq.poll();

            if(curVertex.hs.contains(curVertex.idx)){
                continue;
            }

            if(costArr[curVertex.idx] > curVertex.weight){
                costArr[curVertex.idx] = curVertex.weight;
                cntArr[curVertex.idx] = curVertex.hs.size();
            }

            for(int i = 0 ; i < vertexList[curVertex.idx].size() ; i++){
                vertex postVertex = vertexList[curVertex.idx].get(i);
                vertex inVertex = new vertex(postVertex.idx, postVertex.bus, curVertex.weight);
                inVertex.hs = curVertex.hs;
                inVertex.hs.add(curVertex.idx);
                if(curVertex.bus != postVertex.bus){
                    inVertex.weight += postVertex.weight;
                }
                pq.add(inVertex);
            }
        }

        // for(int i = 1 ; i <= 5 ; i++){
        //     System.out.print(costArr[i] + " ");
        // }

        System.out.print(costArr[B] + " " + cntArr[B]);


    }
}