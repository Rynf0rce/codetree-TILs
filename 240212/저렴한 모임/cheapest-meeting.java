import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_INT = (int) 1e9;
    public static final int MAX_NODE = 100;
    public static int[][] graph = new int[MAX_NODE + 1][MAX_NODE + 1];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                graph[i][j] = MAX_INT;
            }
            graph[i][i] = 0;
        }
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());


        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start][end] = weight;
            graph[end][start] = weight;
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                for(int k = 1 ; k <= n ; k++){
                    if(graph[j][k] > graph[j][i] + graph[i][k]){
                        graph[j][k] = graph[j][i] + graph[i][k];
                    }
                }
            }
        }

        // for(int i = 1 ; i <= n ; i++){
        //     for(int j = 1 ; j <= n ; j++){
        //         System.out.print(graph[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        int ans = MAX_INT;
        for(int i = 1 ; i <= n ; i++){
            ans = Math.min(ans, graph[v1][i] + graph[v2][i] + graph[i][e]);
        }
        System.out.print(ans);
    }
}