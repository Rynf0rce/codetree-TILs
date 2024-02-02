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
    public static final int MAX_LENGTH = 100;
    public static final int MAX_HEIGHT = 500;
    public static int[][] table = new int[MAX_LENGTH][MAX_LENGTH];
    public static boolean[][] vistied = new boolean[MAX_LENGTH][MAX_LENGTH];
    public static Queue<point> q = new LinkedList<>();
    public static int[] arrRow = new int[]{-1, 0, 1, 0};
    public static int[] arrCol = new int[]{0, 1, 0, -1};

    public static int n, m;
    public static int inMin = MAX_HEIGHT;
    public static int inMax = 0;

    public static void initialize(){
        q.clear();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                vistied[i][j] = false;
            }
        }
    }

    public static boolean inRange(int row, int col){
        return row >= 0 && col >= 0 && row < n && col < m;
    }

    public static boolean canGo(int row, int col, int min, int max){
        if(!inRange(row, col)){
            return false;
        }

        if(table[row][col] < min || table[row][col] > max){
            return false;
        }

        return true;
    }

    public static boolean BFS(int length){
        for(int j = inMin ; j <= inMax ; j++){
            initialize();
            q.add(new point(0, 0));
            while(!q.isEmpty()){
                point curPoint = q.poll();
                
                if(vistied[curPoint.row][curPoint.col]){
                    continue;
                }

                if(curPoint.row == n - 1 && curPoint.col == m - 1){
                    return true;
                }

                vistied[curPoint.row][curPoint.col] = true;

                for(int i = 0 ; i < 4 ; i++){
                    int postRow = curPoint.row + arrRow[i];
                    int postCol = curPoint.col + arrCol[i];

                    if(canGo(postRow, postCol, j, j + length)){
                        q.add(new point(postRow, postCol));
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < m ; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
                inMin = Math.min(inMin, table[i][j]);
                inMax = Math.max(inMax, table[i][j]);
            }
        }

        int start = 0;
        int end = MAX_HEIGHT;
        int ans = MAX_HEIGHT;
        while(start <= end){
            int mid = (start + end) / 2;
            if(BFS(mid)){
                // System.out.println("yes");
                end = mid - 1;
                ans = Math.min(ans, mid);
            }
            else{
                // System.out.println("no");
                start = start + 1;
            }
        }

        bw.write(ans + "");
        
        br.close();
        bw.close();
    }
}