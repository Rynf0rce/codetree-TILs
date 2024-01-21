import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static final int NUM_SELECT = 3;
    public static int[] arr = new int[MAX_LENGTH + 1];
    public static int[][] DP = new int[NUM_SELECT + 2][MAX_LENGTH + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1 ; i <= n ; i++){
            arr[i] = sc.nextInt();
        }
        
        DP[1][1] = arr[1];
        for(int i = 1 ; i <= NUM_SELECT ; i++){
            for(int j = 2 * i - 1 ; j <= n ; j++){
                if(j < 2){
                    DP[i][j] = arr[j];
                    continue;
                }
                DP[i][j] = Math.max(DP[i][j - 1], DP[i - 1][j - 2] + arr[j]);
            }
        }

        for(int i = 0 ; i <= NUM_SELECT ; i++){
            for(int j = 0 ; j <= n ; j++){
                System.out.print(DP[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(DP[NUM_SELECT][n]);
    }
}