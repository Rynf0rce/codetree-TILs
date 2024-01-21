import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] arr = new int[MAX_LENGTH + 2];
    public static int[] leftArr = new int[MAX_LENGTH + 4];
    public static int[] rightArr = new int[MAX_LENGTH + 4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n; i++){
            arr[i] = sc.nextInt();
        }

        leftArr[0] = arr[0];
        for(int i = 1 ; i < n; i++){
            leftArr[i] = Math.max(leftArr[i - 1], arr[i]);
        }

        rightArr[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--){
            rightArr[i] = Math.max(rightArr[i + 1], arr[i]);
        }
        
        int maxVal = 0;
        for(int i = 2 ; i < n - 2 ; i++){
            maxVal = Math.max(maxVal, leftArr[i - 2] + arr[i] + rightArr[i + 2]);
        }

        System.out.print(maxVal);
    }
}

/* DP로 풀기

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

        System.out.println(DP[NUM_SELECT][n]);
    }
}

*/