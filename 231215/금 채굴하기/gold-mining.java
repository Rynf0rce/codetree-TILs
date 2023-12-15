import java.util.*;

public class Main {
    public static final int EDGE = 20;
    public static int[][] arr2D = new int[EDGE][EDGE];
    
    public static int diamond(int row, int column, int width){
        int cnt = 0;
        for(int i = row - width ; i <= row + width ; i++){
            for(int j = column - width ; j <= column + width ; j++){
                if( (i < 0) || (j < 0) || (i >= EDGE) || (j >= EDGE) || Math.abs(row - i) + Math.abs(column - j) > width){
                    continue;
                }

                if(arr2D[i][j] == 1){
                    cnt++;
                }
            }
        }

        return cnt;
    }
    
    public static int maxGold(int range, int cost){
        int maxVal = 0;
        for(int i = 0 ; i < range; i++){
            for(int j = 0 ; j < range; j++){
                for(int k = 0 ; k < range ; k++){
                    int gold = diamond(i,j,k);
                    if(gold * cost >= k*k + (k+1) * (k+1)){
                        maxVal = Math.max(maxVal, gold);
                    }
                }
            }
        }
        return maxVal;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), cost = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }

        System.out.println(maxGold(n,m));

    }
}