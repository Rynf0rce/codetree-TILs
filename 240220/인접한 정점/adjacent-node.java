import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 10000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] cost = new int[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int[][] DP = new int[MAX_NODE + 1][2];
    public static int[] parents = new int[MAX_NODE + 1];

    public static void BFS(int idx){
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int postIdx = nodeList[idx].get(i);

            if(visited[postIdx]){
                continue;
            }

            visited[postIdx] = true;
            parents[postIdx] = idx;
            BFS(postIdx);
        }

        DP[idx][1] = cost[idx];
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int postIdx = nodeList[idx].get(i);
            if(parents[postIdx] != idx){
                continue;
            }

            DP[idx][1] += DP[postIdx][0];
            DP[idx][0] += Math.max(DP[postIdx][0], DP[postIdx][1]);
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodeList[start].add(end);
            nodeList[end].add(start);
        }

        visited[1] = true;
        BFS(1);
        System.out.print(Math.max(DP[1][0], DP[1][1]));
    }
}