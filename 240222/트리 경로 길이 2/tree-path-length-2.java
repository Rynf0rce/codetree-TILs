import java.util.*;
import java.io.*;

class path{
    int idx, weight;
    public path(int idx, int weight){
        this.idx = idx;
        this.weight = weight;
    }
}

public class Main {
    public static final int ROOT = 1;
    public static final int MAX_NODE = 100000;
    public static final int MAX_DEPTH = (int)(Math.log(MAX_NODE) / Math.log(2));
    public static ArrayList<path>[] pathList = new ArrayList[MAX_NODE + 1];
    public static int[][] parents = new int[MAX_DEPTH + 1][MAX_NODE + 1];
    public static int[] dist = new int[MAX_NODE + 1];
    public static int[] depth = new int[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int n = -1;
    public static int d = -1;

    public static void dfs(int idx){
        for(int i = 0 ; i < pathList[idx].size() ; i++){
            path postPath = pathList[idx].get(i);
            if(visited[postPath.idx]){
                continue;
            }

            visited[postPath.idx] = true;
            depth[postPath.idx] = depth[idx] + 1;
            dist[postPath.idx] = dist[idx] + postPath.weight;
            parents[0][postPath.idx] = idx;
            dfs(postPath.idx);
        }
    }

    public static void makeParents(){
        for(int i = 1 ; i <= d ; i++){
            for(int j = 1 ; j <= n ; j++){
                parents[i][j] = parents[i - 1][parents[i - 1][j]];
            }
        }
    }

    public static int calDist(int a, int b){
        if(depth[b] > depth[a]){
            int temp = b;
            b = a;
            a = temp;
        }

        int postA = a;
        int postB = b;

        for(int i = d ; i >= 0 ; i--){
            if(depth[a] - depth[b] >= (1 << i)){
                a = parents[i][a];
            }
        }

        if(a == b){
            return dist[postA] + dist[postB] - 2 * dist[a];
        }

        for(int i = d ; i >= 0 ; i--){
            if(parents[i][a] != parents[i][b]){
                a = parents[i][a];
                b = parents[i][b];
            }
        }

        return dist[postA] + dist[postB] - 2 * dist[parents[0][a]];
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        d = (int)(Math.log(n) / Math.log(2));

        for(int i = 1 ; i <= n ; i++){
            pathList[i] = new ArrayList<path>();
        }

        for(int i = 1 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pathList[start].add(new path(end, weight));
            pathList[end].add(new path(start, weight));
        }

        visited[ROOT] = true;
        depth[ROOT] = 1;
        dfs(ROOT);

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < q ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(calDist(a, b) + "\n");
        }

        System.out.print(sb.toString());
    }
}