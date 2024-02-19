import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int[] depth = new int[MAX_NODE + 1];
    public static int d = -1;

    public static void DFS(int idx){
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int postIdx = nodeList[idx].get(i);
            if(visited[postIdx]){
                continue;
            }

            visited[postIdx] = true;
            DFS(postIdx);
            depth[idx] = Math.max(depth[idx], depth[postIdx] + 1);
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

        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            if(i == s){
                continue;
            }

            if(depth[i] >= d){
                ans++;
            }
        }

        System.out.print(ans * 2);
    }
}