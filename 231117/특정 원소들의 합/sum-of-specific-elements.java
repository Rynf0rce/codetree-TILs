import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr2D = new int[4][4];
        int sum = 0;
        for(int i = 0; i < arr2D.length ; i++){
            for(int j = 0; j < arr2D[i].length ; j++){
                arr2D[i][j] = sc.nextInt();
                if(i >= j){
                    sum += arr2D[i][j];
                }
            }
        }
        System.out.print(sum);
    }
}