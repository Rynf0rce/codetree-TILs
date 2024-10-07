import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 1000;
    public static final int INVALUED = (int)1e7;
    public static int[][] graph = new int[MAX_NODE + 1][MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int[] dist = new int[MAX_NODE + 1];
    public static int[] path = new int[MAX_NODE + 1];
    public static ArrayList<Integer> pathList = new ArrayList<>();
    public static int n = -1;

    public static void initialize(){
        for(int i = 1 ; i <= n ; i++){
            visited[i] = false;
            dist[i] = INVALUED;
        }
    }

    public static void dijkstra(){
        initialize();
        dist[1] = 0;
        for(int i = 0 ; i < n ; i++){
            int minIdx = -1;
            for(int j = 1 ; j <= n ; j++){
                if(visited[j]){
                    continue;
                }

                if(minIdx == - 1 || dist[minIdx] > dist[j]){
                    minIdx = j;
                }
            }

            visited[minIdx] = true;

            for(int j = 1 ; j <= n ; j++){
                if(graph[minIdx][j] == INVALUED){
                    continue;
                }
                if(dist[j] > graph[minIdx][j] + dist[minIdx]){
                    dist[j] = graph[minIdx][j] + dist[minIdx];
                    path[j] = minIdx;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                graph[i][j] = INVALUED;
            }
        }
        
        for(int i = 0 ; i < m ; i++){
            st =  new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start][end] = weight;
            graph[end][start] = weight;
        }

        dijkstra();
        int preAns = dist[n];

        int curIdx = n;
        while(curIdx != 0){
            pathList.add(curIdx);
            curIdx = path[curIdx];
        }
        
        int output = 0;
        for(int i = pathList.size() - 1; i >= 1 ; i--){
            int end = pathList.get(i);
            int start = pathList.get(i - 1);

            int StoE = graph[start][end];
            int EtoS = graph[end][start];
            graph[start][end] = INVALUED;
            graph[end][start] = INVALUED;

            dijkstra();
            if(preAns != dist[n]){
                output++;
            }
            graph[start][end] = StoE;
            graph[end][start] = EtoS;
        }

        System.out.print(output);

        
    }
}