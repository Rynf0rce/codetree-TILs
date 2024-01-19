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

/* 2회차때 배열 회전으로 문제 풀어보기
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 400;
    
    // 변수 선언
    public static int n, k;
    public static int[][] board = new int[MAX_N + 1][MAX_N + 1];
    public static int[][] board2 = new int[MAX_N * 2 + 1][MAX_N * 2 + 1];
    public static int[][] s = new int[MAX_N * 2 + 1][MAX_N * 2 + 1];
    public static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++) board[i][j] = sc.nextInt();

        // 2차원 배열을 45도 회전시킵니다.
        // 배열을 회전시키면 정사각형 부분합을 구하는 문제로
        // 바뀌기 때문에 훨씬 접근하기 쉬워집니다.        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board2[i + j - 1][n - i + j] = board[i][j];
            }
        }

        // 2차원 배열의 누적합을 구합니다.
        for(int i = 1; i <= 2 * n; i++)
            for(int j = 1; j <= 2 * n; j++)
                s[i][j] = s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1] + board2[i][j];
        
        // 한 변의 길이가 k2인 정사각형 중 부분합이 최대인 사각형을 찾습니다.
        int k2 = Math.min(2 * k + 1, 2 * n);
        for(int i = k2; i <= 2 * n; i++)
            for(int j = k2; j <= 2 * n; j++) {
            ans = Math.max(ans, s[i][j] - s[i][j - k2] - s[i - k2][j] + s[i - k2][j - k2]);
        }
        
        // 정답을 출력합니다.
        System.out.print(ans);
    }
}
*/