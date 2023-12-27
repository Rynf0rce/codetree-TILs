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
    public static Queue<point> q = new LinkedList<>();
    public static ArrayList<point> inputList = new ArrayList<>();
    public static int n;
    public static int output;

    public static boolean inRange(int row, int col){
        return (row >= 0 && col >= 0 && row < n && col < n);
    }
    
    public static boolean canGo(int row, int col){
        if(!inRange(row, col)){
            return false;
        }

        if(table[row][col] == 1 || visited[row][col]){
            return false;
        }

        return true;
    }

    public static void push(int row, int col){
        visited[row][col] = true;
        q.add(new point(row, col));
        output++;
    }

    public static void BFS(){
        while(!q.isEmpty()){
            point curPoint = q.poll();
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
        int m = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                table[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < m ; i++){
            int row = sc.nextInt();
            int col = sc.nextInt();
            inputList.add(new point(row - 1, col - 1));
        }

        for(int i = 0 ; i < m ; i++){
            int startRow = inputList.get(i).row;
            int startCol = inputList.get(i).col;
            if(canGo(startRow, startCol)){
                push(inputList.get(i).row, inputList.get(i).col);
                BFS();
            }
        }

        System.out.print(output);
    }
}