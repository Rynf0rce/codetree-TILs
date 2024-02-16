import java.util.*;
import java.io.*;

class node{
    int idx, weight;
    public node(int idx, int weight){
        this.idx = idx;
        this.weight = weight;
    }
}

public class Main {
    public static final int MAX_NODE = 2000;
    public static ArrayList<node>[] nodeList = new ArrayList[MAX_NODE];
    public static int[] dist = new int[MAX_NODE];
    public static int[] parents = new int[MAX_NODE];
    public static boolean[] visited = new boolean[MAX_NODE];
    public static int n = -1;

    public static void initialize(){
        for(int i = 0 ; i < n ; i++){
            dist[i] = 0;
            visited[i] = false;
            parents[i] = 0;
        }
    }

    public static void traversal(int idx){
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            node curNode = nodeList[idx].get(i);
            if(!visited[curNode.idx]){
                visited[curNode.idx] = true;
                parents[curNode.idx] = idx;
                dist[curNode.idx] = dist[idx] + curNode.weight;
                traversal(curNode.idx);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            nodeList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 1 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodeList[start].add(new node(end, weight));
            nodeList[end].add(new node(start, weight));
        }

        visited[0] = true;
        traversal(0);

        int maxIdx = 0;
        for(int i = 0 ; i < n ; i++){
            if(dist[maxIdx] < dist[i]){
                maxIdx = i;
            }
        }

        initialize();
        visited[maxIdx] = true;
        traversal(maxIdx);

        int ans = 0;
        int finalIdx = 0;
        for(int i = 0 ; i < n ; i++){
            if(dist[finalIdx] < dist[i]){
                finalIdx = i;
            }
            ans = Math.max(ans, dist[i]);
        }

        visited[maxIdx] = false;
        while(finalIdx != maxIdx){
            visited[finalIdx] = false;
            finalIdx = parents[finalIdx];
        }

        int addEdge = 0;
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                continue;
            }
            for(int j = 0 ; j < nodeList[i].size() ; j++){
                node curNode = nodeList[i].get(j);
                addEdge = Math.max(addEdge, curNode.weight);
            }
        }
        System.out.print(addEdge + ans);  
    }
}