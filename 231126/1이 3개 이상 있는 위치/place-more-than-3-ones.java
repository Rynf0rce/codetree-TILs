import java.util.*;

public class Main {
    public static boolean judgeplay(int x_edge, int y_edge, int x, int y){
        if(x >= 0 && x < x_edge && y >= 0 && y < y_edge){
            return true;
        }
        else{
            return false;
        }
    }
    public static int conFnc(int[][] arr2D, int x, int y){
        int[] arrX = new int[]{0,1,0,-1};
        int[] arrY = new int[]{1,0,-1,0};
        int cnt = 0;
        for(int i = 0 ; i < arrX.length ; i++){
            int dx = x + arrX[i];
            int dy = y + arrY[i];
            if(judgeplay(arr2D.length, arr2D[0].length, dx,dy) && arr2D[dx][dy] == 1){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edge = sc.nextInt();
        int cnt = 0;
        int[][] arr2D = new int[edge][edge];
        for(int i = 0 ; i < arr2D.length ; i++){
            for(int j = 0 ; j < arr2D[i].length ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < arr2D.length ; i++){
            for(int j = 0 ; j < arr2D[i].length ; j++){
                if(conFnc(arr2D,i,j) >= 3){
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
}