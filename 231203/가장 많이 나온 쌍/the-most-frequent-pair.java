import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr2D = new int[m][2];
        for(int i = 0; i < arr2D.length ; i++){
            arr2D[i][0] = sc.nextInt();
            arr2D[i][1] = sc.nextInt();
        }

        int maxVal = Integer.MIN_VALUE;
        for(int i = 1 ; i <= n ; i++){
            for(int j = i + 1 ; j <= n ; j++){
                int cnt = 0;
                for(int k = 0 ; k < arr2D.length ; k++){
                    if((arr2D[k][0] == i && arr2D[k][1] == j) || (arr2D[k][0] == j && arr2D[k][1] == i)){
                        cnt++;
                    }
                }
                maxVal = Math.max(maxVal , cnt);
            }
        }
        System.out.println(maxVal);
    }
}