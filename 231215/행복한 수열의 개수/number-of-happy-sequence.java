import java.util.*;

public class Main {
    public static final int EDGE = 100;
    public static int[][] arr2D = new int[EDGE][EDGE];
    public static boolean happySequence(int idx, int range, int condition, boolean direction){
        int num = -1, cnt = 0;
        if(direction){
            for(int i = 0 ; i < range ; i++){
                if(num == arr2D[i][idx]){
                    cnt++;
                }
                else{
                    num = arr2D[i][idx];
                    cnt = 1;
                }
                
                if(cnt >= condition){
                    return true;
                }
            }
        }
        else{
            for(int i = 0 ; i < range ; i++){
                if(num == arr2D[idx][i]){
                    cnt++;
                }
                else{
                    num = arr2D[idx][i];
                    cnt = 1;
                }
                
                if(cnt >= condition){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), cnt = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < 2*n ; i++){
            if(i < n && happySequence(i, n, m, true)){
                cnt++;
            }
            else if(i >= n && happySequence(i%n, n, m, false)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}