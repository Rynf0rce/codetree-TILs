import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr2D = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N - 2 ; j++){
                max = Math.max(max, arr2D[i][j] + arr2D[i][j+1] + arr2D[i][j+2]);
            }
        }

        System.out.println(max);
    }
}