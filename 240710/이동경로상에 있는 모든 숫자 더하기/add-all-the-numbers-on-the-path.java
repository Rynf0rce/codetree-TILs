import java.util.*;

public class Main {
    public static int[][] arr2D;
    public static int direction = 0;
    public static int row;
    public static int column;
    public static int sum = 0;
    public static final int[] arrRow = new int[]{-1, 0, 1, 0};
    public static final int[] arrColumn = new int[]{0, 1, 0, -1};
    

    public static boolean inRange(int row, int column){
        if(row >= 0 && column >= 0 && row < arr2D.length && column < arr2D.length){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edge = sc.nextInt(), order = sc.nextInt();
        row = edge / 2;
        column = edge / 2;
        String str = sc.next();
        char[] orderArr = str.toCharArray();
        arr2D = new int[edge][edge];
        for(int i = 0 ; i < edge ; i++){
            for(int j = 0 ; j < edge ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }

        sum += arr2D[row][column];

        for(int i = 0; i < orderArr.length ; i++){
            if(orderArr[i] == 'R'){
                direction = ( direction + 1 ) % 4;
            }
            else if(orderArr[i] == 'L'){
                direction--;
                if(direction < 0){
                    direction = 3;
                }
            }
            else{
                if(inRange(row + arrRow[direction], column + arrColumn[direction])){
                    row += arrRow[direction];
                    column += arrColumn[direction];
                    sum += arr2D[row][column];
                    // System.out.println("sum : " + sum + " add value : " + arr2D[row][column]);
                }         
            }
        }
        System.out.println(sum);
    }
}