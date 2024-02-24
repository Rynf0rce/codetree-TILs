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
    public static final int MAX_NODE = 10000;
    public static boolean[] color = new boolean[MAX_NODE + 1];
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
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            uf[i] = i;
            cnt[i] = 1;
            if(st.nextToken().charAt(0) == 'b'){
                color[i] = true;
            }
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new path(a, b, w));
        }

        int ans = 0;
        while(!pq.isEmpty()){
            path curPath = pq.poll();
            if(color[curPath.left] == color[curPath.right] || find(curPath.left) == find(curPath.right)){
                continue;
            }
            union(curPath.left, curPath.right);
            ans += curPath.weight;
        }

        System.out.print(cnt[find(1)] == n ? ans : -1);
    }
}