import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 10000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int[] parents = new int[MAX_NODE + 1];
    public static int[] nodeNum = new int[MAX_NODE + 1];
    public static int[] prefixWeight = new int[MAX_NODE + 1];
    public static int[] weight = new int[MAX_NODE + 1];

    public static void bfs(int idx){
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int postIdx = nodeList[idx].get(i);

            if(visited[postIdx]){
                continue;
            }

            visited[postIdx] = true;
            parents[postIdx] = idx;
            bfs(postIdx);
        }

        prefixWeight[idx] = weight[idx];
        nodeNum[idx] = 1;
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int postIdx = nodeList[idx].get(i);
            if(parents[postIdx] != idx){
                continue;
            }
            prefixWeight[idx] += prefixWeight[postIdx];
            nodeNum[idx] += nodeNum[postIdx];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
            weight[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodeList[start].add(end);
            nodeList[end].add(start);
        }

        visited[1] = true;
        bfs(1);
        
        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            ans += Math.abs(nodeNum[i] - prefixWeight[i]);
            //System.out.println(prefixWeight[i] + " " + nodeNum[i]);
        }

        System.out.println(ans);

    }
}