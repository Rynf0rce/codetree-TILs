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
    public static final int MAX_INT = (int) 1e9 + 1;
    public static ArrayList<node>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] dist = new int[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static PriorityQueue<node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= n ; i++){
            dist[i] = MAX_INT;
            nodeList[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodeList[left].add(new node(right, weight));
            nodeList[right].add(new node(left, weight));
        }

        dist[1] = 0;
        int ans = 0;
        int cnt = 0;
        pq.add(new node(1, dist[1]));
        while(!pq.isEmpty()){
            node curNode = pq.poll();

            if(visited[curNode.idx]){
                continue;
            }

            visited[curNode.idx] = true;
            if(curNode.idx != 1){
                ans += curNode.weight + k * cnt++;
            }
            
            for(int i = 0 ; i < nodeList[curNode.idx].size() ; i++){
                node postNode = nodeList[curNode.idx].get(i);
                if(dist[postNode.idx] > postNode.weight ){
                    dist[postNode.idx] = postNode.weight;
                    pq.add(new node(postNode.idx, dist[postNode.idx]));
                }
            }
        }
        System.out.print(ans);
    }
}