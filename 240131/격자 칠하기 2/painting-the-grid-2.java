import java.util.*;
import java.io.*;

class point{
    int row;
    int col;

    public point(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Main {
    public static final int MAX_EDGE = 100;
    public static final int MAX_INT = 1000000;
    public static final int NUM_DIRECTION = 4;

    public static int[][] table = new int[MAX_EDGE][MAX_EDGE];
    public static boolean[][] visited = new boolean[MAX_EDGE][MAX_EDGE];
    public static Queue<point> q = new LinkedList<>();
    public static int[] arrRow = new int[]{-1, 0, 1, 0};
    public static int[] arrCol = new int[]{0, 1, 0, -1};

    public static int N;

    public static boolean inRange(int row, int col){
        return row >= 0 && col >= 0 && row < N && col < N;
    }

    public static void initialize(){
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                visited[i][j] = false;
            }
        }
    }

    public static boolean BFS(int row, int col, int length){
        q.clear();
        int cnt = 0;
        q.add(new point(row, col));
        int postRow, postCol;
        while(!q.isEmpty()){
            point curPoint = q.poll();
            

            if(visited[curPoint.row][curPoint.col]){
                continue;
            }

            visited[curPoint.row][curPoint.col] = true;
            cnt++;

            for(int i = 0 ; i < NUM_DIRECTION ; i++){
                postRow = curPoint.row + arrRow[i];
                postCol = curPoint.col + arrCol[i];
                if(inRange(postRow, postCol) && Math.abs(table[curPoint.row][curPoint.col] - table[postRow][postCol]) <= length ){
                    q.add(new point(postRow, postCol));
                }
            }
        }

        if(N % 2 == 1){
            return cnt >= (N * N) / 2 + 1;
        }
        else{
            return cnt >= (N * N) / 2;
        }
    }

    public static boolean satisfied(int length){
        initialize();
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(visited[i][j]){
                    continue;
                }

                if(BFS(i, j, length)){
                    return true;
                }
            }
        }
        return false;
    }



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int start = 0;
        int end = MAX_INT;
        int ans = MAX_INT;
        while(start <= end){
            int mid = (end + start) / 2;
            if(satisfied(mid)){
                end = mid - 1;
                ans = Math.min(ans, mid);
            }
            else{
                start = mid + 1;
            }
        }

        bw.write(ans + "");

        br.close();
        bw.close();
    }
}