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
    public static final int RAX_RANGE = 100;
    public static final int NUM_DIRECTION = 4;

    public static int[][] table = new int[RAX_RANGE][RAX_RANGE];
    public static int[][] visited = new int[RAX_RANGE][RAX_RANGE];
    public static int[] arrRow = new int[]{-1, 0, 1, 0};
    public static int[] arrCol = new int[]{0, 1, 0, -1};

    public static Queue<point> q = new LinkedList<>();

    public static int n;
    public static int m;

    public static boolean inRange(int row, int col){
        return (row >= 0 && col >= 0 && row < n && col < m);
    }

    public static boolean canGo(int row, int col){
        if(!inRange(row, col)){
            return false;
        }

        if(visited[row][col] > 0 || table[row][col] == 0){
            return false;
        }

        return true;
    }

    public static void push(int row, int col, int distance){
        visited[row][col] = distance;
        q.add(new point(row, col));
    }

    public static void BFS(){
        while(!q.isEmpty()){
            point curPoint = q.poll();
            for(int i = 0 ; i < NUM_DIRECTION ; i++){
                int postRow = curPoint.row + arrRow[i];
                int postCol = curPoint.col + arrCol[i];
                if(canGo(postRow, postCol)){
                    push(postRow, postCol, visited[curPoint.row][curPoint.col] + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                table[i][j] = sc.nextInt();
            }
        }

        if(canGo(0, 0)){
            push(0, 0, 0);
        }

        BFS();

        System.out.print(visited[n-1][m-1] == 0 ? -1 : visited[n-1][m-1]);
        
    }
}