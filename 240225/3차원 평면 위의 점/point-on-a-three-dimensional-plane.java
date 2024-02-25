import java.util.*;
import java.io.*;

class point{
    int idx, x, y, z;
    public point(int idx, int x, int y, int z){
        this.idx = idx;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

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
    public static ArrayList<point> pointList = new ArrayList<>();
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


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            uf[i] = i;
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            pointList.add(new point(i, x, y, z));
        }

        Collections.sort(pointList, new Comparator<point>(){
            @Override
            public int compare(point p1, point p2){
                return p1.x - p2.x;
            }
        });

        for(int i = 1 ; i < pointList.size() ; i++){
            point prePoint = pointList.get(i - 1);
            point curPoint = pointList.get(i);
            pq.add(new path(prePoint.idx, curPoint.idx, curPoint.x - prePoint.x));
        }

        Collections.sort(pointList, new Comparator<point>(){
            @Override
            public int compare(point p1, point p2){
                return p1.y - p2.y;
            }
        });

        for(int i = 1 ; i < pointList.size() ; i++){
            point prePoint = pointList.get(i - 1);
            point curPoint = pointList.get(i);
            pq.add(new path(prePoint.idx, curPoint.idx, curPoint.y - prePoint.y));
        }

        Collections.sort(pointList, new Comparator<point>(){
            @Override
            public int compare(point p1, point p2){
                return p1.z - p2.z;
            }
        });

        for(int i = 1 ; i < pointList.size() ; i++){
            point prePoint = pointList.get(i - 1);
            point curPoint = pointList.get(i);
            pq.add(new path(prePoint.idx, curPoint.idx, curPoint.z - prePoint.z));
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