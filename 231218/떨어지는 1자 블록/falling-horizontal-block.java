import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static int[][] arr2D = new int[MAX_RANGE][MAX_RANGE];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), width = sc.nextInt(), column = sc.nextInt() - 1;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }

        int idx = 0;
        for(int i = 0 ; i < n ; i++){
            int cnt = width;
            for(int j = column ; j < column + width; j++){
                if(arr2D[i][j] == 0){
                    cnt--;
                }
                else{
                    idx = i - 1;
                    break;
                }
            }

            if(cnt != 0){
                for(int j = column ; j < column + width ; j++){
                    arr2D[idx][j]++;
                }
                break;
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(arr2D[i][j] + " ");
            }
            System.out.println();
        }
    }
}