import java.util.*;
import java.io.*;

class path implements Comparable<path>{
    int left, right, weight;
    public path(int left, int right, int weight){
        this.left = left;
        this.right = right;
        this.weight = weight;
    }

    @Override
    public int compareTo(path p){
        return this.weight - p.weight;
    }
}

public class Main {
    public static final int MAX_LENGTH = 300;
    public static final int MAX_NODE = MAX_LENGTH * MAX_LENGTH;
    public static int[] uf = new int[MAX_NODE + 1];
    public static int[] cnt = new int[MAX_NODE + 1];
    public static PriorityQueue<path> pq = new PriorityQueue<>();

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n * m ; i++){
            uf[i] = i;
            cnt[i] = 1;
        }

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= m - 1; j++){
                int w = Integer.parseInt(st.nextToken());
                int idx = i * m + j;
                pq.add(new path(idx, idx + 1, w));
            }
        }

        for(int i = 0 ; i < n - 1 ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= m ; j++){
                int w = Integer.parseInt(st.nextToken());
                int idx = i * m + j;
                pq.add(new path(idx, idx + m, w));
            }
        }

        int ans = 0;
        while(!pq.isEmpty()){
            path curpath = pq.poll();
            if(find(curpath.left) == find(curpath.right)){
                continue;
            }
            union(curpath.left, curpath.right);
            ans += curpath.weight;
            if(cnt[find(curpath.right)] == n * m){
                System.out.print(ans);
                break;
            }
        }
    }
}