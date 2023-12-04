import java.util.*;

public class Main {
    public static final int NUM_OF_PIGEON = 10;
    public static int[][] arr2D;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), cnt = 0;
        arr2D = new int[N][2];
        for(int i = 0 ; i < arr2D.length ; i++){
            arr2D[i][0] = sc.nextInt();
            arr2D[i][1] = sc.nextInt();
        }

        for(int i = 1 ; i <= NUM_OF_PIGEON ; i++){
            int location = -1;
            for(int j = 0 ; j < arr2D.length ; j++){
                if(arr2D[j][0] == i){
                    if(location == -1){
                        location = arr2D[j][1];
                    }
                    else if(location != arr2D[j][1]){
                        location = arr2D[j][1];
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}