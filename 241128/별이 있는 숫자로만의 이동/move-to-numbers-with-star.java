import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 400;
    public static int[][] table = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];
    public static int[][] prefixSum = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];

    public static int N;

    public static boolean inRange(int row, int col){
        return !(row <= 0 || col <= 0 || row > N || col > N);
    }

    public static int valueInRange(int row, int col, int length, int direction){
        int sum = 0;
        if(length < 0 || !inRange(row, col)){
            return 0;
        }

        int endIdx = col - length - 1;

        if(endIdx < 0){
            endIdx = 0;
        }
        int startIdx = col + length;
        if(startIdx > N){
            startIdx = N;
        }

        sum += prefixSum[row][startIdx] - prefixSum[row][endIdx];

        if(direction == 1){
            sum += valueInRange(row - 1, col, length - 1, 1);
        }
        else if(direction == 2){
            sum += valueInRange(row + 1, col, length - 1, 2);
        }
        else{
            sum += valueInRange(row - 1, col, length - 1, 1) + valueInRange(row + 1, col, length - 1, 2);
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int K = sc.nextInt();

        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                table[i][j] = sc.nextInt();
                prefixSum[i][j] = prefixSum[i][j - 1] + table[i][j];
            }
        }

        int maxVal = 0;
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                maxVal = Math.max(maxVal, valueInRange(i, j, K, 0));
            }
        }

        System.out.print(maxVal);
    }
}