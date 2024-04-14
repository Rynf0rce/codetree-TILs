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
    
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, output = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE, square = 0;
        for(int i = 0 ; i < arr2D.length ; i++){
            square = 0;
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            maxX = Integer.MIN_VALUE;
            maxY = Integer.MIN_VALUE;
            for(int j = 0 ; j < arr2D.length ; j++){
                if(i != j){
                    maxX = Math.max(maxX, arr2D[j][0]);
                    minX = Math.min(minX, arr2D[j][0]);
                    maxY = Math.max(maxY, arr2D[j][1]);
                    minY = Math.min(minY, arr2D[j][1]);                
                }            
            }
            square = (maxX - minX) * (maxY - minY);
            output = Math.min(output, square);
        }
        System.out.println(output);
    }
}