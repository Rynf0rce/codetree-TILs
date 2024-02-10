import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100;
    public static boolean[][] graph = new boolean[MAX_NODE][MAX_NODE];
    public static int[][] ans = new int[MAX_NODE][MAX_NODE];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    graph[i][j] = true;
                }
            }
            graph[i][i] = true;
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                for(int k = 0 ; k < n ; k++){
                    if(graph[j][i] && graph[i][k]){
                        graph[j][k] = true;
                    }
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print( (graph[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }
}