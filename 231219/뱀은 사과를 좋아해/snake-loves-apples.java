import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static final int MAX_TIME = 10000;
    public static final int ASCII_NUM = 128;
    public static boolean[][] apple2D = new boolean[MAX_RANGE][MAX_RANGE];
    public static int[][] current2D = new int[MAX_RANGE][MAX_RANGE];
    public static int[] dirMapper = new int[ASCII_NUM];
    public static int[] arrR = new int[]{-1, 0, 1, 0};
    public static int[] arrC = new int[]{0, 1, 0, -1};
    public static int range;
    public static int length = 1;

    public static boolean inRange(int row, int column){
        return (row >= 0 && column >= 0 && row < range && column < range);
    }

    public static boolean move(int row, int column, int idx){

        if(inRange(row + arrR[idx], column + arrC[idx]) && apple2D[row + arrR[idx]][column + arrC[idx]]){
            apple2D[row + arrR[idx]][column + arrC[idx]] = false;
            length ++;
        }
        else{
            for(int i = 0 ; i < range ; i++){
                for(int j = 0 ; j < range ; j++){
                    if(current2D[i][j] > 0){
                        current2D[i][j]--;
                    }
                }
            }
        }

        current2D[row][column] = length - 1;

        if(!inRange(row + arrR[idx], column + arrC[idx]) || current2D[row + arrR[idx]][column + arrC[idx]] > 0){
            return false;
        }
        else{
            current2D[row + arrR[idx]][column + arrC[idx]] = MAX_TIME;
        }

        

        

        // System.out.println(length);

        // for(int i = 0 ; i < range ; i++){
        //     for(int j = 0 ; j < range ; j++){
        //         System.out.print(current2D[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 격자 크기, 사과 수, 이동 횟수
        int N = sc.nextInt(), M = sc.nextInt(), K = sc.nextInt();
        range = N;

        for(int i = 0 ; i < M ; i++){
            int ir = sc.nextInt();
            int ic = sc.nextInt();
            apple2D[ir - 1][ic - 1] = true;
        }
        
        int r = 0, c = 0;

        dirMapper['U'] = 0;
        dirMapper['R'] = 1;
        dirMapper['D'] = 2;
        dirMapper['L'] = 3;


        int cnt = 0;
        for(int i = 0 ; i < K ; i++){
            char dir = sc.next().charAt(0);
            int dis = sc.nextInt();
            for(int j = 0 ; j < dis ; j++){
                cnt++;
                if(move(r, c, dirMapper[dir])){
                    r += arrR[dirMapper[dir]];
                    c += arrC[dirMapper[dir]];
                }
                else{
                    System.out.print(cnt);
                    System.exit(0);
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}