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