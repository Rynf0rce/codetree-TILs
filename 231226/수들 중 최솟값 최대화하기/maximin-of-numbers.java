import java.util.*;

public class Main {
    public static final int MAX_RANGE = 10;
    public static int[][] table = new int[MAX_RANGE][MAX_RANGE];
    public static boolean[] arrCol = new boolean[MAX_RANGE];
    public static int maxVal = Integer.MIN_VALUE;
    public static int n;

    public static void maxOfMin(int row, int value){
        if(row >= n){
            maxVal = Math.max(maxVal, value);
            return;
        }

        for(int i = 0 ; i < n ; i++){
            if(arrCol[i]){
                continue;
            }

            arrCol[i] = true;
            maxOfMin(row + 1, Math.min(value, table[row][i]));
            arrCol[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                table[i][j] = sc.nextInt();
            }
        }

        maxOfMin(0, Integer.MAX_VALUE);

        System.out.println(maxVal);
    }
}