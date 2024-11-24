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
    public static final int MAX_RANGE = 100;
    public static final int NUM_DIRECTION = 4;
    public static int[][] table = new int[MAX_RANGE][MAX_RANGE];
    public static boolean[][] visited = new boolean[MAX_RANGE][MAX_RANGE];
    public static int[] arrRow = new int[]{-1, 0, 1, 0};
    public static int[] arrCol = new int[]{0, 1, 0, -1};
    public static Queue<point> vector = new LinkedList<>();
    public static int n;
    public static int m;

    public static boolean inRange(int row, int col){
        return (row >= 0 && col >= 0 && row < n && col < m);
    }

    public static boolean canGo(int row, int col){
        if(!inRange(row, col)){
            return false;
        }

        if(visited[row][col] || table[row][col] == 0){
            return false;
        }

        return true;
    }

    public static void push(int row, int col){
        visited[row][col] = true;
        vector.add(new point(row, col));
    }

    public static void BFS(){
        while(!vector.isEmpty()){
            point curPoint = vector.poll();
            
            if(curPoint.row == n - 1 && curPoint.col == m - 1){
                System.out.print(1);
                System.exit(0);
            }

            for(int i = 0 ; i < NUM_DIRECTION ; i++){
                int postRow = curPoint.row + arrRow[i];
                int postCol = curPoint.col + arrCol[i];
                if(canGo(postRow, postCol)){
                    push(postRow, postCol);
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

        push(0, 0);
        
        BFS();

        System.out.print(0);
    }
}