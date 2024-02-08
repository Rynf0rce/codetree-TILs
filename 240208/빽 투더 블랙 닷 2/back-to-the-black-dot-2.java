import java.util.*;
import java.io.*;

class vertex implements Comparable<vertex>{
    int idx;
    long weight;

    public vertex(int idx, long weight){
        this.idx = idx;
        this.weight = weight;
    }

    @Override
    public int compareTo(vertex v){
        if(this.weight > v.weight){
            return 1;
        }
        else if(this.weight == v.weight){
            return 0;
        }
        else {
            return -1;
        }
    }
}

public class Main {
    public static final int MAX_VERTEX = 100000;
    public static final long INVALID = (long)1e10 + 1;
    public static ArrayList<vertex>[] vertexList = new ArrayList[MAX_VERTEX];
    public static long[] dist_A = new long[MAX_VERTEX + 1];
    public static long[] dist_B = new long[MAX_VERTEX + 1];
    public static PriorityQueue<vertex> pq = new PriorityQueue<>();

    public static void dijkstra(int startIdx, long[] dist){
        dist[startIdx] = 0;
        pq.add(new vertex(startIdx, dist[startIdx]));
        while(!pq.isEmpty()){
            vertex curVer = pq.poll();
            if(curVer.weight != dist[curVer.idx]){
                continue;
            }

            for(int i = 0 ; i < vertexList[curVer.idx].size() ; i++){
                vertex postVer = vertexList[curVer.idx].get(i);
                if(dist[postVer.idx] > curVer.weight + postVer.weight){
                    dist[postVer.idx] = curVer.weight + postVer.weight;
                    pq.add(new vertex(postVer.idx, dist[postVer.idx]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= N ; i++){
            vertexList[i] = new ArrayList<>();
            dist_A[i] = INVALID;
            dist_B[i] = INVALID;
        }

        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int I = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < M ; i++){
            st =  new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long weight = Long.parseLong(st.nextToken());
            vertexList[start].add(new vertex(end, weight));
            vertexList[end].add(new vertex(start, weight));
        }

        dijkstra(I, dist_A);
        dijkstra(J, dist_B);
        
        // for(int i = 1 ; i <= N ; i++){
        //     System.out.print(dist_A[i] + " ");
        // }
        
        // System.out.println();

        // for(int i = 1 ; i <= N ; i++){
        //     System.out.print(dist_B[i] + " ");
        // }

        // System.out.println();

        if(dist_A[J] == INVALID || dist_B[I] == INVALID){
            System.out.print(-1);
            System.exit(0);
        }

        long ans = INVALID;
        for(int i = 1 ; i <= N ; i++){
            long curVal = INVALID;
            if(i == I || i == J){
                continue;
            }

            //검 -> 빨 -> 검 -> 빨
            long cal_1 = (dist_A[i] + dist_B[i]) * 2;
            curVal = Math.min(curVal, cal_1);
            
            // 검 -> A빨 -> B빨 -> 검
            long cal_2 = dist_A[i] + dist_A[J] + dist_B[i];
            curVal = Math.min(curVal, cal_2);

            // 검 -> B빨 -> A빨 -> 검
            long cal_3 = dist_B[i] + dist_B[I] + dist_A[i];
            curVal = Math.min(curVal, cal_3);

            ans = Math.min(curVal, ans);
            
            // System.out.println("i : " + i + " cal_1 : " + cal_1 + " cal_2 : " + cal_2 + " cal_3 : " + cal_3);
        }

        System.out.print(ans);


    }
}