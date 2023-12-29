import java.util.*;

class point{
    int row;
    int col;

    public point(int row, int col){
        this.row = row;
        this.col = col;
    }

    public boolean equals(point obj) {
        if(this.row == obj.row && this.col == obj.col){
            return true;
        }
        return false;
    }
}

public class Main {
    public static final int MAX_RANGE = 100;
    public static final int NUM_DIRECTION = 4;

    public static int[][] table = new int[MAX_RANGE][MAX_RANGE];
    public static boolean[][] visited = new boolean[MAX_RANGE][MAX_RANGE];
    public static int[][] walkAway = new int[MAX_RANGE][MAX_RANGE];
    public static int[] arrRow = new int[]{-1, 0, 1, 0};
    public static int[] arrCol = new int[]{0, 1, 0, -1};

    public static Queue<point> q = new LinkedList<>();
    public static ArrayList<point> rockList = new ArrayList();

    public static int n;
    public static int k;
    public static point startPoint, endPoint;
    public static int minVal = Integer.MAX_VALUE;

    public static void clear(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                visited[i][j] = false;
                walkAway[i][j] = 0;
            }
        }
    }

    public static boolean inRange(int row, int col){
        return (row >= 0 && col >= 0 && row < n && col < n);
    }

    public static boolean canGo(int row, int col){
        if(!inRange(row, col) || visited[row][col] || table[row][col] == 1){
            return false;
        }
        
        return true;
    }

    public static void push(int row, int col, int distance){
        visited[row][col] = true;
        q.add(new point(row, col));
        walkAway[row][col] = distance;
    }

    public static int BFS(){
        while(!q.isEmpty()){
            point curPoint = q.poll();
            int distance = walkAway[curPoint.row][curPoint.col];

            if(curPoint.equals(endPoint)){
                return distance;
            }

            for(int i = 0 ; i < NUM_DIRECTION ; i++){
                int postRow = curPoint.row + arrRow[i];
                int postCol = curPoint.col + arrCol[i];
                if(canGo(postRow, postCol)){
                    push(postRow, postCol, distance + 1);
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    public static void findWay(int num){
        if(rockList.size() >= k){
            for(int i = 0 ; i < rockList.size() ; i++){
                point rock = rockList.get(i);
                table[rock.row][rock.col] = 0;
            }

            clear();
            if(canGo(startPoint.row, startPoint.col)){
                push(startPoint.row, startPoint.col, 0); 
            }

            minVal = Math.min(minVal, BFS());

            for(int i = 0 ; i < rockList.size() ; i++){
                point rock = rockList.get(i);
                table[rock.row][rock.col] = 1;
            }
            return;
        }

        for(int i = num ; i < n * n ; i++){
            int row = i / n;
            int col = i % n;
            if(table[row][col] == 1){
                rockList.add(new point(row, col));
                findWay(i + 1);
                rockList.remove(rockList.size() - 1);
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

        int r1 = sc.nextInt() - 1, c1 = sc.nextInt() - 1, r2 = sc.nextInt() - 1, c2 = sc.nextInt() - 1;

        startPoint = new point(r1, c1);
        endPoint = new point(r2, c2);

        findWay(0);

        System.out.println(minVal == Integer.MAX_VALUE ? -1 : minVal);
    }
}