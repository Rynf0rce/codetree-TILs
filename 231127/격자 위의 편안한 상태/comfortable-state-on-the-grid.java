import java.util.*;

public class Main {
    public static boolean inRange(int[][] arr2D, int row, int column){
        if(row >= 1 && row < arr2D.length && column >= 1 && column < arr2D[0].length){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean conFnc(int[][] arr2D, int row, int column){
        int[] arrRow = {-1, 0, 1, 0};
        int[] arrColumn = {0, 1, 0, -1};
        int cnt = 0;
        for(int i = 0 ; i < arrRow.length ; i++){
            int tempRow = row + arrRow[i];
            int tempColumn = column + arrColumn[i];
            if(inRange(arr2D, tempRow, tempColumn) && arr2D[tempRow][tempColumn] == 1){
                cnt++;
            }
        }
        return cnt == 3 ? true : false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edge = sc.nextInt(), num = sc.nextInt();
        int[][] arr2D = new int[edge+1][edge+1];
        for(int i = 0 ; i < num ; i++){
            int row = sc.nextInt();
            int column = sc.nextInt();
            arr2D[row][column] = 1;
            System.out.println(conFnc(arr2D, row, column) ? 1 : 0 );
        }
    }
}