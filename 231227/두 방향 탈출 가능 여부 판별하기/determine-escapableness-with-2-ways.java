import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static final int GO_METHOD = 2;
    public static int[][] table = new int[MAX_RANGE][MAX_RANGE];
    public static boolean[][] visited = new boolean[MAX_RANGE][MAX_RANGE];
    public static int[] arrR = new int[]{0, 1};
    public static int[] arrC = new int[]{1, 0};
    public static int n;
    public static int m;

    public static boolean inRange(int row, int col){
        return (row >= 0 && col >= 0 && row < n && col < m);
    }

    public static void canReach(int row, int col){
        if(row == n - 1 && col == m - 1){
            System.out.print(1);
            System.exit(0);
        }

        visited[row][col] = true;

        for(int i = 0 ; i < GO_METHOD ; i++){
            int postRow = row + arrR[i];
            int postCol = col + arrC[i];

            if(inRange(postRow, postCol) && table[postRow][postCol] == 1 && !visited[postRow][postCol]){
                canReach(postRow, postCol);
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

        canReach(0,0);

        System.out.println(0);
    }
}