import java.util.*;

public class Main {
    public static final int EDGE = 200;
    public static int[][] arr2D = new int[EDGE][EDGE];
    public static int maxTromino(int row, int column){
        int maxVal = Integer.MIN_VALUE;
        for(int i = 0 ; i < row - 1 ; i++){
            for(int j = 0 ; j < column -1 ; j++){
                int[] arr = new int[]{arr2D[i][j], arr2D[i][j+1], arr2D[i+1][j], arr2D[i+1][j+1]};
                Arrays.sort(arr);
                maxVal = Math.max(maxVal, arr[1] + arr[2] + arr[3] );
            }
        }

        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < column - 2 ; j++){
                maxVal = Math.max(maxVal, arr2D[i][j] + arr2D[i][j+1] + arr2D[i][j+2] );
            }
        }

        for(int i = 0 ; i < row - 2 ; i++){
            for(int j = 0 ; j < column ; j++){
                maxVal = Math.max(maxVal, arr2D[i][j] + arr2D[i+1][j] + arr2D[i+2][j] );
            }
        }

        return maxVal;              
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt(), m = sc.nextInt();
       for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }

        System.out.println(maxTromino(n,m));
    }
}

/*
import java.util.Scanner;

public class Main {
    public static final int MAX_NUM = 200;
    
    public static int n, m;
    public static int[][] grid = new int[MAX_NUM][MAX_NUM];
    
    // 가능한 모든 모양을 전부 적어줍니다.
    public static int[][][] shapes = new int[][][]{
        {{1, 1, 0},
        {1, 0, 0},
        {0, 0, 0}},
    
        {{1, 1, 0},
        {0, 1, 0},
        {0, 0, 0}},
    
        {{1, 0, 0},
        {1, 1, 0},
        {0, 0, 0}},
    
        {{0, 1, 0},
        {1, 1, 0},
        {0, 0, 0}},
    
        {{1, 1, 1},
        {0, 0, 0},
        {0, 0, 0}},
    
        {{1, 0, 0},
        {1, 0, 0},
        {1, 0, 0}},
    };
    
    // 주어진 위치에 대하여 가능한 모든 모양을 탐색하며 최대 합을 반환합니다.
    public static int getMaxSum(int x, int y) {
        int maxSum = 0;
        
        for(int i = 0; i < 6; i++) {
            boolean isPossible = true;
            int sum = 0;
            for(int dx = 0; dx < 3; dx++)
                for(int dy = 0; dy < 3; dy++) {
                    if(shapes[i][dx][dy] == 0) continue;
                    if(x + dx >= n || y + dy >= m) isPossible = false;
                    else sum += grid[x + dx][y + dy];
                }
    
            if(isPossible)
                maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        int ans = 0;
        
        // 격자의 각 위치에 대하여 탐색하여줍니다.
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                ans = Math.max(ans, getMaxSum(i, j));
        
        System.out.print(ans);
    }
}
*/
