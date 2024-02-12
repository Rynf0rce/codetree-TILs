import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100;
    public static boolean[][] graph = new boolean[MAX_NODE + 1][MAX_NODE + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            graph[i][i] = true;
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start][end] = true;
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                for(int k = 1 ; k <= n ; k++){
                    if(graph[j][i] && graph[i][k]){
                        graph[j][k] = true;
                    }  
                }
            }
        }

        for(int i = 1 ; i <= n ; i++){
            int cnt = 0;
            for(int j = 1 ; j <= n ; j++){
                if(!graph[i][j] && !graph[j][i]){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}