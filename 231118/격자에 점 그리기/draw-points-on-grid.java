import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), row = 0, column = 0, cnt = 1;
        int[][] arr2d = new int[n][n];
        for(int i = 0; i < m ; i++){
            row = sc.nextInt();
            column = sc.nextInt();
            arr2d[row - 1][column - 1] = cnt;
            cnt++;
        }
        for(int i = 0 ; i < arr2d.length ; i++){
            for(int j = 0 ; j < arr2d.length ; j++){
                System.out.print(arr2d[i][j] + " ");
            }
            System.out.println();
        }
    }
}