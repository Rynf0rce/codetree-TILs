import java.util.*;

public class Main {
    public static int[][] arr2D;

    public static boolean chackWin(int side, int row, int column){
        int cnt = 0;
        // 범위 체크
        if(row >= 0 && column >= 2 && row < arr2D.length && column < arr2D.length -2){
            // 행.
            for(int i = -2 ; i <= 2; i++){
                if(arr2D[row][column+i] == side){
                    cnt++;
                }
            }
            if(cnt == 5){
                return true;
            }
        }

        if(row >= 2 && column >= 0 && row < arr2D.length -2 && column < arr2D.length){
            cnt = 0;
            // 렬.
            for(int i = -2 ; i <= 2; i++){
                if(arr2D[row + i][column] == side){
                    cnt++;
                }
            }
            if(cnt == 5){
                return true;
            }
        }

        if(row >= 2 && column >= 2 && row < arr2D.length -2 && column < arr2D.length -2){

            cnt = 0;
            // 우상향 대각.
            for(int i = -2 ; i <= 2; i++){
                if(arr2D[row - i][column + i] == side){
                    cnt++;
                }
            }
            if(cnt == 5){
                return true;
            }

            cnt = 0;
            // 좌하향 대각.
            for(int i = -2 ; i <= 2; i++){
                if(arr2D[row + i][column + i] == side){
                    cnt++;
                }
            }
            if(cnt == 5){
                return true;
            }
        }
        return false;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr2D = new int[19][19];
        for(int i = 0 ; i < arr2D.length ; i++){
            for(int j = 0 ; j < arr2D[i].length ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }
        boolean triger = true;
        for(int i = 0 ; i < arr2D.length ; i++){
            for(int j = 0 ; j < arr2D[i].length ; j++){
                if(arr2D[i][j] != 0 && chackWin( arr2D[i][j],  i,  j)){
                    System.out.println(arr2D[i][j]);
                    System.out.println((i+1) + " " + (j+1));
                    triger = false;
                    break;
                }
            }
        }
        if(triger){
            System.out.println(0);
        }
    }
}
// x,y 좌표계로 푸는법

import java.util.Scanner;

public class Main {
    public static final int DIR_NUM = 8;
    
    public static int[][] arr = new int[19][19];
    
    public static int[] dx = new int[]{1, 1, 1, -1, -1, -1, 0, 0};
    public static int[] dy = new int[]{-1, 0, 1, -1, 0, 1, -1, 1};
    
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < 19 && 0 <= y && y < 19;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        for(int i = 0; i < 19; i++)
            for(int j = 0; j < 19; j++)
                arr[i][j] = sc.nextInt();
        
        // 모든 좌표에서 다 확인해봅니다.
        for(int i = 0; i < 19; i++) {
            // 격자를 벗어나지 않을 범위로만 잡습니다.
            for(int j = 0; j < 19; j++) {
                if(arr[i][j] == 0) continue;
                
                for(int k = 0; k < DIR_NUM; k++) {
                    int curt = 1;
                    int curx = i;
                    int cury = j;
                    while(true) {
                        int nx = curx + dx[k];
                        int ny = cury + dy[k];
                        if(inRange(nx, ny) == false)
                            break;
                        if(arr[nx][ny] != arr[i][j])
                           break;
                        curt++;
                        curx = nx;
                        cury = ny;
                    }
                    if(curt == 5) {
                        System.out.println(arr[i][j]);
                        System.out.print((i + 2 * dx[k] + 1) + " " + (j + 2 * dy[k] + 1));
                        System.exit(0);
                    }
                }
            }
        }
        System.out.print(0);
    }
}
