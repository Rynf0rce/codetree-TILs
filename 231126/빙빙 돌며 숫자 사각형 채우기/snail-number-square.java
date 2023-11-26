import java.util.*;

public class Main {
    public static boolean inRange(int[][] arr2D, int row, int column){
        if(row >= 0 && row < arr2D.length && column >= 0 && column < arr2D[0].length && arr2D[row][column] <= 0){
            return true;
        }
        else{
            return false;
        }
    }

    public static void conFnc(int[][] arr2D, int sRow, int sColumn, int direction){
        int[] arrRow = new int[]{-1,0,1,0};
        int[] arrColumn = new int[]{0,1,0,-1}; // 북동남서 0123

        int currentRow = sRow;
        int currentColumn = sColumn;

        arr2D[currentRow][currentColumn] = 1;
        
        for(int i = 1 ; i < arr2D.length * arr2D[0].length ; i++){
            int cnt = 0;
            while(cnt < 4){
                int tempRow = currentRow + arrRow[direction];
                int tempColumn = currentColumn + arrColumn[direction];
                if(inRange(arr2D, tempRow, tempColumn)){
                    currentRow = tempRow;
                    currentColumn = tempColumn;
                    break;
                }
                else{
                    direction = (direction + 1) % 4;
                    cnt++;
                }
            }

            if(cnt >= 4){
                break;
            }
            else{
                arr2D[currentRow][currentColumn] = i + 1;
            }
        }

        for(int i = 0 ; i < arr2D.length ; i++){
            for(int j = 0 ; j < arr2D[i].length ; j++){
                System.out.print(arr2D[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt(), column = sc.nextInt();
        int[][] arr2D = new int[row][column];
        conFnc(arr2D, 0, 0, 1);
    }
}