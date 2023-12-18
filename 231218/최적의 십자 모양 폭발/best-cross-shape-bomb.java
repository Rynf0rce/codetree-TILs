import java.util.*;

public class Main {
    public static final int MAX_RANGE = 50;
    public static int size;

    public static int[][] area = new int[MAX_RANGE][MAX_RANGE];
    public static int[] arrR = new int[]{-1, 0, 1, 0};
    public static int[] arrC = new int[]{0, 1, 0, -1};
    
    public static boolean inRange(int row, int column){
        return (row >= 0 && column >= 0 && row < size  && column < size);
    }
    public static void gravity(int[][] arr2D){
        int[][] temp = new int[MAX_RANGE][MAX_RANGE];
        for(int i = 0 ; i < size ; i++){
            int tempIdx = size - 1;
            for(int j = size - 1; j >= 0 ; j--){
                if(arr2D[j][i] != 0){
                    temp[tempIdx--][i] = arr2D[j][i];
                }
            }
        }

        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                arr2D[i][j] = temp[i][j];
            }
        }
    }
    public static void boom(int[][] arr2D, int row, int column){
        int origin = arr2D[row][column];
        arr2D[row][column] = 0;
        int cnt = origin - 1;
        for(int i = 0 ; i < arrR.length ; i++){
            int curRow = row;
            int curCol = column;
            for(int j = 1 ; j <= cnt ; j++){
                curRow += arrR[i];
                curCol += arrC[i];
                if(inRange(curRow, curCol)){
                    arr2D[curRow][curCol] = 0;
                }
            }
        }
    }
    
    public static int conFnc(int row, int column){
        int[][] arr2D = new int[MAX_RANGE][MAX_RANGE];
        int output = 0;
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                arr2D[i][j] = area[i][j];
            }
        }

        boom(arr2D, row, column);
        gravity(arr2D);

        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                if(arr2D[i][j] == 0){
                    continue;
                }

                if( inRange(i+1, j) && arr2D[i][j] == arr2D[i+1][j] ){
                    output++;
                }

                if( inRange(i, j+1) && arr2D[i][j] == arr2D[i][j+1]){
                    output++;
                }
            }
        }
        
        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        int maxVal = 0;

        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                area[i][j] = sc.nextInt();
            }
        }
        
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                maxVal = Math.max(maxVal, conFnc(i, j));
            }
        }

        System.out.println(maxVal);

    }
}