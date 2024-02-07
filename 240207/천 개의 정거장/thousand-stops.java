import java.util.*;
import java.io.*;

public class Main{
    public static final int MAX_VERTEX = 1000;
    public static final int MAX_INT = (int)1e12;
    public static HashMap<Integer, Long> busCost = new HashMap<>();
    public static int[][] graph = new int[MAX_VERTEX + 1][MAX_VERTEX + 1];
    public static long[] cost = new long[MAX_VERTEX + 1];
    public static int[] path = new int[MAX_VERTEX + 1];
    public static int[] bus = new int[MAX_VERTEX + 1];

    public static boolean[] visited = new boolean[MAX_VERTEX + 1];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken()); // 시작
        int B = Integer.parseInt(st.nextToken()); // 도착
        int N = Integer.parseInt(st.nextToken()); // 버스의 수

        for(int i = 1 ; i <= MAX_VERTEX ; i++){
            cost[i] = MAX_INT;
        }

        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            long cost = Long.parseLong(st.nextToken());
            busCost.put(i, cost);
            int num = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            int preIdx = -1;
            for(int j = 0 ; j < num ; j++){
                if(preIdx == -1){
                    preIdx = Integer.parseInt(st.nextToken());
                }
                else{
                    int curIdx = Integer.parseInt(st.nextToken());
                    graph[preIdx][curIdx] = i;
                    preIdx = curIdx;
                }
            }
        }

        cost[A] = 0;

        for(int i = 1; i <= MAX_VERTEX; i++) {
            int minIndex = -1;
            for(int j = 1; j <= MAX_VERTEX; j++) {
                if(visited[j]){
                    continue;
                }
                    
                if(minIndex == -1 || cost[minIndex] < cost[j] ){
                    minIndex = j;
                }
            }

            visited[minIndex] = true;

            for(int j = 1; j <= MAX_VERTEX; j++) {
                if(graph[minIndex][j] == 0){
                    continue;
                }
                
                long curCost = bus[minIndex] == graph[minIndex][j] ? cost[minIndex] : cost[minIndex] + busCost.get(graph[minIndex][j]);
        
                if(cost[j] > curCost){
                    cost[j] = curCost;
                    path[j] = path[minIndex] + 1;
                    bus[j] = graph[minIndex][j];
                }
            }
        }
        
        if(cost[B] == MAX_INT){
            System.out.print("-1 -1");
        }
        else{
            System.out.print(cost[B] + " " + path[B]);
        }
        
        // for(int i = 1 ; i <= 5 ; i++){
        //     System.out.println(cost[i] + " " + path[i] + " " + bus[i]);
        // }      
    }
}