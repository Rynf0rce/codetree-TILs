import java.util.*;

public class Main {
    public static final int MAX_RANGE = 500;
    public static final int NUM_DIRECTION = 4;

    public static int[][] table = new int[MAX_RANGE][MAX_RANGE];
    public static int[][] DP = new int[MAX_RANGE][MAX_RANGE];
    public static int[] arrRow = new int[]{-1, 0, 1, 0};
    public static int[] arrCol = new int[]{0, 1, 0, -1};

    public static int n;

    public static boolean inRange(int row, int col){
        return (row >= 0 && col >= 0 && row < n && col < n);
    }

    public static int setDP(int row, int col, int distance){
        if(DP[row][col] >= 0){
            return DP[row][col];
        }

        int maxDistance = 0;

        for(int i = 0 ; i < NUM_DIRECTION ; i++){
            int postRow = row + arrRow[i];
            int postCol = col + arrCol[i];
            if(inRange(postRow, postCol) && table[row][col] < table[postRow][postCol]){
                maxDistance = Math.max(maxDistance, distance + setDP(postRow, postCol, distance));
            }
        }

        DP[row][col] = maxDistance;

        return maxDistance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int maxVal = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                table[i][j] = sc.nextInt();
                DP[i][j] = -1;
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                maxVal = Math.max(maxVal, setDP(i, j, 1));
            }
        }

        System.out.print(maxVal + 1);
    }
}