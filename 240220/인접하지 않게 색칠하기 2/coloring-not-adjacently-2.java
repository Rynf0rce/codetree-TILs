import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static final long INVALIED = (long) 1e10 + 1;
    public static final int MAX_SELECT = 10;

    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];

    public static long[][] DP = new long[MAX_NODE + 1][2];
    public static int[] cost = new int[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int[] parents = new int[MAX_NODE + 1];
    public static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public static int k = -1;

    public static void DFS(int idx){
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int postIdx = nodeList[idx].get(i);
            if(visited[postIdx]){
                continue;
            }
            visited[postIdx] = true;
            parents[postIdx] = idx;
            DFS(postIdx);
        }

        DP[idx][1] = cost[idx]; // 현재 노드, 선택 번째, 선택 여부
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int postIdx = nodeList[idx].get(i);
            if(parents[postIdx] != idx){
                continue;
            }

            DP[idx][1] += DP[postIdx][0];
            DP[idx][0] += Math.max(DP[postIdx][1], DP[postIdx][0]);
        }
    }

    public static void traversal(int idx, boolean selected){
        if(selected){
            pq.add(cost[idx]);
        }

        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int postIdx = nodeList[idx].get(i);

            if(visited[postIdx]){
                continue;
            }

            visited[postIdx] = true;

            if(selected){
                traversal(postIdx, false);
            }
            else{
                traversal(postIdx, DP[postIdx][1] >= DP[postIdx][0]);
            }
        }
    }

    public static void main(String[] args) throws IOException{
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
            nodeList[end].add(start);
        }

        for(int i = 1 ; i <= n ; i++){
            cost[i] = Integer.parseInt(br.readLine());
        }

        k = Integer.parseInt(br.readLine());

        visited[1] = true;
        DFS(1);

        for(int i = 2 ; i <= n ; i++){
            visited[i] = false;
        }
        
        traversal(1, DP[1][1] >= DP[1][0]);

        int ans = 0;
        while(k-- > 0){
            ans += pq.poll();
        }
        System.out.print(ans);
    }
}