import java.util.*;

public class Main {
    public static int[][] arr2D;
    public static int RSP(int rock, int scissors, int paper){
        int cnt = 0;
        for(int i = 0 ; i < arr2D.length ; i++){
            if(arr2D[i][0] == rock && arr2D[i][1] == scissors){
                cnt++;
            }
            else if(arr2D[i][0] == scissors && arr2D[i][1] == paper){
                cnt++;
            }
            else if(arr2D[i][0] == paper && arr2D[i][1] == rock){
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), maxVal = Integer.MIN_VALUE;
        arr2D = new int[num][2];
        for(int i = 0 ; i < arr2D.length ; i++){
            arr2D[i][0] = sc.nextInt();
            arr2D[i][1] = sc.nextInt();
        }

        for(int i = 1 ; i <= 3 ; i++){
            for(int j = 1 ; j <= 3 ; j++){
                for(int k = 1 ; k <= 3 ; k++){
                    if(i == j || j == k || k == i){
                        continue;
                    }
                    maxVal = Math.max(maxVal, RSP(i,j,k));
                }
            }
        }
        System.out.println(maxVal);
    }
}