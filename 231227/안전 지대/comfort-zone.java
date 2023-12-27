import java.util.*;

public class Main {
    public static final int MAX_RANGE = 50;
    public static final int NUM_DIRECTION = 4;
    public static int[][] table = new int[MAX_RANGE][MAX_RANGE];
    public static boolean[][] visited = new boolean[MAX_RANGE][MAX_RANGE];
    public static int[] arrRow = new int[]{-1, 0, 1, 0};
    public static int[] arrCol = new int[]{0, 1, 0, -1};
    public static int N;
    public static int M;

    public static void clearVisited(){
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                visited[i][j] = false;
            }
        }
    }

    public static boolean inRange(int row, int col){
        return (row >= 0 && col >= 0 && row < N && col < M);
    }

    public static boolean canGo(int row, int col, int K){
        if(!inRange(row, col)){
            return false;
        }

        if(visited[row][col] || table[row][col] <= K){
            return false;
        }

        return true;
    }

    public static boolean saftyZone(int row, int col, int K){
        if(!canGo(row, col, K)){
            return false;
        }

        visited[row][col] = true;

        for(int i = 0 ; i < NUM_DIRECTION ; i++){
            int postRow = row + arrRow[i];
            int postCol = col + arrCol[i];
            saftyZone(postRow, postCol, K);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int inputMax = Integer.MIN_VALUE;
        int maxVal = Integer.MIN_VALUE;
        int levelOfmaxVal = 0;
        int cnt = 0;
        
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                table[i][j] = sc.nextInt();
                inputMax = Math.max(inputMax, table[i][j]);
            }
        }

        for(int i = 1 ; i <= inputMax ; i++){
            clearVisited();
            cnt = 0;
            for(int j = 0 ; j < N ; j++){
                for(int k = 0 ; k < M; k++){
                    if(saftyZone(j, k, i)){
                        cnt++;
                    }
                }
            }
            if(maxVal < cnt){
                maxVal = cnt;
                levelOfmaxVal = i;
            }
        }

        System.out.print(levelOfmaxVal + " " + maxVal);   
    }
}