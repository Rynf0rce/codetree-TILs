import java.util.*;
import java.io.*;

class node implements Comparable<node>{
    int idx, weight;

    public node(int idx, int weight){
        this.idx = idx;
        this.weight = weight;
    }

    @Override
    public int compareTo(node n){
        return this.weight - n.weight;
    }
}

public class Main {
    public static final int MAX_NODE = 100000;
    public static final int INVAILD = (int)1e9;
    public static int[] dist = new int[MAX_NODE + 1];
    public static ArrayList<node>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static PriorityQueue<node> pq = new PriorityQueue<>();
    public static int N = -1;

    public static void dijkstra(){
        dist[N] = 0;
        pq.add(new node(N, dist[N]));
        while(!pq.isEmpty()){
            node curNode = pq.poll();
            
            if(curNode.weight != dist[curNode.idx]){
                continue;
            }

            for(int i = 0 ; i < nodeList[curNode.idx].size() ; i++){
                node postNode = nodeList[curNode.idx].get(i);
                if(dist[postNode.idx] > postNode.weight + curNode.weight){
                    dist[postNode.idx] = postNode.weight + curNode.weight;
                    pq.add(new node(postNode.idx, dist[postNode.idx]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        for(int i = 1 ; i <= N ; i++){
            nodeList[i] = new ArrayList<node>();
            dist[i] = INVAILD;
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodeList[start].add(new node(end, weight));
            nodeList[end].add(new node(start, weight));
        }

        dijkstra();

        int ans = 0;
        for(int i = 1 ; i < N ; i++){
            ans = Math.max(ans, dist[i]);
        }

        System.out.print(ans);
    }
}