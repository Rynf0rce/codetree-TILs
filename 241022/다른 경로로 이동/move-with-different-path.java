import java.util.*;
import java.io.*;

class node implements Comparable<node>{
    int idx;
    long weight;

    public node(int idx, long weight){
        this.idx = idx;
        this.weight = weight;
    }

    @Override
    public int compareTo(node n){
        if(this.weight > n.weight){
            return 1;
        }
        else if(this.weight == n.weight){
            return 0;
        }
        else{
            return -1;
        }
    }
}

public class Main {
    public static final int MAX_NODE = 1000;
    public static final long INVALID = (long)1e10 + 1;
    public static ArrayList<node>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static PriorityQueue<node> pq = new PriorityQueue<>();
    public static long[] dist = new long[MAX_NODE + 1];
    public static int[] path = new int[MAX_NODE + 1];
    public static HashSet<Integer> pathSet_A = new HashSet<>();

    public static int n = -1;

    public static void dijkstra(){
        for(int i = 2 ; i <= n ; i++){
            dist[i] = INVALID;
        }

        pq.add(new node(1, dist[1]));
        while(!pq.isEmpty()){
            node curNode = pq.poll();
            if(curNode.weight != dist[curNode.idx]){
                continue;
            }

            for(int i = 0 ; i < nodeList[curNode.idx].size() ; i++){
                node postNode = nodeList[curNode.idx].get(i);
                if(!pathSet_A.contains(postNode.idx) && dist[postNode.idx] > postNode.weight + curNode.weight){
                    dist[postNode.idx] = postNode.weight + curNode.weight;
                    pq.add(new node(postNode.idx, dist[postNode.idx]));
                    path[postNode.idx] = curNode.idx;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<node>();
        }

        int m = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long weight = Long.parseLong(st.nextToken());
            nodeList[start].add(new node(end, weight));
            nodeList[end].add(new node(start, weight));
        }


        // 이 부분을 하지 않아도 코테가 통과 됩니다.
        for(int i = 1 ; i <= n ; i++){
            Collections.sort(nodeList[i], new Comparator<node>(){
                @Override
                public int compare(node n1, node n2){
                    return n1.idx - n2.idx;
                }
            });
        }

        dijkstra();

        int curIdx = n;
        while(curIdx != 1){
            int preIdx = path[curIdx];
            for(int i = 0 ; i < nodeList[preIdx].size() ; i++){
                node preNode = nodeList[preIdx].get(i);
                if(preNode.idx == curIdx && dist[preIdx] == dist[curIdx] - preNode.weight){
                    nodeList[preIdx].remove(preNode);
                    break;
                }
            }

            for(int i = 0 ; i < nodeList[curIdx].size() ; i++){
                node curNode = nodeList[curIdx].get(i);
                if(curNode.idx == preIdx && dist[curIdx] == dist[preIdx] + curNode.weight){
                    nodeList[curIdx].remove(curNode);
                    break;
                }
            }
            curIdx = preIdx;
        }
        

        dijkstra();

        System.out.print(dist[n] == INVALID ? -1 : dist[n]);
        
    }
}