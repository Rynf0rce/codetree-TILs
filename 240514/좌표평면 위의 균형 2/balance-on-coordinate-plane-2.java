import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr2D = new int[N][2];
        for(int i = 0 ; i < arr2D.length ; i++){
            for(int j = 0 ; j < arr2D[i].length ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }
        int minOfMAX = Integer.MAX_VALUE;
        for(int i = 2 ; i <= MAX_RANGE ; i += 2){
            for(int j = 2 ; j <= MAX_RANGE ; j += 2){
                int area_1 = 0, area_2 = 0, area_3 = 0, area_4 = 0, maxPoint = 0;
                for(int k = 0 ; k < arr2D.length ; k++){
                    if(arr2D[k][0] > i){
                        if(arr2D[k][1] > j){
                            area_1++;
                        }
                        else{
                            area_4++;
                        }
                    }
                    else{
                        if(arr2D[k][1] > j){
                            area_2++;
                        }
                        else{
                            area_3++;
                        }
                    }
                }
                maxPoint = Math.max(Math.max(area_1,area_2), Math.max(area_3,area_4));
                minOfMAX = Math.min(minOfMAX, maxPoint);
            }
        }
        System.out.print(minOfMAX);
    }
}