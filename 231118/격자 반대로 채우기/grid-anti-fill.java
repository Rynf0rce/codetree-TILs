import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), num = 1;
        int[][] arr2d = new int[n][n];
        for(int j = arr2d[0].length - 1 ; j >= 0 ; j--){
            if(j % 2 == n % 2){
                for(int i = 0 ; i < arr2d.length ; i++){
                    arr2d[i][j] = num;
                    num++;
                }
            }
            else{
                for(int i = arr2d.length - 1 ; i >= 0 ; i--){
                    arr2d[i][j] = num;
                    num++;
                }
            }
        }

        for(int i = 0 ; i < arr2d.length ; i++){
            for(int j = 0 ; j < arr2d[i].length ; j++){
                System.out.print(arr2d[i][j] + " " );
            }
            System.out.println();
        }
    }
}