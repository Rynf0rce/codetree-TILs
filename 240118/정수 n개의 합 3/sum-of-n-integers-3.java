import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 500;
    public static int[][] table = new int[MAX_LENGTH][MAX_LENGTH];
    public static int[][] sumTable = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                table[i][j] = sc.nextInt();
            }
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                sumTable[i][j] = sumTable[i - 1][j] + sumTable[i][j - 1] - sumTable[i - 1][j - 1] + table[i - 1][j - 1];
            }
        }

        int maxVal = 0;
        for(int i = k ; i <= n ; i++){
            for(int j = k ; j <= n ; j++){
                maxVal = Math.max(maxVal, sumTable[i][j] + sumTable[i - k][j - k] - sumTable[i - 1][j] - sumTable[i][j - 1]);
            }
        }

        System.out.print(maxVal);
    }
}