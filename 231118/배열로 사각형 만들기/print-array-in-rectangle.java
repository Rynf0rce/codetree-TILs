import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] arr2d = new int[5][5];
        for(int i = 0 ; i < arr2d.length ; i++){
            for(int j = 0 ; j < arr2d.length ; j++){
                if(i == 0 || j == 0){
                    arr2d[i][j] = 1;
                }
                else{
                    arr2d[i][j] = arr2d[i-1][j] + arr2d[i][j-1];
                }
                System.out.print(arr2d[i][j] + " " );
            }
            System.out.println();
        }

    }
}