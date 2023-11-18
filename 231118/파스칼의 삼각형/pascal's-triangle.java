import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr2d = new int[n][n];
        for(int i = 0 ; i < arr2d.length ; i++){
            for(int j = 0 ; j < arr2d.length ; j++){
                if( j == 0  || i == j){
                    arr2d[i][j] = 1;
                }
                else if(i > j){
                    arr2d[i][j] = arr2d[i-1][j-1] + arr2d[i-1][j];
                }

                if(arr2d[i][j] == 0){
                    break;
                }
                System.out.print(arr2d[i][j] + " " );
            }
            System.out.println();
        }

    }
}