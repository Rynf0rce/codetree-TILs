import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100;
    public static long[][] graph = new long[MAX_NODE][MAX_NODE];
    public static long INVAILD = (long)1e10;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                graph[i][j] = INVAILD;
            }
            graph[i][i] = 0;
        }

        int m = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long weight = Long.parseLong(st.nextToken());
            graph[start][end] = Math.min(graph[start][end], weight);
        }

        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                for(int k = 1 ; k <= N ; k++){
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                System.out.print( (graph[i][j] == INVAILD ? -1 : graph[i][j]) + " ");
            }
            System.out.println();
        }
    }
}