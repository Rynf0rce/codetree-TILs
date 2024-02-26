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

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof node)) return false;
        node o = (node) obj;
        return o.idx == this.idx && o.weight == this.weight;
    }
}

public class Main {
    public static final int MAX_NODE = 200000;
    public static final int MAX_INT = (int)1e9 + 1;
    public static ArrayList<node>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static PriorityQueue<node> pq = new PriorityQueue<>();
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int[] dist = new int[MAX_NODE + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
            dist[i] = MAX_INT;
        }

        for(int i = 1 ; i <= n ; i++){
            if(i != n){
                nodeList[i].add(new node(i + 1, 0));
                nodeList[i + 1].add(new node(i, 0));
            }
            else{
                nodeList[i].add(new node(1, 0));
                nodeList[1].add(new node(i, 0));
            }
            
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            int weight = Integer.parseInt(st.nextToken());
            nodeList[i].add(new node(0, weight));
            nodeList[0].add(new node(i, weight));
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            nodeList[left].remove(new node(right, 0));
            nodeList[right].remove(new node(left, 0));
        }

        long ans = 0;
        dist[1] = 0;
        pq.add(new node(1, 0));
        while(!pq.isEmpty()){
            node curNode = pq.poll();
            if(visited[curNode.idx] || dist[curNode.idx] != curNode.weight){
                continue;
            }

            visited[curNode.idx] = true;
            ans += dist[curNode.idx];

            for(int i = 0 ; i < nodeList[curNode.idx].size() ; i++){
                node postNode = nodeList[curNode.idx].get(i);
                dist[postNode.idx] = Math.min(dist[postNode.idx], postNode.weight);
                pq.add(new node(postNode.idx, dist[postNode.idx]));
            }
        }
        System.out.println(ans <= k ? 1 : 0);   
    }
}