import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static int[][] arr2D = new int[MAX_RANGE + 1][MAX_RANGE + 1];
    public static int[] operRow = new int[]{-1, -1, 1, 1};
    public static int[] operColumn = new int[]{1, -1, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input
        int n = sc.nextInt();
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }


        // define condition
        int startRow = sc.nextInt(), startColumn = sc.nextInt();
        int[] conArr = new int[4];
        for(int i = 0 ; i < conArr.length ; i++){
            conArr[i] = sc.nextInt();
        }
        int dir = sc.nextInt();

        // test that point go along line defined by this problem
        // go to back track anticlockwise 1 -> 0 -> 3 -> 2
        // go to back track clockwise 0 -> 1 -> 2 -> 3
        int orgin = arr2D[startRow][startColumn];
        int[] anticlockwise = new int[]{1, 0, 3, 2};
        int currentRow = startRow, currentColumn = startColumn;

        // anticlockwise
         if(dir == 0){
            for(int i = 0 ; i < 4 ; i++){
                while(conArr[anticlockwise[i]]-- > 0){
                    int preRow = currentRow + operRow[anticlockwise[i]];
                    int preColumn = currentColumn + operColumn[anticlockwise[i]];

                    if(preRow == startRow && preColumn == startColumn){
                        arr2D[currentRow][currentColumn] = orgin;
                    }
                    else{
                        arr2D[currentRow][currentColumn] = arr2D[preRow][preColumn];
                    }
                    currentRow = preRow;
                    currentColumn = preColumn; 
                }
            }
        }
        // clockwise
        else{
            for(int i = 0 ; i < 4 ; i++){
                while(conArr[i]-- > 0){
                    int preRow = currentRow + operRow[i];
                    int preColumn = currentColumn + operColumn[i];
                    if(preRow == startRow && preColumn == startColumn){
                        arr2D[currentRow][currentColumn] = orgin;
                    }
                    else{
                        arr2D[currentRow][currentColumn] = arr2D[preRow][preColumn];
                    }
                    currentRow = preRow;
                    currentColumn = preColumn; 
                }
            }
        }

        // print operated output
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                System.out.print(arr2D[i][j] + " ");
            }
            System.out.println();
        }
    }
}