import java.util.*;
public class Main {
    public static final int MAX_LENGTH = 10;
    public static int[][] arr = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < n ; i += 2){
            for(int j = 0 ; j < n ; j++){
                arr[i][j] = 1;
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 1 ; j < n ; j += 2){
                arr[i][j] = 2;
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}