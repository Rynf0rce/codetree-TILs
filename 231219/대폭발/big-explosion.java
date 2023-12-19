import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static int range;

    public static boolean[][] arr2D = new boolean[MAX_RANGE][MAX_RANGE];
    public static boolean[][] temp2D = new boolean[MAX_RANGE][MAX_RANGE];
    public static int[] arrR = new int[]{-1, 0, 1, 0};
    public static int[] arrC = new int[]{0, 1, 0, -1};

    public static boolean inRange(int row, int column){
        return (row >= 0 && column >= 0 && row < range && column < range);
    }

    public static void bomb(int time){
        int distance = (int) Math.pow(2, time - 1);

        for(int i = 0 ; i < range ; i++){
            for(int j = 0 ; j < range ;j++){
                temp2D[i][j] = false;
            }
        }

        for(int i = 0 ; i < range ; i++){
            for(int j = 0 ; j < range ; j++){
                if(arr2D[i][j]){
                    temp2D[i][j] = true;
                    for(int k = 0 ; k < 4; k++){
                        if(inRange(i + arrR[k] * distance, j + arrC[k] * distance)){
                            temp2D[i + arrR[k] * distance][j + arrC[k] * distance] = true;
                        }
                    }
                }
            }
        }

        for(int i = 0 ; i < range ; i++){
            for(int j = 0 ; j < range ;j++){
                arr2D[i][j] = temp2D[i][j];
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), r = sc.nextInt() - 1, c = sc.nextInt() - 1;
        range = n;
        arr2D[r][c] = true;
        for(int i = 1; i <= m ; i++){
            bomb(i);
        }

        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(arr2D[i][j]){
                    cnt++;
                }
            }
        }

        System.out.print(cnt);
    }
}