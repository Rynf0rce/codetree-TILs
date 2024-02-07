import java.util.*;
import java.io.*;

class vertex implements Comparable<vertex>{
    int idx;
    int L;
    int C;
    double weight;


    public vertex(int idx, int L, int C, int X){
        this.idx = idx;
        this.L = L;
        this.C = C;
        if(C == 0){
            this.weight = 0;
        }
        else{
            this.weight = Double.valueOf(X / C) + L;
        }
    }

    @Override
    public int compareTo(vertex e){
        if(this.weight > e.weight){
            return 1;
        }
        else if(this.weight == e.weight){
            return 0;
        }
        else{
            return -1;
        }
    }
}

public class Main {
    public static final int MAX_VERTEX = 500;
    public static final int INVALUED = (int)1e9;
    public static ArrayList<vertex>[] vertexList = new ArrayList[MAX_VERTEX + 1];
    public static double[] cost = new double[MAX_VERTEX + 1];
    public static PriorityQueue<vertex> pq = new PriorityQueue<>();

    public static double calCost(int B, int X, int A){
        double ans = (X / A) + B;
        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= MAX_VERTEX ; i++){
            vertexList[i] = new ArrayList<vertex>();
            cost[i] = INVALUED;
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken());
            int J = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            vertexList[I].add(new vertex(J, L, C, X));
            vertexList[J].add(new vertex(I, L, C, X));
        }
        
        cost[1] = 0;
        pq.add(new vertex(1, 0, INVALUED, X));
        while(!pq.isEmpty()){
            vertex curVertex = pq.poll();

            if(curVertex.weight != cost[curVertex.idx]){
                continue;
            }

            for(int i = 0 ; i < vertexList[curVertex.idx].size() ; i++){
                vertex postVertex = vertexList[curVertex.idx].get(i);
                int B = curVertex.L + postVertex.L;
                int A = Math.min(curVertex.C, postVertex.C);
                if(cost[postVertex.idx] > calCost(B, X, A)){
                    cost[postVertex.idx] = calCost(B, X, A);
                    pq.add(new vertex(postVertex.idx, B, A, X));
                }
            }
        }

        System.out.printf("%.0f", cost[N]);

        // for(int i = 1 ; i <= N ; i++){
        //     System.out.print(cost[i] + " ");
        // }
    }
}