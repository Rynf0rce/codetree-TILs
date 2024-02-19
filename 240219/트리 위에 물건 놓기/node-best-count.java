import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int[] parents = new int[MAX_NODE + 1];
    public static int[][] DP = new int[MAX_NODE + 1][2];

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

        DP[idx][1] = 1;
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int connectedIdx = nodeList[idx].get(i);
            if(parents[connectedIdx] != idx){
                continue;
            }
            DP[idx][0] += DP[connectedIdx][1];
            DP[idx][1] += DP[connectedIdx][0];
        }
    }

    public static void main(String[] args) throws IOException {
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
        
        visited[1] = true;
        DFS(1);

        System.out.print(Math.min(DP[1][0], DP[1][1]));
    }
}