import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static int[] uf = new int[MAX_NODE + 1];
    public static int[] minArr = new int[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static int find(int idx){
        if(uf[idx] == idx){
            return idx;
        }
        int rootIdx = find(uf[idx]);
        uf[idx] = rootIdx;
        return rootIdx;
    }

    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            minArr[rootB] = Math.min(minArr[rootB], minArr[rootA]);
            uf[rootA] = rootB;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            uf[i] = i;
            minArr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        for(int i = 1 ; i <= n ; i++){
            int curIdx = find(i);
            if(visited[curIdx]){
                continue;
            }
            visited[curIdx] = true;
            pq.add(minArr[curIdx]);
        }

        int minVal = pq.poll();
        int ans = 0;
        while(!pq.isEmpty()){
            ans += minVal + pq.poll();
        }

        System.out.print(ans <= k ? ans : "NO");
    }
}