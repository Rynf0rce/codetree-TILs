import java.util.*;

public class Main {
    public static final int MAX_RANGE = 20;
    public static int[][] arr2D = new int[MAX_RANGE][MAX_RANGE];
    public static boolean inRange(int x, int y, int range){
        if(x < 0 || y < 0 || x >= range || y >= range){
            return false;
        }
        return true;
    }

    public static int currentValue(int row, int column, int range){
        int tempRow = row, tempColumn = column, cnt_1 = 0, cnt_2 = 0, maxVal = 0;
        int[] arrRow = new int[]{1, 1, -1, -1};
        int[] arrColumn = new int[]{-1, 1, 1, -1};
        
        for(int i = 1 ; i < range ; i++){

            if(inRange(tempRow + arrRow[0] * i, tempColumn + arrColumn[0] * i, range)){
                cnt_1 = i;
            }
            else{
                break;
            }
            for(int j = 1 ; j < range ; j++){
                int output = 0;
                if(inRange(tempRow + arrRow[0] * i + arrRow[1] * j, tempColumn + arrColumn[0] * i + arrColumn[1] * j, range)){
                    cnt_2 = j;
                }
                else{
                    break;
                }

                int calRow = row, calColumn = column;

                for(int k = 0 ; k < 4 ; k++){
                    if(k % 2 == 0){
                        for(int h = 1 ; h <= cnt_1 ; h++){
                            calRow += arrRow[k];
                            calColumn += arrColumn[k];
                            output += arr2D[calRow][calColumn];
                        }
                    }
                    else{
                        for(int h = 1 ; h <= cnt_2 ; h++){
                            calRow += arrRow[k];
                            calColumn += arrColumn[k];
                            output += arr2D[calRow][calColumn];
                        }  
                    }
                }
                maxVal = Math.max(maxVal, output);
                // System.out.println(output);
            }
        }
        return maxVal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), maxVal = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                maxVal = Math.max(maxVal, currentValue(i, j, n));
            }
        }
        System.out.println(maxVal);
    }
}