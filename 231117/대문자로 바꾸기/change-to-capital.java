import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr2d = new int[5][3];
        for(int i = 0; i < arr2d.length ; i++){
            for(int j = 0 ; j < arr2d[i].length ; j++ ){
                arr2d[i][j] = (int)sc.next().charAt(0) - 32;
                System.out.printf("%c " ,(char)arr2d[i][j] );
            }
            System.out.println();
        }
    }
}