import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 200;
    public static final long INVALID = (long)1e11;
    public static long[][] dist = new long[MAX_NODE + 1][MAX_NODE + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 노드 수
        int M = Integer.parseInt(st.nextToken()); // 간선 수
        int P = Integer.parseInt(st.nextToken()); // 빨간 노드 끝 부분
        int Q = Integer.parseInt(st.nextToken()); // 질문 수

        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                dist[i][j] = INVALID;
            }
            dist[i][i] = 0;
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long weight = Long.parseLong(st.nextToken());
            dist[start][end] = weight;
        }


        for(int i = 1 ; i <= N ; i++){
            for(int j = 1; j <= N ; j++){
                for(int k = 1 ; k <= N ; k++){
                    if(dist[j][k] > dist[j][i] + dist[i][k]){
                        dist[j][k] = dist[j][i] + dist[i][k];                        
                    }
                }
            }
        }
        
        int cnt = 0;
        long sumVal = 0;
        for(int i = 0 ; i < Q ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long minVal = INVALID;
            for(int j = 1 ; j <= P ; j++){
                if(dist[start][j] == INVALID || dist[j][end] == INVALID){
                    continue;
                }

                minVal = Math.min(minVal, dist[start][j] + dist[j][end]);
            }

            if(minVal != INVALID){
                cnt++;
                sumVal += minVal;
            }         
        }

        // for(int i = 1 ; i <= N ; i++){
        //     for(int j = 1 ; j <= N ; j++){
        //         System.out.print(dist[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(cnt);
        System.out.print(sumVal);
    }
}