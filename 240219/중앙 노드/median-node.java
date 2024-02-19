import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int[] parents = new int[MAX_NODE + 1];
    public static int[] DP = new int[MAX_NODE + 1];
    public static int r = -1;
    public static boolean isCentral = false;

    public static void BFS(int idx){
        if(!isCentral){
            int cnt = 0;
            for(int i = 0 ; i < nodeList[idx].size(); i++){
                if(visited[nodeList[idx].get(i)]){
                    continue;
                }
                cnt++;
                if(cnt >= 2){
                    r = idx;
                    isCentral = true;
                    break;
                }
            }
        }

        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int postIdx = nodeList[idx].get(i);
            if(visited[postIdx]){
                continue;
            }
            parents[postIdx] = idx;
            visited[postIdx] = true;
            BFS(postIdx);
        }

        DP[idx] = 1;
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int connectedIdx = nodeList[idx].get(i);
            if(parents[connectedIdx] != idx){
                continue;
            }
            DP[idx] += DP[connectedIdx];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
        }
        r = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodeList[start].add(end);
            nodeList[end].add(start);
        }

        visited[r] = true;
        BFS(r);

        for(int i = 1 ; i <= n ; i++){
            visited[i] = false;
            parents[i] = 0;
        }

        visited[r] = true;
        BFS(r);

        int maxVal = 0;
        int minVal = MAX_NODE;
        for(int i = 0 ; i < nodeList[r].size() ; i++){
            int connectedIdx = nodeList[r].get(i);
            maxVal = Math.max(maxVal, DP[connectedIdx]);
            minVal = Math.min(minVal, DP[connectedIdx]);
        }
        System.out.print(maxVal - minVal);
        
    }
}