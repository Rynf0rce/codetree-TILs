import java.util.*;
import java.io.*;

class path implements Comparable<path>{
    int right, left, weight;
    public path(int right, int left, int weight){
        this.right = right;
        this.left = left;
        this.weight = weight;
    }

    @Override
    public int compareTo(path p){
        return this.weight - p.weight;
    }
}

public class Main {
    public static final int MAX_NODE = 100000;
    public static int[] uf = new int[MAX_NODE + 1];
    public static int[] cnt = new int[MAX_NODE + 1];
    public static PriorityQueue<path> minPQ = new PriorityQueue<>();
    public static PriorityQueue<path> maxPQ = new PriorityQueue<>(new Comparator<path>(){
        @Override
        public int compare(path p1, path p2){
            return p2.weight - p1.weight;
        }
    });

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
            uf[rootA] = rootB;
            cnt[rootB] += cnt[rootA];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            uf[i] = i;
            cnt[i] = 1;
        }

        int m = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(w == 0){
                w = 1;
            }
            else{
                w = 0;
            }
            minPQ.add(new path(a, b, w));
            maxPQ.add(new path(a, b, w));
        }

        int minVal = 0;
        while(!minPQ.isEmpty()){
            path curPath = minPQ.poll();
            if(find(curPath.left) == find(curPath.right)){
                continue;
            }
            union(curPath.left, curPath.right);
            minVal += curPath.weight;

            if(cnt[find(curPath.left)] == n){
                break;
            }
        }

        for(int i = 1 ; i <= n ; i++){
            uf[i] = i;
            cnt[i] = 1;
        }

        int maxVal = 0;
        while(!maxPQ.isEmpty()){
            path curPath = maxPQ.poll();
            if(find(curPath.left) == find(curPath.right)){
                continue;
            }
            union(curPath.left, curPath.right);
            maxVal += curPath.weight;
            if(cnt[find(curPath.left)] == n){
                break;
            }
        }

        System.out.println( (int)(Math.pow(maxVal, 2) - Math.pow(minVal, 2)));
    }
}