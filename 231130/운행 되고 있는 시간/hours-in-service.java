import java.util.*;

public class Main {
    public static final int TIME_LENGTH = 101;
    public static boolean[] openArr = new boolean[TIME_LENGTH];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), cnt = 0;
        int[][] arr2D = new int[N][2];
        for(int i = 0 ; i < arr2D.length ; i++){
            arr2D[i][0] = sc.nextInt();
            arr2D[i][1] = sc.nextInt();
        }
        
        int maxVal = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr2D.length ; i++){
            Arrays.fill(openArr, false);
            cnt = 0;
            for(int j = 0 ; j < arr2D.length ; j++){
                if(j == i){
                    continue;
                }
                for(int k = arr2D[j][0] ; k < arr2D[j][1] ; k++){
                    openArr[k] = true;
                }
            }

            for(int k = 1 ; k < openArr.length ; k++){
                if(openArr[k] == true){
                    cnt++;
                }
            }
            maxVal = Math.max(maxVal, cnt);
        }
        System.out.println(maxVal);
    }
}