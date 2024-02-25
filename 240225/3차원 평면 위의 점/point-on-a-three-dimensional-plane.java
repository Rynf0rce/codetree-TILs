import java.util.*;
import java.io.*;

class path implements Comparable<path>{
    int left, right;
    long weight;
    public path(int left, int right, long weight){
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
    public static final int MAX_NODE = 100000;
    public static int[] arrX = new int[MAX_NODE + 1];
    public static int[] arrY = new int[MAX_NODE + 1];
    public static int[] arrZ = new int[MAX_NODE + 1];
    public static int[] uf = new int[MAX_NODE + 1];
    public static PriorityQueue<path> pq = new PriorityQueue<>();
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

    public static int calMin(int a, int b){
        int diffX = Math.abs(arrX[a] - arrX[b]);
        int diffY = Math.abs(arrY[a] - arrY[b]);
        int diffZ = Math.abs(arrZ[a] - arrZ[b]);

        int ans = Math.min(diffX, diffY);
        ans = Math.min(ans, diffZ);
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            uf[i] = i;
            st = new StringTokenizer(br.readLine(), " ");
            arrX[i] = Integer.parseInt(st.nextToken());
            arrY[i] = Integer.parseInt(st.nextToken());
            arrZ[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i <= n - 1 ; i++){
            for(int j = i + 1; j <= n ; j++){
                pq.add(new path(i, j, (long)calMin(i, j)));
            }
        }

        long ans = 0;
        while(!pq.isEmpty()){
            path curPath = pq.poll();
            if(find(curPath.left) == find(curPath.right)){
                continue;
            }
            ans += curPath.weight;
            union(curPath.left, curPath.right);
        }
        System.out.print(ans);
    }
}