import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt(), column = sc.nextInt();
        int[][] arr2D_1 = new int[row][column];
        int[][] arr2D_2 = new int[row][column];
        int input = 0;
        for(int i = 0 ; i < arr2D_1.length ; i++){
            for(int j = 0 ; j < arr2D_1[i].length ; j++){
                arr2D_1[i][j] = sc.nextInt();
            }
        }
        for(int i = 0 ; i < arr2D_2.length ; i++){
            for(int j = 0 ; j < arr2D_2[i].length ; j++){
                input = sc.nextInt();
                if(arr2D_1[i][j] == input){
                    arr2D_2[i][j] = 0;
                }
                else{
                    arr2D_2[i][j] = 1;
                }
                System.out.print(arr2D_2[i][j] + " ");
            }
            System.out.println();
        }
    }
}