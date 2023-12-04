import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr2D = new int[n][2];
        for(int i = 0 ; i < arr2D.length ; i++){
            arr2D[i][0] = sc.nextInt();
            arr2D[i][1] = sc.nextInt();
        }
        boolean output = false;  
        for(int i = 0 ; i < arr2D.length ; i++){
            int frontMax = Integer.MIN_VALUE, behindMin = Integer.MAX_VALUE;
            for(int j = 0 ; j < arr2D.length ; j++){
                if(i == j){
                    continue;
                }
                frontMax = Math.max(frontMax, arr2D[j][0]);
                behindMin = Math.min(behindMin, arr2D[j][1]);
            }

            if(frontMax <= behindMin){
                output = true;
                break;
            }
        }
        System.out.println(output ? "Yes" : "No");
    }
}