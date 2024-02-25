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
    public static final int INVALID = (int) 1e9;
    public static ArrayList<node>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] dist = new int[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static PriorityQueue<node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<node>();
            dist[i] = INVALID;
        }

        int m = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            nodeList[a].add(new node(b, w));
            nodeList[b].add(new node(a, w));
        }

        dist[1] = 0;
        int ans = 0;
        pq.add(new node(1, 0));
        while(!pq.isEmpty()){
            node curNode = pq.poll();
            if(visited[curNode.idx]){
                continue;
            }
            visited[curNode.idx] = true;
            ans += curNode.weight;
            for(int i = 0 ; i < nodeList[curNode.idx].size() ; i++){
                node postNode = nodeList[curNode.idx].get(i);
                dist[postNode.idx] = Math.min(dist[postNode.idx], postNode.weight);
                pq.add(new node(postNode.idx, dist[postNode.idx]));
            }
        }
        System.out.print(ans);
    }
}