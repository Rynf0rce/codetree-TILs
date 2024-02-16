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
    public static final int MAX_NODE = 100000;
    public static ArrayList<node>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static long[] dist = new long[MAX_NODE + 1];
    public static int n = -1;

    public static void initialize(){
        for(int i = 1 ; i <= n ; i++){
            visited[i] = false;
            dist[i] = 0;
        }
    }

    public static void traversal(int idx){
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            node curNode = nodeList[idx].get(i);
            if(!visited[curNode.idx]){
                visited[curNode.idx] = true;
                dist[curNode.idx] = dist[idx] + curNode.weight;
                traversal(curNode.idx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
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

        visited[1] = true;
        traversal(1);

        int maxIdx = 0;
        for(int i = 1 ; i <= n ; i++){
            if(dist[maxIdx] < dist[i]){
                maxIdx = i;
            }
        }

        initialize();

        visited[maxIdx] = true;
        traversal(maxIdx);

        long[] ans = new long[2];
        for(int i = 1 ; i <= n ; i++){
            if(ans[1] <= dist[i]){
                ans[0] = ans[1];
                ans[1] = dist[i];
            }
            else if(ans[0] < dist[i]){
                ans[0] = dist[i];
            }
        }
        System.out.print(ans[0]);
    }
}