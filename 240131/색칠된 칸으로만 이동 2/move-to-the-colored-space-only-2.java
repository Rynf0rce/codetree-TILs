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
    public static final int MAX_INT = (int)1000000000L;
    public static final int NUM_DIRECTION = 4;
    public static int[][] table = new int[MAX_LENGTH][MAX_LENGTH];
    public static ArrayList<point> pointList = new ArrayList<>();

    public static boolean[][] vistied = new boolean[MAX_LENGTH][MAX_LENGTH];
    public static int[] arrRow = new int[]{-1, 0, 1, 0};
    public static int[] arrCol = new int[]{0, 1, 0, -1};

    public static Queue<point> q = new LinkedList<>();

    public static int M, N;

    public static boolean inRange(int row, int col){
        return row >= 0 && col >= 0 && row < M && col < N;
    }

    public static void initialize(){
        for(int i = 0 ; i < M ; i++){
            for(int j = 0 ; j < N ; j++){
                vistied[i][j] = false;
            }
        }
    }
    
    public static boolean isSatisfied(int gap){
        initialize();
        q.add(pointList.get(0));
        while(!q.isEmpty()){
            point curPoint = q.poll();

            if(vistied[curPoint.row][curPoint.col]){
                continue;
            }

            vistied[curPoint.row][curPoint.col] = true;

            for(int i = 0 ; i < NUM_DIRECTION ; i++){
                int postRow = curPoint.row + arrRow[i];
                int postCol = curPoint.col + arrCol[i];
                if(inRange(postRow, postCol) && Math.abs(table[curPoint.row][curPoint.col] - table[postRow][postCol]) <= gap){
                    q.add(new point(postRow, postCol));
                }
            }
        }

        for(int i = 0 ; i < pointList.size() ; i++){
            if(!vistied[pointList.get(i).row][pointList.get(i).col]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    pointList.add(new point(i, j));
                }
            }
        }

        int start = 0;
        int end = MAX_INT;
        int ans = MAX_INT;
        while(start <= end){
            int mid = (end + start) / 2;
            if(isSatisfied(mid)){
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