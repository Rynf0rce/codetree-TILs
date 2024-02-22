import java.util.*;
import java.io.*;

public class Main {
    public static final int ROOT = 1;
    public static final int MAX_NODE = 100000;
    public static final int MAX_DEPTH = (int)(Math.log(MAX_NODE) / Math.log(2));
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[][] parents = new int[MAX_DEPTH + 1][MAX_NODE + 1];
    public static int[] depth = new int[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
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

    public static int calDistance(int a, int b){
        // Based on LCA, We can find distance between a and b;
        if(a == b){
            return 1;
        }

        int ans = 1; // respectively nodes

        if(depth[b] > depth[a]){
            int temp = b;
            b = a;
            a = temp;
        }

        for(int i = d ; i >= 0 ; i--){
            if(depth[a] - depth[b] >= (1 << i)){
                a = parents[i][a];
                ans += (1 << i);
            }
        }

        if(a == b){
            return ans;
        }

        for(int i = d ; i >= 0 ; i--){
            if(parents[i][a] != parents[i][b]){
                a = parents[i][a];
                b = parents[i][b];
                
                ans += (1 << i) * 2;
            }
        }

        ans += 2;

        return ans;
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
        bfs(ROOT);
        makeParents();

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < q ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(calDistance(a, b) + "\n");
        }
        System.out.print(sb.toString());
    }
}