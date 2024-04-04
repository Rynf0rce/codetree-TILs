import java.util.*;
import java.io.*;

class point{
    int row;
    int col;
    int dir;

    public point(int row, int col, int dir){
        this.row = row;
        this.col = col;
        this.dir = dir;
    }
}

public class Main {
    public static final int MAX_LENGTH = 1000;
    public static boolean[][] table = new boolean[MAX_LENGTH][MAX_LENGTH];
    public static int[] arrRow = new int[]{-1, 0, 1, 0}; // 0 1 2 3
    public static int[] arrCol = new int[]{0, 1, 0, -1}; // 0 1 2 3
    public static int N = -1;
    public static int M = -1;

    public static boolean inRange(int row, int col){
        return row >= 0 && col >= 0 && row < N && col < M;
    }

    public static point reflect(point curPoint){
        // '/'
        int curDir = curPoint.dir;
        if(table[curPoint.row][curPoint.col]){
            curDir = curDir ^ 1;
        }
        else{
            curDir = curDir ^ 3;
        }

        // System.out.println("curDir : " + curDir);
        return new point(curPoint.row + arrRow[curDir], curPoint.col + arrCol[curDir], curDir);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N ; i++){
            String str = String.valueOf(br.readLine());
            for(int j = 0 ; j < M ; j++){
                if(str.charAt(j) == '/'){
                    table[i][j] = true;
                }
            }
        }

        int ans = 0;
        for(int i = 0 ; i < M ; i++){
            point curPoint = new point(0, i, 2);
            int cnt = 0;
            while(inRange(curPoint.row, curPoint.col)){
                cnt++;
                curPoint = reflect(curPoint);
            }
            ans = Math.max(ans, cnt);
        }

        for(int i = 0 ; i < N ; i++){
            point curPoint = new point(i, M - 1, 3);
            int cnt = 0;
            while(inRange(curPoint.row, curPoint.col)){
                cnt++;
                curPoint = reflect(curPoint);
            }
            ans = Math.max(ans, cnt);
        }

        for(int i = 0 ; i < M ; i++){
            point curPoint = new point(N - 1, i, 0);
            int cnt = 0;
            while(inRange(curPoint.row, curPoint.col)){
                cnt++;
                curPoint = reflect(curPoint);
            }
            ans = Math.max(ans, cnt);
        }

        for(int i = 0 ; i < N ; i++){
            point curPoint = new point(i, 0, 1);
            int cnt = 0;
            while(inRange(curPoint.row, curPoint.col)){
                cnt++;
                curPoint = reflect(curPoint);
            }
            ans = Math.max(ans, cnt);
        }
        
        System.out.print(ans);


    }
}