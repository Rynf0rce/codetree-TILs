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