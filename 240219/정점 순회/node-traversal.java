import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int[] parents = new int[MAX_NODE + 1];
    public static int[] depth = new int[MAX_NODE + 1];
    public static int[] maxDepth = new int[MAX_NODE + 1];
    public static int d = -1;
    public static int ans = 0;

    public static void DFS(int idx){
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int postIdx = nodeList[idx].get(i);
            if(visited[postIdx]){
                continue;
            }

            visited[postIdx] = true;
            parents[postIdx] = idx;
            depth[postIdx] += depth[idx] + 1;
            DFS(postIdx);
        }

        maxDepth[idx] = depth[idx];
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int postIdx = nodeList[idx].get(i);
            if(parents[postIdx] != idx){
                continue;
            }
            maxDepth[idx] = Math.max(maxDepth[idx], maxDepth[postIdx]);
        }
    }

    public static void traversal(int idx){
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int postIdx = nodeList[idx].get(i);
            if(visited[postIdx] || maxDepth[postIdx] - depth[idx] <= d){
                continue;
            }

            ans += 2;
            visited[postIdx] = true;
            traversal(postIdx);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

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

        visited[s] = true;
        DFS(s);

        // for(int i = 1 ; i <= n ; i++){
        //     System.out.print(depth[i] + " ");
        // }

        // System.out.println();
        
        // for(int i = 1 ; i <= n ; i++){
        //     System.out.print(maxDepth[i] + " ");
        // }

        // System.out.println();

        for(int i = 1 ; i <= n ; i++){
            visited[i] = false;
        }
        visited[s] = true;
        traversal(s);

        System.out.print(ans);
    }
}