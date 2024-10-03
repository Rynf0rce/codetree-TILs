import java.util.*;
import java.io.*;

class node implements Comparable<node>{
    int idx;
    int weight;

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
    public static final int MAX_NODE = 1000;
    public static final int INVALID = (int) 1e9;
    public static ArrayList<node>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[][] dist = new int[MAX_NODE + 1][MAX_NODE + 1];
    public static PriorityQueue<node> pq = new PriorityQueue<>();

    public static void dijkstra(int startIdx){
        dist[startIdx][startIdx] = 0;
        pq.add(new node(startIdx, dist[startIdx][startIdx]));
        while(!pq.isEmpty()){
            node curNode = pq.poll();
            if(curNode.weight != dist[startIdx][curNode.idx]){
                continue;
            }

            for(int i = 0 ; i < nodeList[curNode.idx].size() ; i++){
                node postNode = nodeList[curNode.idx].get(i);
                if(dist[startIdx][postNode.idx] > curNode.weight + postNode.weight){
                    dist[startIdx][postNode.idx] = curNode.weight + postNode.weight;
                    pq.add(new node(postNode.idx, dist[startIdx][postNode.idx]));
                }
            }
        }
    }

    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<node>();
            for(int j = 1 ; j <= n ; j++){
                dist[i][j] = INVALID;
            }
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodeList[start].add(new node(end, weight));
        }

        for(int i = 1 ; i <= n ; i++){
            dijkstra(i);
        }

        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            ans = Math.max(ans, dist[i][x] + dist[x][i]);
        }

        System.out.print(ans);
    }
}