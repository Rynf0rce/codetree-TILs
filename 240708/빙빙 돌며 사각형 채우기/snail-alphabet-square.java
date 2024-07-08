import java.util.*;

public class Main {
    public static int currentX;
    public static int currentY;
    public static char cnt = 'A';
    public static char[][] arr2D;

    public static void conFnc(int startRow, int startColumn, int direction){
        int[] arrRow = new int[]{-1, 0, 1, 0}; // 북동남서 (남 동 북 서 순.)
        int[] arrColumn = new int[]{0, 1, 0, -1}; 
       
        arr2D[startRow][startColumn] = cnt;
        cnt++;
        int chack = 0;

        while(true){
            int tempRow = startRow + arrRow[direction];
            int tempColumn = startColumn + arrColumn[direction];
            if(inRange(tempRow, tempColumn)){
                arr2D[tempRow][tempColumn] = cnt;
                startRow = tempRow;
                startColumn = tempColumn;
                cnt++;
                if(cnt == 'Z' + 1){
                    cnt = 'A';
                }
                chack = 0;
            }
            else{
                direction--;
                if(direction < 0){
                    direction = 3;
                }
                chack++;
                if(chack ==4){
                    break;
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
        if(row >= 0 && column >= 0 && row < arr2D.length && column < arr2D[0].length && arr2D[row][column] == '0'){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt(), column = sc.nextInt();
        arr2D = new char[row][column];
        for(int i = 0 ; i < arr2D.length ; i++){
            Arrays.fill(arr2D[i], '0');
        }
        conFnc(0, 0, 1);
    }
}