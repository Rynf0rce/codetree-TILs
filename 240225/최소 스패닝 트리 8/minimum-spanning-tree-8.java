import java.util.*;
import java.io.*;

class point implements Comparable<point>{
    int idx, weight;
    public point(int idx, int weight){
        this.idx = idx;
        this.weight = weight;
    }

    @Override
    public int compareTo(point p){
        return this.weight - p.weight;
    }
}

public class Main {
    public static final int MAX_NODE = 500;
    public static final int INF = (int)1e9;
    public static PriorityQueue<point> pq = new PriorityQueue<>();
    public static ArrayList<point>[] pointList = new ArrayList[MAX_NODE + 1];
    public static int[] uf = new int[MAX_NODE + 1];
    public static int[] dist = new int[MAX_NODE + 1];
    public static int n = -1;

    public static int find(int idx){
        if(uf[idx] == idx){
            return idx;
        }
        int rootIdx = find(uf[idx]);
        uf[idx] = rootIdx;
        return rootIdx;
    }

    public static void union(int a, int b){
        int rootA = a;
        int rootB = b;
        uf[rootA] = rootB;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            pointList[i] = new ArrayList<>();
            uf[i] = i;
            dist[i] = INF;
        }

        int m = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pointList[a].add(new point(b, w));
            pointList[b].add(new point(a, w));
        }

        int ans = 0;
        dist[1] = 0;
        pq.add(new point(1, dist[1]));
        while(!pq.isEmpty()){
            point curPoint = pq.poll();
            if(curPoint.weight != dist[curPoint.idx]){
                continue;
            }

            ans += curPoint.weight;
            union(curPoint.idx, 1);

            for(int i = 0 ; i < pointList[curPoint.idx].size(); i++){
                point postPoint = pointList[curPoint.idx].get(i);
                dist[postPoint.idx] = Math.min(dist[postPoint.idx], postPoint.weight);
                if(find(postPoint.idx) == find(curPoint.idx)){
                    continue;
                }
                pq.add(new point(postPoint.idx, dist[postPoint.idx]));
            }
        }

        System.out.print(ans);
    }
}

/*
import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 500;
    public static final int INF = (int)1e9;
    public static int[][] table = new int[MAX_NODE + 1][MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int[] dist = new int[MAX_NODE + 1];
    public static int n = -1;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            dist[i] = INF;
        }

        int m = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            table[a][b] = table[a][b] == 0 ? w : Math.min(table[a][b], w);
            table[b][a] = table[b][a] == 0 ? w : Math.min(table[b][a], w);
        }

        int ans = 0;
        dist[1] = 0;
        for(int i = 1 ; i <= n ; i++){
            int minIdx = -1;
            for(int j = 1 ; j <= n ; j++){
                if(visited[j] || dist[j] == INF){
                    continue;
                }

                if(minIdx == -1 || dist[j] < dist[minIdx]){
                    minIdx = j;
                }
            }

            visited[minIdx] = true;
            ans += dist[minIdx];
            for(int j = 1 ; j <= n ; j++){
                if(table[minIdx][j] == 0){
                    continue;
                }
                dist[j] = Math.min(dist[j], table[minIdx][j]);
            }
        }

        System.out.print(ans);
    }
}
*/