import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static final int MAX_SELECT = 10;

    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];

    public static int[][][] DP = new int[MAX_NODE + 1][MAX_SELECT][2];
    public static int[] cost = new int[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int[] parents = new int[MAX_NODE + 1];
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

        DP[idx][1][1] = cost[idx]; // 현재 노드, 선택 번째, 선택 여부
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int postIdx = nodeList[idx].get(i);
            if(parents[postIdx] != idx){
                continue;
            }

            for(int j = k ; j >= 1 ; j--){
                for(int h = 1 ; h <= j ; h++){
                    DP[idx][j][1] = Math.max(DP[idx][j][1], DP[idx][j - h][1] + DP[postIdx][h][0]);
                    DP[idx][j][0] = Math.max(DP[idx][j][0], DP[idx][j - h][0] + Math.max(DP[postIdx][h][0], DP[postIdx][h][1]));
                }
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

        int ans = Math.max(DP[1][k][1], DP[1][k][0]);
        System.out.print(ans);

    }
}