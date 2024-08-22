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
    public static final int PEOPLE = 2;
    public static final int HOUSE = 3;
    public static int n;

    public static int[][] table = new int[MAX_RANGE][MAX_RANGE];
    public static int[][] calTable = new int[MAX_RANGE][MAX_RANGE];
    public static int[][] answer = new int[MAX_RANGE][MAX_RANGE];
    public static int[][] visited = new int[MAX_RANGE][MAX_RANGE];

    public static int[] arrRow = new int[]{-1, 0, 1, 0};
    public static int[] arrCol = new int[]{0, 1, 0, -1};

    public static Queue<point> q = new LinkedList<>();
    public static ArrayList<point> peopleList = new ArrayList<>();

    public static void clearCalTable(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(table[i][j] == 1){
                    calTable[i][j] = 1;
                }
                else{
                    calTable[i][j] = 0;
                }
            }
        }
    }

    public static void clearVisited(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                visited[i][j] = 0;
            }
        }
    }

    public static boolean inRange(int row, int col){
        return (row >= 0 && col >= 0 && row < n && col < n);
    }

    public static boolean canGo(int row, int col){
        if(!inRange(row, col) || calTable[row][col] > 0 || visited[row][col] > 0){
            return false;
        }

        return true;
    }

    public static void push(int row, int col, int distance){
        visited[row][col] = distance;
        q.add(new point(row, col));
    }

    public static int BFS(){
        while(!q.isEmpty()){
            point curPoint = q.poll();
            int distance = visited[curPoint.row][curPoint.col];
            if(table[curPoint.row][curPoint.col] == HOUSE){
                return distance - 1;
            }

            for(int i = 0 ; i < NUM_DIRECTION ; i++){
                int postRow = curPoint.row + arrRow[i];
                int postCol = curPoint.col + arrCol[i];
                if(canGo(postRow, postCol)){
                    push(postRow, postCol, distance + 1);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int h = sc.nextInt();
        int m = sc.nextInt();
        int cnt = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                table[i][j] = sc.nextInt();
                if(table[i][j] == PEOPLE){
                    peopleList.add(new point(i, j));
                }
            }
        }

        for(int i = 0 ; i < peopleList.size() ; i++){
            clearCalTable();
            clearVisited();
            q.clear();
            cnt = 0;
            
            point start = peopleList.get(i);
            push(start.row, start.col, 1);
            cnt = BFS();
            answer[start.row][start.col] = cnt;
        }
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

    }
}