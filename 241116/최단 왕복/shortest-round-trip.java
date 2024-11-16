import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100;
    public static final int INVAILD = (int) 1e7;
    public static int[][] graph = new int[MAX_NODE + 1][MAX_NODE + 1];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                graph[i][j] = INVAILD;
            }
            graph[i][i] = 0;
        }

        int m = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start][end] = weight;
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                for(int k = 1 ; k <= n ; k++){
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        int ans = INVAILD;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(i == j){
                    continue;
                }
                ans = Math.min(ans, graph[i][j] + graph[j][i]);
            }
        }

        System.out.print(ans);
    }
}