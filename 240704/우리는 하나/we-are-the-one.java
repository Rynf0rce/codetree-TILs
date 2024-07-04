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
    public static final int MAX_RANGE = 8;
    public static final int NUM_DIRECTION = 4;

    public static int[][] table = new int[MAX_RANGE][MAX_RANGE];
    public static boolean[][] visited = new boolean[MAX_RANGE][MAX_RANGE];
    public static int[] arrRow = new int[]{-1, 0, 1, 0};
    public static int[] arrCol = new int[]{0, 1, 0, -1};
    
    public static Queue<point> q = new LinkedList<>();
    public static ArrayList<Integer> selected = new ArrayList<>();
    
    public static int n, k, u, d, curHeight, cnt;
    public static int maxVal = Integer.MIN_VALUE;

    public static void clearVisited(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                visited[i][j] = false;
            }
        }
    }

    public static boolean inRange(int row, int col){
        return (row >= 0 && col >= 0 && row < n && col < n);
    }

    public static boolean canGo(int row, int col){
        if(!inRange(row, col)){
            return false;
        }

        if(visited[row][col] || Math.abs(table[row][col] - curHeight) < u || Math.abs(table[row][col] - curHeight) > d){
            return false;
        }

        return true;
    }

    public static void push(int row, int col){
        visited[row][col] = true;
        q.add(new point(row, col));
        cnt++;
    }

    public static void BFS(){
        clearVisited();
        cnt = 0;
        for(int i = 0 ; i < selected.size() ; i++){
            int startRow = selected.get(i) / n;
            int startCol = selected.get(i) % n;
            
            push(startRow, startCol);
            
            while(!q.isEmpty()){
                point curPoint = q.poll();
                curHeight = table[curPoint.row][curPoint.col];
                for(int j = 0 ; j < NUM_DIRECTION ; j++){
                    int postRow = curPoint.row + arrRow[j];
                    int postCol = curPoint.col + arrCol[j];
                    if(canGo(postRow, postCol)){
                        push(postRow, postCol);
                    }
                }
            }
            maxVal = Math.max(maxVal, cnt);
        }
    }

    public static void selectCity(int num){
        if(selected.size() >= k){
            BFS();
            return;
        }

        for(int i = num ; i < n * n ; i++){
            selected.add(i);
            selectCity(num + 1);
            selected.remove(selected.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                table[i][j] = sc.nextInt();
            }
        }

        selectCity(0);

        System.out.print(maxVal);
    }
}