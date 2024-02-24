import java.util.*;
import java.io.*;

class path implements Comparable<path>{
    int left, right;
    double weight;
    public path(int left, int right, double weight){
        this.left = left;
        this.right = right;
        this.weight = weight;
    }

    @Override
    public int compareTo(path p){
        if(this.weight > p.weight){
            return 1;
        }
        else if(this.weight == p.weight){
            return 0;
        }
        else{
            return -1;
        }
    }
}

public class Main {
    public static final int MAX_NODE = 200;
    public static PriorityQueue<path> pq = new PriorityQueue<>();
    public static int[] arrX = new int[MAX_NODE + 1];
    public static int[] arrY = new int[MAX_NODE + 1];
    public static int[] uf = new int[MAX_NODE + 1];
    public static int[] cnt = new int[MAX_NODE + 1];

    public static double calDistance(int a, int b){
        return Math.sqrt(Math.pow(arrX[a] - arrX[b], 2) + Math.pow(arrY[a] - arrY[b], 2));
    }

    public static int find(int idx){
        if(uf[idx] == idx){
            return idx;
        }
        return uf[idx] = find(uf[idx]);
    }

    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            uf[rootA] = rootB;
            cnt[rootB] += cnt[rootA];
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arrX[i] = x;
            arrY[i] = y;
            uf[i] = i;
            cnt[i] = 1;
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        for(int i = 1 ; i <= n - 1; i++){
            for(int j = i + 1 ; j <= n ; j++){
                pq.add(new path(i, j, calDistance(i, j)));
            }
        }
        
        double ans = 0;
        while(!pq.isEmpty()){
            path curPath = pq.poll();
            if(find(curPath.left) == find(curPath.right)){
                continue;
            }
            
            union(curPath.left, curPath.right);
            ans += curPath.weight;
            if(cnt[find(curPath.right)] == n){
                break;
            }
        }

        System.out.print(String.format("%.2f", ans));
    }
}