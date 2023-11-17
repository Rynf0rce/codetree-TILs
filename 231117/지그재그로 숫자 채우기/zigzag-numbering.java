import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), num = 0;
        int[][] arr2d = new int[n][m];
        
        for(int j = 0 ; j < arr2d[0].length ; j++){
            if(j % 2 == 0){
                for(int i = 0 ; i < arr2d.length ; i++){
                    arr2d[i][j] = num;
                    num++;
                }
            }
            else{
                for(int i = arr2d.length - 1 ; i >= 0 ; i--){
                    arr2d[i][j] = num;
                    num++;
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