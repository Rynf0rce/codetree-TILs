import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 10000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] inNodeSum = new int[MAX_NODE + 1];
    public static int[] parent = new int[MAX_NODE + 1];
    public static int[] depth = new int[MAX_NODE + 1];

    public static void bfs(int idx){
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int postIdx = nodeList[idx].get(i);
            parent[postIdx] = idx;
            depth[postIdx] = depth[idx] + 1;
            bfs(postIdx);
        }
    }

    public static int lca(int a, int b){
        while(depth[a] != depth[b]){
            if(depth[a] < depth[b]){
                b = parent[b];
            }
            else{
                a = parent[a];
            }
        }

        while(a != b){
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
        }
        for(int i = 1 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodeList[start].add(end);
            inNodeSum[end]++;
        }

        int root = -1;
        for(int i = 1 ; i <= n ; i++){
            if(inNodeSum[i] == 0){
                root = i;
                break;
            }
        }

        bfs(root);
        
        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        System.out.print(lca(a, b));
    }
}