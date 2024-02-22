import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static final int MAX_DEPTH = (int)(Math.log(MAX_NODE) / Math.log(2));
    public static final int ROOT = 1;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] depth = new int[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int[][] parents = new int[MAX_DEPTH + 1][MAX_NODE + 1];
    public static int n = -1;
    public static int d = -1;
    
    public static void bfs(int idx){
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int postIdx = nodeList[idx].get(i);
            if(visited[postIdx]){
                continue;
            }

            visited[postIdx] = true;
            parents[0][postIdx] = idx;
            depth[postIdx] = depth[idx] + 1;
            bfs(postIdx);
        }
    }

    public static void makeParents(){
        for(int i = 1 ; i <= d ; i++){
            for(int j = 1 ; j <= n ; j++){
                parents[i][j] = parents[i - 1][parents[i - 1][j]];
            }
        }
    }

    public static int lca(int a, int b){
        if(depth[a] < depth[b]){
            return lca(b, a);
        }

        for(int i = d ; i >= 0 ; i--){
            if(depth[a] - depth[b] >= (1 << i)){
                a = parents[i][a];
            }
        }

        if(a == b){
            return a;
        }

        for(int i = d ; i >= 0 ; i--){
            if(parents[i][a] != parents[i][b]){
                a = parents[i][a];
                b = parents[i][b];
            }
        }

        return parents[0][a];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        d = (int)(Math.log(n) / Math.log(2));
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
        }
        for(int i = 1 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodeList[start].add(end);
            nodeList[end].add(start);
        }

        visited[ROOT] = true;
        depth[ROOT] = 1;
        bfs(ROOT);

        makeParents();

        // for(int i = 0 ; i <= d ; i++){
        //     for(int j = 1 ; j <= n ; j++){
        //         System.out.print(parents[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        int q = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < q ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(lca(a, b));
        }
    }
}