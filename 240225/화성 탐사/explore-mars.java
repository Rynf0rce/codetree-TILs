import java.util.*;
import java.io.*;

class point{
    int row, col;
    public point(int row, int col){
        this.row = row;
        this.col = col;
    }
}

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
    public static final int MAX_LENGTH = 50;
    public static final int MAX_FORTNESS = 100;

    public static ArrayList<point> pointList = new ArrayList<>();
    public static Queue<point> q = new LinkedList<>();
    public static int[][] table = new int[MAX_LENGTH][MAX_LENGTH];
    public static int[][] distTable = new int[MAX_LENGTH][MAX_LENGTH];
    public static boolean[][] visited = new boolean[MAX_LENGTH][MAX_LENGTH];
    public static int[] arrRow = new int[]{-1, 0, 1, 0};
    public static int[] arrCol = new int[]{0, 1, 0 , -1};
    public static int n = - 1;
    public static int pointIdx = 0;
    
    public static int[] uf = new int[MAX_FORTNESS + 1];
    public static int[] cnt = new int[MAX_FORTNESS + 1];
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
            cnt[rootB] += rootA;
        }
    }
    
    public static boolean calDist(int row, int col){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                distTable[i][j] = 0;
                visited[i][j] = false;
            }
        }
        q.clear();
        q.add(new point(row, col));
        visited[row][col] = true;
        while(!q.isEmpty()){
            point curPoint = q.poll();

            for(int i = 0 ; i < 4 ; i++){
                int postRow = curPoint.row + arrRow[i];
                int postCol = curPoint.col + arrCol[i];
                if(postRow >= 0 && postCol >= 0 && postCol < n && postRow < n && !visited[postRow][postCol] && table[postRow][postCol] != -1){
                    q.add(new point(postRow, postCol));
                    visited[postRow][postCol] = true;
                    distTable[postRow][postCol] = distTable[curPoint.row][curPoint.col] + 1;
                }
            }
        }

        for(int i = pointIdx + 1 ; i < pointList.size() ; i++){
            point curPoint = pointList.get(i);
            if(distTable[curPoint.row][curPoint.col] == 0){
                return false;
            }
            pq.add(new path(pointIdx, i, distTable[curPoint.row][curPoint.col]));
        } 
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
                if(table[i][j] == 1 || table[i][j] == 2){
                    pointList.add(new point(i, j));
                }
            }
        }

        for(int i = 0 ; i < pointList.size() ; i++){
            uf[i] = i;
            point curPoint = pointList.get(i);
            pointIdx = i;
            if(!calDist(curPoint.row, curPoint.col)){
                System.out.println(-1);
                System.exit(0);
            }
        }

        int ans = 0;
        while(!pq.isEmpty()){
            path curPath = pq.poll();
            if(find(curPath.left) == find(curPath.right)){
                continue;
            }
            union(curPath.left, curPath.right);
            ans += curPath.weight;
        }
        System.out.print(ans);
    }
}