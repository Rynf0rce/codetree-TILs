import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr2D = new int[N][2];
        for(int i = 0 ; i < arr2D.length ; i++){
            arr2D[i][0] = sc.nextInt();
            arr2D[i][1] = sc.nextInt();
        }
        
        int minDistance = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr2D.length ; i++){
            int minX1 = Integer.MAX_VALUE;
            int maxX2 = Integer.MIN_VALUE;
            for(int j = 0 ; j < arr2D.length ; j++){
                if(i == j){
                    continue;
                }
                minX1 = Math.min(minX1, arr2D[j][0]);
                maxX2 = Math.max(maxX2, arr2D[j][1]);
            }
            minDistance = Math.min(minDistance, maxX2 - minX1);
        }
        System.out.println(minDistance);
    }
}