import java.util.*;

public class Main {
    public static final int NUM_RANGE = 20;
    public static final int EDGE = 3;
    public static int[][] arr = new int[NUM_RANGE][NUM_RANGE];
    public static int coin(int row, int column){
        int cnt = 0;
        for(int i = row ; i < row + EDGE ; i++){
            if(i >= NUM_RANGE){
                continue;
            }
            for(int j = column ; j < column + EDGE ; j++){
                if(j >= NUM_RANGE){
                    continue;
                }
                
                if(arr[i][j] == 1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), maxVal = Integer.MIN_VALUE;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                maxVal = Math.max(maxVal, coin(i,j));
            }
        }

        System.out.println(maxVal);

    }
}