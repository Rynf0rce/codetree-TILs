import java.util.*;

public class Main {
    public static final int MAX_RANGE = 20;
    public static int[][] arr2D = new int[MAX_RANGE][MAX_RANGE];
    public static int[] arrIdx = new int[MAX_RANGE * MAX_RANGE + 1];
    public static int[] arrR = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
    public static int[] arrC = new int[]{-1, 0, 1, 1, 1, 0 , -1, -1};
    public static int n;

    public static boolean inRange(int row, int column){
        return (row >= 0 && column >= 0 && row < n && column < n);
    }

    public static void changeMax(int row, int column){
        int maxVal = 0;
        int r = row;
        int c = column;
        for(int i = 0 ; i < arrR.length ; i++){
            if(inRange(row + arrR[i], column + arrC[i]) && maxVal < arr2D[row + arrR[i]][column + arrC[i]]){
                r = row + arrR[i];
                c = column + arrC[i];
                maxVal = arr2D[r][c];
            }
        }

        arr2D[r][c] = arr2D[row][column];
        arr2D[row][column] = maxVal;
        arrIdx[arr2D[r][c]] = r * 4 + c;
        arrIdx[arr2D[row][column]] = row * 4 + column;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                arr2D[i][j] = sc.nextInt();
                arrIdx[arr2D[i][j]] = i * 4 + j;
            }
        }

        for(int i = 0 ; i < m ; i++){
            for(int j = 1 ; j <= n * n ; j++){
                int row = arrIdx[j] / 4;
                int column = arrIdx[j] % 4;
                changeMax(row, column);
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(arr2D[i][j] + " ");
            }
            System.out.println();
        }
    }
}