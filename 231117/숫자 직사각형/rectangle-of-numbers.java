import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt(), column = sc.nextInt();
        int[][] arr2D = new int[row][column];
        int num = 1;
        for(int i = 0 ; i < arr2D.length ; i++){
            for(int j = 0 ; j < arr2D[i].length ; j++){
                arr2D[i][j] = num;
                System.out.print(arr2D[i][j] + " ");
                num++;
            }
            System.out.println();
        }
    }
}