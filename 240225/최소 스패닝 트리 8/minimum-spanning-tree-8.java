import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 500;
    public static final int INF = (int)1e9;
    public static int[][] table = new int[MAX_NODE + 1][MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int[] dist = new int[MAX_NODE + 1];
    public static int n = -1;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            dist[i] = INF;
            for(int j = 1 ; j <= n ; j++){
                table[i][j] = INF;
            }
        }

        int m = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            table[a][b] = Math.min(table[a][b], w);
            table[b][a] = Math.min(table[b][a], w);
        }

        int ans = 0;
        dist[1] = 0;
        for(int i = 1 ; i <= n ; i++){
            int minIdx = -1;
            for(int j = 1 ; j <= n ; j++){
                if(visited[j] || dist[j] == INF){
                    continue;
                }

                if(minIdx == -1 || dist[j] < dist[minIdx]){
                    minIdx = j;
                }
            }

            visited[minIdx] = true;
            ans += dist[minIdx];
            for(int j = 1 ; j <= n ; j++){
                if(table[minIdx][j] == INF){
                    continue;
                }
                dist[j] = Math.min(dist[j], table[minIdx][j]);
            }
        }

        System.out.print(ans);
    }
}