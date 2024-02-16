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
    public static final int MAX_NODE = 50000;
    public static ArrayList<node>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] dist = new int[MAX_NODE + 1];
    public static int[] depth = new int[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int n = -1;

    public static void initialize(){
        for(int i = 1 ; i <= n ; i++){
            dist[i] = 0;
            depth[i] = 0;
            visited[i] = false;
        }
    }

    public static void treversal(int idx){
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            node curNode = nodeList[idx].get(i);
            if(!visited[curNode.idx]){
                visited[curNode.idx] = true;
                depth[curNode.idx] = depth[idx] + 1;
                dist[curNode.idx] = curNode.weight + dist[idx];
                treversal(curNode.idx);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<node>();
        }

        for(int i = 1 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodeList[start].add(new node(end, weight));
            nodeList[end].add(new node(start, weight));
        }

        visited[1] = true;
        treversal(1);

        int maxIdx = 0;
        for(int i = 1 ; i <= n ; i++){
            if(depth[maxIdx] < depth[i]){
                maxIdx = i;
            }
            else if(depth[maxIdx] == depth[i] && dist[maxIdx] > dist[i]){
                maxIdx = i;
            }
        }

        initialize();
        visited[maxIdx] = true;
        treversal(maxIdx);

        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            if(depth[ans] < depth[i]){
                ans = i;
            }
            else if(depth[ans] == depth[i] && dist[ans] > dist[i]){
                ans = i;
            }
        }

        ans = dist[ans];

        if(ans % d == 0){
            ans /= d;
        }
        else{
            ans /= d;
            ans++;
        }

        System.out.print(ans);

    }
}