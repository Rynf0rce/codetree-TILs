import java.util.*;

class range{
    int min;
    int max;

    public range(int min, int max){
        this.min = min;
        this.max = max;
    }

    public int width(){
        return max - min;
    }
}

public class Main {
    public static final int MAX_RANGE = 100;
    public static int[][] table = new int[MAX_RANGE][MAX_RANGE];
    public static range[][] DP = new range[MAX_RANGE][MAX_RANGE];
    public static int n;

    public static range calRange(range preRange, int row, int col){
        int value = table[row][col];
        int min = preRange.min;
        int max = preRange.max;
        if(value > max){
            return new range(min, value);
        }
        else if(value < min){
            return new range(value, max);
        }
        else{
            return preRange;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                table[i][j] = sc.nextInt();
            }
        }

        DP[0][0] = new range(table[0][0], table[0][0]);

        for(int i = 1 ; i < n ; i++){
            DP[0][i] = calRange(DP[0][i-1], 0, i);
        }

        for(int i = 1 ; i < n ; i++){
            DP[i][0] = calRange(DP[i-1][0], i, 0);
        }

        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j < n ; j++){
                range upRange = calRange(DP[i - 1][j], i, j);
                range rigthRange = calRange(DP[i][j - 1], i, j);

                if(upRange.width() < rigthRange.width()){
                    DP[i][j] = upRange;
                }
                else{
                    DP[i][j] = rigthRange;
                }
            }
        }

        System.out.print(DP[n - 1][n - 1].width());
    }
}