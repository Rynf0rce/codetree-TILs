import java.util.*;

class point{
    int row;
    int col;
    int min;
    int max;

    public point(int row, int col, int min, int max){
        this.row = row;
        this.col = col;
        this.min = min;
        this.max = max;
    }
}

public class Main {
    public static final int MAX_LENGTH = 100;
    public static final int MAX_HEIGHT = 500;
    public static int[][] table = new int[MAX_LENGTH][MAX_LENGTH];
    public static boolean[][] visited = new boolean[MAX_LENGTH][MAX_LENGTH];

    public static int[] arrRow = new int[]{-1, 0, 1, 0};
    public static int[] arrCol = new int[]{0, 1, 0, -1};
    public static Queue<point> q = new LinkedList<>();

    public static int n, m;

    public static void initialize(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                visited[i][j] = false;
            }
        }
    }

    public static boolean canGo(point curPoint, int postRow, int postCol, int range){
        if(postRow < 0 || postCol < 0 || postRow >= n || postCol >= m){
            return false;
        }

        int tempMin = Math.min(curPoint.min, table[postRow][postCol]);
        int tempMax = Math.max(curPoint.max, table[postRow][postCol]);
        if(tempMax - tempMin > range){
            return false;
        }

        return true;
    }

    public static boolean canReach(int range){
        q.clear();
        initialize();
        q.add(new point(0, 0, table[0][0], table[0][0]));
        while(!q.isEmpty()){
            point curPoint = q.poll();

            if(visited[curPoint.row][curPoint.col]){
                continue;
            }

            visited[curPoint.row][curPoint.col] = true;

            if(curPoint.row == n - 1 && curPoint.col == m - 1){
                return true;
            }

            for(int i = 0 ; i < 4 ; i++){
                int postRow = curPoint.row + arrRow[i];
                int postCol = curPoint.col + arrCol[i];

                if(canGo(curPoint, postRow, postCol, range)){
                    q.add(new point(postRow, postCol, Math.min(curPoint.min, table[postRow][postCol]), Math.max(curPoint.max, table[postRow][postCol])));
                }
            }
        }
        return false;
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

        // System.out.println(canReach(5));

        int start = 0;
        int end = MAX_HEIGHT;
        int ans = MAX_HEIGHT;
        while(start <= end){
            int mid = (end + start) / 2;
            if(canReach(mid)){
                end = mid - 1;
                ans = Math.min(ans, mid);
            }
            else{
                start = mid + 1;
            }
        }

        System.out.print(ans);
    }
}