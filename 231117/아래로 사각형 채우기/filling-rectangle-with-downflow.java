import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), num = 1;
        int[][] arr2d = new int[n][n];
        
        for(int j = 0 ; j < n ; j++){
            for(int i = 0 ; i < n ; i++){
                arr2d[i][j] = num;
                num++;
            }
        }
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(arr2d[i][j] + " ");
            }
            System.out.println();
        }
    }
}