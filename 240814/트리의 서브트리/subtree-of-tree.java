import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int[] parents = new int[MAX_NODE + 1];
    public static int[] DP = new int[MAX_NODE + 1];

    public static void DFS(int idx){
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int curIdx = nodeList[idx].get(i);
            if(visited[curIdx]){
                continue;
            }
            visited[curIdx] = true;
            parents[curIdx] = idx;
            DFS(curIdx);
        }

        DP[idx] = 1;
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int curIdx = nodeList[idx].get(i);
            if(parents[curIdx] != idx){
                continue;
            }

            DP[idx] += DP[curIdx];
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
        }

        for(int i = 1 ; i < n ; i++){
            st = new StringTokenizer(br.readLine() , " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodeList[start].add(end);
            nodeList[end].add(start);
        }

        visited[r] = true;
        DFS(r);

        for(int i = 0 ; i < q ; i++){
            int question = Integer.parseInt(br.readLine());
            System.out.println(DP[question]);
        }
    }
}