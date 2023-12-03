import java.util.*;

public class Main {
    public static final int MAX_RANGE = 10000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr2D = new int[n][2];
        for(int i = 0; i < arr2D.length ; i++){
            arr2D[i][0] = sc.nextInt();
            arr2D[i][1] = sc.nextInt();
        }

        int minVal = 0;
        for(int i = 1 ; i <= MAX_RANGE ; i++){
            int currentVal = i;
            int cnt = 0;
            for(int j = 0 ; j < arr2D.length ;j++){
                currentVal *= 2;
                if(currentVal < arr2D[j][0] || currentVal > arr2D[j][1]){
                    break;
                }
                cnt++;
            }
            if(cnt == arr2D.length){
                minVal = i;
                break;
            }
        }
        System.out.print(minVal);
    }
}