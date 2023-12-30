import java.util.*;

class point{
    int row;
    int col;

    public point(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Main{
    public static final int MAX_EDGE = 100;
    public static final int NUM_DIRECTION = 4;

    public static int[][] table = new int[MAX_EDGE][MAX_EDGE];
    public static boolean[][] visited = new boolean[MAX_EDGE][MAX_EDGE];
    public static int[][] timeTable = new int[MAX_EDGE][MAX_EDGE];

    public static Queue<point> q = new LinkedList<>();

    public static int[] arrRow = new int[]{-1, 0, 1, 0};
    public static int[] arrCol = new int[]{0, 1, 0, -1};

    public static int n;

    public static boolean inRange(int row, int col){
        return (row >= 0 && col >= 0 && row < n && col < n);
    }

    public static boolean canGo(int row, int col){
        if(inRange(row, col) && !visited[row][col] && table[row][col] == 1){
            return true;
        }
        return false;
    }

    public static void push(int row, int col, int time){
        table[row][col] = 2;
        visited[row][col] = true;
        timeTable[row][col] = time;
        q.add(new point(row, col));
    }

    public static void BFS(){
        while(!q.isEmpty()){
            point curPoint = q.poll();
            for(int i = 0 ; i < NUM_DIRECTION ; i++){
                int postRow = curPoint.row + arrRow[i];
                int postCol = curPoint.col + arrCol[i];
                if(canGo(postRow, postCol)){
                    push(postRow, postCol, timeTable[curPoint.row][curPoint.col] + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int k = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                table[i][j] = sc.nextInt();
                timeTable[i][j] = -1;
                if(table[i][j] == 2){
                    push(i, j, 0);
                }
            }
        }

        BFS();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(table[i][j] == 1 ? (-2 + " ") : timeTable[i][j] + " ");
            }
            System.out.println();
        }
    }
}