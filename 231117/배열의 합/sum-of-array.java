import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr2d = new int[4][4];
        int sum = 0;
        for(int i = 0; i < arr2d.length ; i++){
            sum = 0;
            for(int j = 0 ; j < arr2d[i].length ; j++ ){
                arr2d[i][j] = sc.nextInt();
                sum += arr2d[i][j];
            }
            System.out.println(sum);
        }
    }
}