import java.util.*;

class point{
    int row;
    int col;

    public point(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Main {
    public static final int MAX_RANGE = 500;
    public static final int NUM_DIRCTION = 4;

    public static int[][] table = new int[MAX_RANGE][MAX_RANGE];
    public static int[][] disTable = new int[MAX_RANGE][MAX_RANGE];
    public static Queue<point> q = new LinkedList<>();

    public static int[] arrRow = new int[]{-1, 0, 1, 0};
    public static int[] arrCol = new int[]{0, 1, 0, -1};
    public static int n;
    public static int maxVal = Integer.MIN_VALUE;

    public static boolean inRange(int row, int col){
        return (row >= 0 && col >= 0 && row < n && col < n);
    }

    public static boolean canGo(int row, int col, int preVal, int preDis){
        if(!inRange(row, col) || preVal >= table[row][col] || preDis <= disTable[row][col]){
            return false;
        }

        return true;
    }

    public static void push(int row, int col, int distance){
        q.add(new point(row, col));
        disTable[row][col] = distance;
    }

    public static int BFS(int row, int col){
        push(row, col, 1);
        int output = 1;
        while(!q.isEmpty()){
            point curPoint = q.poll();
            int preVal = table[curPoint.row][curPoint.col];
            int preDis = disTable[curPoint.row][curPoint.col];
            for(int i = 0 ; i < NUM_DIRCTION ; i++){
                int postRow = curPoint.row + arrRow[i];
                int postCol = curPoint.col + arrCol[i];
                if(canGo(postRow, postCol, preVal, preDis + 1)){
                    push(postRow, postCol, preDis + 1);
                    output = Math.max(output, preDis + 1);
                }
            }
        }
        return output;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                table[i][j] = sc.nextInt();
            }
        }

        // maxVal = Math.max(maxVal, BFS(1, 1));

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                maxVal = Math.max(maxVal, BFS(i, j));
            }
        }

        System.out.print(maxVal);
        
    }
}