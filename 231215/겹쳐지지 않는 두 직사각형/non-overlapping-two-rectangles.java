import java.util.*;

public class Main {
    public static final int MAX_EDGE = 5;
    public static int[][] arr2D = new int[MAX_EDGE][MAX_EDGE];
    public static int areaValue(int row, int column, int height, int width){
        int output = 0;
        for(int i = row ; i < row + height ; i++){
            for(int j = column ; j < column + width ; j++){
                if(i < 0 || j < 0 || i >= MAX_EDGE || j >= MAX_EDGE){
                    return Integer.MIN_VALUE;
                }
                output += arr2D[i][j];
            }
        }
        return output;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), maxVal = Integer.MIN_VALUE, output = 0;
        int[] selectArea = new int[4];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                for(int k = 1 ; k < n ; k++){
                    for(int h = 1 ; h < m ; h++){
                        if(maxVal <= areaValue(i,j,k,h)){
                            maxVal = areaValue(i,j,k,h);
                            selectArea[0] = i;
                            selectArea[1] = j;
                            selectArea[2] = i + k - 1;
                            selectArea[3] = j + h - 1;
                        }
                    }
                }
            }
        }

        output += maxVal;
        maxVal = Integer.MIN_VALUE;

        for(int i = selectArea[0] ; i <= selectArea[2] ; i++){
            for(int j = selectArea[1] ; j <= selectArea[3] ; j++){
                arr2D[i][j] = MAX_EDGE * MAX_EDGE * -1000;
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                for(int k = 1 ; k <= n ; k++){
                    for(int h = 1 ; h <= m ; h++){
                        if(maxVal <= areaValue(i,j,k,h)){
                            maxVal = areaValue(i,j,k,h);
                        }
                    }
                }
            }
        }
        output += maxVal;
        System.out.println(output);
    }
}