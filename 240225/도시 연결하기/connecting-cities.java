import java.util.*;
import java.io.*;

class point{
    int row, col;
    public point(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class node implements Comparable<node>{
    int idx, weight;
    public node(int idx, int weight){
        this.idx = idx;
        this.weight = weight;
    }

    @Override
    public int compareTo(node n){
        return this.weight - weight;
    }
}

public class Main {
    public static final int MAX_LENGTH = 50;
    public static final int MAX_INT = (int) 1e9;
    public static int[][] table = new int[MAX_LENGTH][MAX_LENGTH];
    public static boolean[][] tableVisited = new boolean[MAX_LENGTH][MAX_LENGTH];
    public static int[][] label = new int[MAX_LENGTH][MAX_LENGTH];
    public static Queue<point> q = new LinkedList<>();
    public static int[] arrRow = new int[]{-1, 0, 1, 0};
    public static int[] arrCol = new int[]{0, 1, 0, -1};

    public static ArrayList<node>[] nodeList = new ArrayList[MAX_LENGTH * MAX_LENGTH / 2 + 1];
    public static int[] dist = new int[MAX_LENGTH * MAX_LENGTH / 2 + 1];
    public static boolean[] visited = new boolean[MAX_LENGTH * MAX_LENGTH / 2 + 1];
    public static PriorityQueue<node> pq = new PriorityQueue<>();

    public static int n = -1;
    public static int m = -1;
    public static int num = 0;
    public static int nodeNum = -1;

    public static boolean inRange(int row, int col){
        return row >= 0 && col >= 0 && row < n && col < m;
    }

    public static void labeling(int row, int col){
        if(table[row][col] == 0 || label[row][col] > 0){
            return;
        }
        q.clear();
        q.add(new point(row, col));
        num++;
        while(!q.isEmpty()){
            point curPoint = q.poll();
            if(tableVisited[curPoint.row][curPoint.col]){
                continue;
            }

            tableVisited[curPoint.row][curPoint.col] = true;
            label[curPoint.row][curPoint.col] = num;

            for(int i = 0 ; i < 4 ; i++){
                int postRow = curPoint.row + arrRow[i];
                int postCol = curPoint.col + arrCol[i];
                if(inRange(postRow, postCol) && table[postRow][postCol] == 1){
                    q.add(new point(postRow, postCol));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < m ; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                labeling(i, j);
            }
        }

        nodeNum = num;
        for(int i = 1 ; i <= nodeNum ; i++){
            nodeList[i] = new ArrayList<>();
        }

        // Horizontal
        for(int i = 0 ; i < n ; i++){
            int cnt = 0;
            int idx = 0;
            boolean triger = false;
            for(int j = 0 ; j < m ; j++){
                if(label[i][j] == 0){
                    cnt++;
                }
                else{
                    if(idx == 0){
                        idx = label[i][j];
                        cnt = 0;
                    }
                    else if(idx != label[i][j]){
                        nodeList[idx].add(new node(label[i][j], cnt));
                        nodeList[label[i][j]].add(new node(idx, cnt));
                        cnt = 0;
                        idx = label[i][j];
                    }
                }
            }
        }

        // Vertical
        for(int j = 0 ; j < m ; j++){
            int cnt = 0;
            int idx = 0;
            boolean triger = false;
            for(int i = 0 ; i < n ; i++){
                if(label[i][j] == 0){
                    cnt++;
                }
                else{
                    if(idx == 0){
                        idx = label[i][j];
                        cnt = 0;
                    }
                    else if(idx != label[i][j]){
                        nodeList[idx].add(new node(label[i][j], cnt));
                        nodeList[label[i][j]].add(new node(idx, cnt));
                        cnt = 0;
                        idx = label[i][j];
                    }
                }
            }
        }

        // -- finshed initialize -- //

        for(int i = 1 ; i <= nodeNum ; i++){
            dist[i] = MAX_INT;
        }

        dist[1] = 0;
        pq.add(new node(1, 0));
        int ans = 0;
        while(!pq.isEmpty()){
            node curNode = pq.poll();
            if(visited[curNode.idx]){
                continue;
            }

            visited[curNode.idx] = true;
            ans += curNode.weight;
            for(int i = 0 ; i < nodeList[curNode.idx].size(); i++){
                node postNode = nodeList[curNode.idx].get(i);
                dist[postNode.idx] = Math.min(dist[postNode.idx], postNode.weight);
                pq.add(new node(postNode.idx, dist[postNode.idx]));
            }
        }

        boolean flag = false;
        for(int i = 1 ; i <= nodeNum ; i++){
            if(dist[i] == MAX_INT){
                flag = true;
                break;
            }
        }
        System.out.print(flag ? -1 : ans);

        
    }
}