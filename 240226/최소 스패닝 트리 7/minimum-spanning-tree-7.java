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
    public static final int MAX_NODE = 40000;
    public static final int MAX_INT = (int)1e9;
    public static final int START_IDX = 1;
    public static ArrayList<node>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static ArrayList<node>[] restoredNodeList = new ArrayList[MAX_NODE + 1];
    public static PriorityQueue<node> pq = new PriorityQueue<>();
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int[] connected = new int[MAX_NODE + 1];
    public static int[] dist = new int[MAX_NODE + 1];
    public static int n = -1;

    public static void dijkstra(int idx){
        pq.clear();
        for(int i = 1 ; i <= n ; i++){
            dist[i] = MAX_NODE;
        }
        dist[idx] = 0;

        pq.add(new node(idx, dist[idx]));
        while(!pq.isEmpty()){
            node curNode = pq.poll();
            if(curNode.weight != dist[curNode.idx]){
                System.out.println("cc");
                continue;
            }

            for(int i = 0 ; i < restoredNodeList[curNode.idx].size() ; i++){
                node postNode = restoredNodeList[curNode.idx].get(i);
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
        n = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
            restoredNodeList[i] = new ArrayList<>();
            dist[i] = MAX_INT + 1;
        }

        int m = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodeList[left].add(new node(right, weight));
            nodeList[right].add(new node(left, weight));
        }

        dist[START_IDX] = 0;
        pq.add(new node(1, dist[1]));
        int totalWeight = 0;
        while(!pq.isEmpty()){
            node curNode = pq.poll();
            if(visited[curNode.idx]){
                continue;
            }

            visited[curNode.idx] = true;
            totalWeight += curNode.weight;

            if(curNode.idx != START_IDX){
                restoredNodeList[curNode.idx].add(new node(connected[curNode.idx], dist[curNode.idx]));
                restoredNodeList[connected[curNode.idx]].add(new node(curNode.idx, dist[curNode.idx]));
            }

            for(int i = 0 ; i < nodeList[curNode.idx].size() ; i++){
                node postNode = nodeList[curNode.idx].get(i);
                if(dist[postNode.idx] > postNode.weight){
                    dist[postNode.idx] = postNode.weight;
                    pq.add(new node(postNode.idx, dist[postNode.idx]));
                    connected[postNode.idx] = curNode.idx;
                }
            }
        }

        System.out.println(totalWeight);

        dijkstra(1);
        int maxIdx = 1;
        for(int i = 1 ; i <= n ; i++){
            if(dist[maxIdx] < dist[i]){
                maxIdx = i;
            }
        }
        
        dijkstra(maxIdx);
        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            ans = Math.max(ans, dist[i]);
        }
        System.out.println(ans);
        
    }
}