import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr2D_1 = new int[3][3];
        int[][] arr2D_2 = new int[3][3];
        for(int i = 0 ; i < arr2D_1.length ; i++){
            for(int j = 0 ; j < arr2D_1[i].length ; j++){
                arr2D_1[i][j] = sc.nextInt();
            }
        }
        for(int i = 0 ; i < arr2D_2.length ; i++){
            for(int j = 0 ; j < arr2D_2[i].length ; j++){
                arr2D_2[i][j] = sc.nextInt();
                System.out.print(arr2D_1[i][j] * arr2D_2[i][j] + " ");
            }
            System.out.println();
        }
    }
}