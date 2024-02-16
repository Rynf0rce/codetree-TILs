import java.util.*;
import java.io.*;

class node{
    int idx;
    int weight;
    
    public node(int idx, int weight){
        this.idx = idx;
        this.weight = weight;
    }
}

public class Main {
    public static final int MAX_NODE = 1000;
    public static ArrayList<node>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int[] dist = new int[MAX_NODE + 1];

    public static void traversal(int idx, int target){
        for(int i = 0 ; i < nodeList[idx].size(); i++){
            node curNode = nodeList[idx].get(i);
            if(!visited[curNode.idx]){
                visited[curNode.idx] = true;
                dist[curNode.idx] = curNode.weight + dist[idx];
                if(curNode.idx == target){
                    return;
                }
                else{
                    traversal(curNode.idx, target);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<node>();
        }

        int m = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodeList[start].add(new node(end, weight));
            nodeList[end].add(new node(start, weight));
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for(int j = 1 ; j <= n ; j++){
                visited[j] = false;
                dist[j] = 0;
            }
            visited[start] = true;
            traversal(start, end);
            System.out.println(dist[end]);
        }
    }
}