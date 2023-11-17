import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), num = 1;
        int[][] arr2d = new int[n][m];
        for(int i = 0 ; i < n + m ; i++){
            for(int row = 0 ; row < n ; row++){
                for(int column = 0 ; column < m ; column++){
                    if(row + column == i){
                        arr2d[row][column] = num;
                        num++;
                        break;
                    }
                }
            }
        }

        for(int i = 0 ; i < arr2d.length ; i++){
            for(int j = 0 ; j < arr2d[i].length ; j++){
                System.out.print(arr2d[i][j] + " ");
            }
            System.out.println();
        }
    }
}