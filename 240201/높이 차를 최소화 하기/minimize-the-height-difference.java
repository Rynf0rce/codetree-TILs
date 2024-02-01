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
    public static final int MAX_LENGTH = 100;
    public static final int MAX_HEIGHT = 500;
    public static int[][] table = new int[MAX_LENGTH][MAX_LENGTH];

    public static int[] arrRow = new int[]{1, 0};
    public static int[] arrCol = new int[]{0, 1};
    public static Queue<point> q = new LinkedList<>();

    public static int n, m;

    public static boolean canGo(int low, int high, int postRow, int postCol, int range){
        if(postRow < 0 && postCol < 0 && postRow >= n && postCol >= m){
            return false;
        }

        int tempLow = Math.min(low, table[postRow][postCol]);
        int tempHigh = Math.max(high, table[postRow][postCol]);
        if(tempHigh - tempLow > range){
            return false;
        }

        return true;
    }

    public static boolean canReach(int range){
        q.clear();
        q.add(new point(0, 0));
        int low = MAX_HEIGHT;
        int high = 0;
        while(!q.isEmpty()){
            point curPoint = q.poll();
            low = Math.min(table[curPoint.row][curPoint.col], low);
            high = Math.max(table[curPoint.row][curPoint.col], high);
            if(curPoint.row == n - 1 && curPoint.col == m - 1){
                return true;
            }

            for(int i = 0 ; i < 2 ; i++){
                int postRow = curPoint.row + arrRow[i];
                int postCol = curPoint.col + arrCol[i];

                if(canGo(low, high, postRow, postCol, range)){
                    q.add(new point(postRow, postCol));
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