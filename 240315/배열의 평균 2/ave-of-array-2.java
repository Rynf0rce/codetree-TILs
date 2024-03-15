import java.util.*;
public class Main {
    public static int[][] arr = new int[3][3];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 3;
        double totalSum = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                arr[i][j] = sc.nextInt();
                totalSum += arr[i][j];
            }
        }

        for(int i = 0 ; i < n ; i++){
            double sum = 0;
            for(int j = 0 ; j < n ; j++){
                sum += arr[i][j];
            }
            System.out.printf("%.1f ", sum / 3);
        }
        System.out.println();

        for(int j = 0 ; j < n ; j++){
            double sum = 0;
            for(int i = 0 ; i < n ; i++){
                sum += arr[i][j];
            }
            System.out.printf("%.1f ", sum / 3);
        }
        System.out.println();
        System.out.printf("%.1f", totalSum / 9);
    }
}