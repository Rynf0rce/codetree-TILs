import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static int[][] arr2D = new int[MAX_RANGE][MAX_RANGE];
    public static int[] arrR = new int[]{-1, 1, 0, 0};
    public static int[] arrC = new int[]{0, 0, -1, 1};
    public static boolean inRange(int row, int column, int size){
        return (row >= 0 && row < size && column >= 0 && column < size);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), r = sc.nextInt() - 1, c = sc.nextInt() - 1;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }

        System.out.print(arr2D[r][c] + " ");

        boolean triger = true;
        while(triger){
            triger = false;
            for(int j = 0 ; j < arrR.length ; j++){
                if( inRange(r + arrR[j], c + arrC[j], n) && arr2D[r][c] < arr2D[r + arrR[j]][c + arrC[j]]){
                    r += arrR[j];
                    c += arrC[j];
                    System.out.print(arr2D[r][c] + " ");
                    triger = true;
                    break;
                }
            }
        }

    }
}