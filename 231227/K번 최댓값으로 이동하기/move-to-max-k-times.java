import java.util.*;

class point implements Comparable<point>{
    int row;
    int col;
    int value;

    public point(int row, int col, int value){
        this.row = row;
        this.col = col;
        this.value = value;
    }

    @Override
    public int compareTo(point p){
        if(this.value == p.value){
            if(this.row == p.row){
                return p.col - this.col;
            }
            else{
                return p.row - this.row;
            }
        }
        else{
            return this.value - p.value;
        }
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
    public static ArrayList<point> goList = new ArrayList<>();
    public static int n;
    public static int k;
    public static int criterion = Integer.MAX_VALUE;

    public static void clearVisited(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                visited[i][j] = false;
            }
        }
    }

    public static boolean inRange(int row, int col){
        return (row >= 0 && col >= 0 && row < n && col < n );
    }

    public static boolean canGo(int row, int col){
        if(!inRange(row, col)){
            return false;
        }

        if(table[row][col] >= criterion || visited[row][col]){
            return false;
        }

        return true;
    }

    public static void push(int row, int col){
        visited[row][col] = true;
        q.add(new point(row, col, table[row][col]));
    }

    public static void BFS(){
        while(!q.isEmpty()){
            point curPoint = q.poll();
            for(int i = 0 ; i < NUM_DIRECTION ; i++){
                int postRow = curPoint.row + arrRow[i];
                int postCol = curPoint.col + arrCol[i];
                if(canGo(postRow, postCol)){
                    visited[postRow][postCol] = true;
                    q.add(new point(postRow, postCol, table[postRow][postCol]));
                    goList.add(new point(postRow, postCol, table[postRow][postCol]));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                table[i][j] = sc.nextInt();
            }
        }

        int answerRow = sc.nextInt() - 1;
        int answerCol = sc.nextInt() - 1;
        criterion = table[answerRow][answerCol];
        for(int i = 0 ; i < k ; i++){
            push(answerRow, answerCol);
            BFS();
            if(goList.size() <= 0){
                break;
            }
            Collections.sort(goList);
            answerRow = goList.get(goList.size() - 1).row;
            answerCol = goList.get(goList.size() - 1).col;
            criterion = goList.get(goList.size() - 1).value;
            goList.clear();
            clearVisited();
        }

        System.out.print((answerRow + 1) + " " + (answerCol + 1));
        
    }
}