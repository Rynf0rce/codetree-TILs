import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 300;
    public static final int INVALID = (int) 1e9;
    public static int[] selelctedValue = new int[MAX_NODE + 1];
    public static int[] dist = new int[MAX_NODE + 1];
    public static int[][] table = new int[MAX_NODE + 1][MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int minIdx = -1;
        for(int i = 1 ; i <= n ; i++){
            selelctedValue[i] = Integer.parseInt(br.readLine());
            dist[i] = INVALID;
            if(minIdx == -1 || selelctedValue[minIdx] > selelctedValue[i]){
                minIdx = i;
            }
        }

        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= n ; j++){
                table[i][j] = Math.min(selelctedValue[j], Integer.parseInt(st.nextToken()));
            }
        }

        dist[minIdx] = 0;
        int ans = selelctedValue[minIdx];
        for(int i = 0 ; i < n ; i++){
            int idx = -1;
            for(int j = 1 ; j <= n ; j++){
                if(visited[j]){
                    continue;
                }

                if(idx == -1 || dist[idx] > dist[i]){
                    idx = j;
                }
            }

            visited[idx] = true;
            ans += dist[idx];
            for(int j = 1 ; j <= n ; j++){
                if(table[idx][j] == 0){
                    continue;
                }
                dist[j] = Math.min(dist[j], table[idx][j]);
            }
        }

        System.out.print(ans);



    }
}