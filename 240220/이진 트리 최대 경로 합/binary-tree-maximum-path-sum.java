import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 30000;
    public static final int MIN_INT = -1000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] cost = new int[MAX_NODE + 1];
    public static int[] dist = new int[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];

    public static void BFS(int idx){
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int postIdx = nodeList[idx].get(i);
            if(visited[postIdx]){
                continue;
            }
            visited[postIdx] = true;
            dist[postIdx] += cost[postIdx] + dist[idx];
            BFS(postIdx);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i = 1 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodeList[start].add(end);
            nodeList[end].add(start);
        }
        for(int i = 1 ; i <= n ; i++){
            cost[i] = Integer.parseInt(br.readLine());
        }

        visited[1] = true;
        dist[1] = cost[1];
        BFS(1);

        int maxIdx = 1;
        for(int i = 1 ; i <= n ; i++){
            if(dist[maxIdx] < dist[i]){
                maxIdx = i;
            }
        }

        for(int i = 1 ; i <= n ; i++){
            visited[i] = false;
            dist[i] = 0;
        }
        visited[maxIdx] = true;
        dist[maxIdx] = cost[maxIdx];
        BFS(maxIdx);

        int ans = MAX_NODE * MIN_INT;
        for(int i = 1 ; i <= n ; i++){
            ans = Math.max(ans, dist[i]);
        }
        System.out.print(ans);
    }
}