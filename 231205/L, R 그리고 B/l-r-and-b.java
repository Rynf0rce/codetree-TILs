import java.util.*;

public class Main {
    public static final int WIDTH = 10;
    public static int[][] arr2D = new int[3][2];
    public static boolean inRange(int row, int column){
        if(row >= Math.min(arr2D[2][0], arr2D[0][0]) && row <= Math.max(arr2D[2][0], arr2D[0][0]) ){
            if(column >= Math.min(arr2D[2][1], arr2D[0][1]) && column <= Math.max(arr2D[2][1], arr2D[0][1]) ){
                return true;
            }   
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < WIDTH ; i++){
            String str = sc.next();
            for(int j = 0 ; j < WIDTH ; j++){
                if(str.charAt(j) == 'B'){
                    arr2D[0][0] = i;
                    arr2D[0][1] = j;
                }
                else if(str.charAt(j) == 'R'){
                    arr2D[1][0] = i;
                    arr2D[1][1] = j;
                }
                else if(str.charAt(j) == 'L'){
                    arr2D[2][0] = i;
                    arr2D[2][1] = j;
                }
            }
        }
        int widthRow = Math.abs(arr2D[2][0] - arr2D[0][0]), widthColumn = Math.abs(arr2D[2][1] - arr2D[0][1]);
        int distance = widthRow + widthColumn - 1;
        if(inRange(arr2D[1][0], arr2D[1][1]) && ((widthRow == 0 && arr2D[2][0] == arr2D[1][0]) || (widthColumn == 0 && arr2D[2][1] == arr2D[1][1]))){
            distance += 2;
        }
        System.out.print(distance);
    }
}