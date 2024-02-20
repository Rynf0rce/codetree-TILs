import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 30000;
    public static final int MIN_INT = -1000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] cost = new int[MAX_NODE + 1];
    public static int[] parent = new int[MAX_NODE + 1];
    public static int[][] DP = new int[MAX_NODE + 1][2]; // 0 자기 값이 root, 1 위로 올려주는 값
    public static boolean[] visited = new boolean[MAX_NODE + 1];

    public static void BFS(int idx){
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int postIdx = nodeList[idx].get(i);
            if(visited[postIdx]){
                continue;
            }
            visited[postIdx] = true;
            parent[postIdx] = idx;
            BFS(postIdx);
        }

        DP[idx][0] = cost[idx];
        DP[idx][1] = cost[idx];
        
        int maxVal = 0;
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int postIdx = nodeList[idx].get(i);
            if(parent[postIdx] != idx || DP[postIdx][1] < 0){
                continue;
            }
            maxVal = Math.max(maxVal, DP[postIdx][1]);
            DP[idx][0] += DP[postIdx][1];
        }
        DP[idx][1] += maxVal;
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
        BFS(1);

        int ans = MAX_NODE * MIN_INT;
        for(int i = 1 ; i <= n ; i++){
            ans = Math.max(ans, DP[i][0]);
        }
        System.out.print(ans);

    }
}