import java.util.*;

public class Main {
    public static int currentX;
    public static int currentY;
    public static int cnt = 1;
    public static int[][] arr2D;
    public static int[] arrRow = new int[]{-1, 0, 1, 0}; // 북동남서 (남 동 북 서 순.)
    public static int[] arrColumn = new int[]{0, 1, 0, -1}; 

    public static void conFnc(int startRow, int startColumn, int direction){
        
       
        arr2D[startRow][startColumn] = 1;
        cnt++;
        int chack = 0;

        while(cnt <= arr2D.length * arr2D[0].length){
            int tempRow = startRow + arrRow[direction];
            int tempColumn = startColumn + arrColumn[direction];
            if(inRange(tempRow, tempColumn)){
                arr2D[tempRow][tempColumn] = cnt;
                startRow = tempRow;
                startColumn = tempColumn;
                cnt++;
                chack = 0;
            }

            if(chackCorner(tempRow, tempColumn)){
                direction--;
                if(direction < 0){
                    direction = 3;
                }
            }
        }

        for(int i = 0; i < arr2D.length ; i++){
            for(int j = 0 ; j < arr2D[i].length ; j++){
                System.out.print(arr2D[i][j] + " ");
            }
            System.out.println();
        }
    }

    
    public static boolean inRange(int row, int column){
        if(row >= 0 && column >= 0 && row < arr2D.length && column < arr2D[0].length){
            return true;
        }
        return false;
    }

    public static boolean chackCorner(int row, int column){
        int cnt = 0;
        for(int i = 0 ; i < arrRow.length ; i++){
            int tempRow = row + arrRow[i];
            int tempColumn = column + arrColumn[i];
            if( !inRange(tempRow,tempColumn) || (inRange(tempRow, tempColumn) && arr2D[tempRow][tempColumn] == 0 )){
                cnt++;
            }
        }
        if(cnt == 3){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edge = sc.nextInt();
        // edge = 7;
        arr2D = new int[edge][edge];
        conFnc((edge/2), (edge / 2), 1);
    }
}