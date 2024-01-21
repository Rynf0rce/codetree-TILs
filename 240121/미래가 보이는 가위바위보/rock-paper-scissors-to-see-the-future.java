import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static final int MAX_CASES = 3;
    public static int[][] table = new int[MAX_CASES][MAX_LENGTH];
    public static int[] leftArr = new int[MAX_LENGTH];
    public static int[] rightArr = new int[MAX_LENGTH];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            char decision = sc.next().charAt(0);
            switch(decision){
                case 'H' : 
                    table[0][i]++;
                    break;
                case 'S' :
                    table[1][i]++;
                    break;
                case 'P' :
                    table[2][i]++;
                    break;
            }
        }

        for(int i = 0 ; i < MAX_CASES ; i++){
            int cnt = 0;
            for(int j = 0 ; j < n ; j++){
                cnt += table[i][j];
                leftArr[j] = Math.max(leftArr[j], cnt);
            }
        }

        for(int i = 0 ; i < MAX_CASES ; i++){
            int cnt = 0;
            for(int j = n - 1 ; j >= 0 ; j--){
                cnt += table[i][j];
                rightArr[j] = Math.max(rightArr[j], cnt);
            }
        }

        int maxWin = Math.max(leftArr[n - 1], rightArr[0]);
        for(int i = 1 ; i < n - 1 ; i++){
            maxWin = Math.max(maxWin, leftArr[i] + rightArr[i + 1]);
        }

        System.out.println(maxWin);
    }
}