import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 250;
    public static final long INVALIED = (long) 1e11;
    public static long[][] graph = new long[MAX_NODE + 1][MAX_NODE + 1];
    public static long[] dist = new long[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int N = -1;

    public static void initialize(){
        for(int i = 1 ; i <= N ; i++){
            dist[i] = INVALIED;
            visited[i] = false;
        }
    }

    public static void dijkstra(){
        initialize();
        dist[1] = 0;
        for(int i = 0 ; i < N ; i++){
            int minIdx = -1;
            for(int j = 1 ; j <= N ; j++){
                if(visited[j]){
                    continue;
                }

                if(minIdx == -1 || dist[minIdx] > dist[j]){
                    minIdx = j;
                }
            }

            visited[minIdx] = true;

            for(int j = 1 ; j <= N ; j++){
                if(graph[minIdx][j] == INVALIED){
                    continue;
                }

                if(dist[j] > dist[minIdx] + graph[minIdx][j]){
                    dist[j] = dist[minIdx] + graph[minIdx][j];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                graph[i][j] = INVALIED;
            }
        }
        initialize();

        int M = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long weight = Long.parseLong(st.nextToken());
            graph[start][end] = weight;
            graph[end][start] = weight;
        }

        dijkstra();
        long preVal = dist[N];

        long postVal = 0;
        for(int i = 1 ; i <= N ; i++){
            for(int j = i + 1 ; j <= N ; j++){
                if(graph[i][j] != INVALIED){
                    graph[i][j] *= 2;
                    graph[j][i] *= 2;
                    dijkstra();
                    postVal = Math.max(postVal, dist[N]);
                    graph[i][j] /= 2;
                    graph[j][i] /= 2;
                }
            }
        }

        System.out.print(postVal - preVal);
        
    }
}