import java.util.*;

public class Main {
    public static final int MAX_EDGE = 20;
    public static int[][] arr2D = new int[MAX_EDGE][MAX_EDGE];
    public static int n;
    public static int m;

    public static boolean inRange(int row, int column){
        if(row < 0 || column < 0 || row >= n || column >= m){
            return false;
        }
        return true;
    }
    
    public static int satisfiedRect(int row, int column, int height, int width){
        int output = 0;
        for(int i = row ; i <= row + height ; i++){
            for(int j = column ; j <= column + width ; j++){
                if( inRange(i,j) && arr2D[i][j] > 0){
                    output++;
                }
                else{
                    return -1;
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int maxVal = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                for(int k = 0 ; k < n ; k++){
                    for(int h = 0 ; h < m ; h++){
                        maxVal = Math.max(maxVal, satisfiedRect(i, j, k, h));
                    }
                }
            }
        }

        System.out.println(maxVal);
    }
}