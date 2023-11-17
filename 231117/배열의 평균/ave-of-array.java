import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr2d = new int[2][4];
        int sum = 0;

        for(int i = 0 ; i < arr2d.length ; i++){
            sum = 0;
            for(int j = 0 ; j < arr2d[i].length ; j++ ){
                arr2d[i][j] = sc.nextInt();
                sum += arr2d[i][j];
            }
            System.out.printf("%.1f ", (double) sum / arr2d[i].length );
        }
        System.out.println();

        for(int j = 0 ; j < arr2d[0].length ; j++){
            sum = 0;
            for(int i = 0 ; i < arr2d.length ; i++){
                sum += arr2d[i][j];
            }
            System.out.printf("%.1f ", (double) sum / arr2d.length );
        }
        System.out.println();

        sum = 0;
        for(int i = 0 ; i < arr2d.length ; i++){
            for(int j = 0 ; j < arr2d[i].length ; j++ ){
                sum += arr2d[i][j];
            }
        }
        System.out.printf("%.1f", (double) sum / (arr2d.length * arr2d[0].length));

    }
}