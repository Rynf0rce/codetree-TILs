import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static int[][] arr2D = new int[MAX_RANGE + 1][MAX_RANGE + 1];
    public static int[] arrRow = new int[]{1, 0, -1, 0};
    public static int[] arrColumn = new int[]{0, 1, 0, -1};
    public static int N;
    public static int M;
    public static void spinMatrix(int r1, int c1, int r2, int c2){
        int k = 0;
        int rowIdx = r1, columnIdx = c1, temp = arr2D[r1][c1];
        while(k < arrRow.length){
            int tempRowIdx = rowIdx + arrRow[k], tempColumnIdx = columnIdx + arrColumn[k];
            if(tempRowIdx >= r1 && tempRowIdx <= r2 && tempColumnIdx >= c1 && tempColumnIdx <= c2){
                if(tempRowIdx == r1 && tempColumnIdx == c1){
                    arr2D[rowIdx][columnIdx] = temp;
                    break;
                }
                else{
                    arr2D[rowIdx][columnIdx] = arr2D[tempRowIdx][tempColumnIdx];
                    rowIdx = tempRowIdx;
                    columnIdx = tempColumnIdx;
                }
            }
            else{
                k++;
            }
        }
    }

    public static boolean inRange(int row, int column){
        if(row < 1 || column < 1 || row >= N + 1 || column >= M + 1){
            return false;
        }
        return true;
    }
    
    public static int averageVal(int row, int column){
        int cnt = 1, value = arr2D[row][column];
        for(int i = 0 ; i < arrRow.length ; i++){
            if(inRange(row + arrRow[i], column + arrColumn[i])){
                cnt++;
                value += arr2D[row + arrRow[i]][column + arrColumn[i]];
            }
        }
        return value / cnt;
    }

    public static void conFnc(int r1, int c1, int r2, int c2){
        spinMatrix(r1, c1, r2, c2);
        int[][] temparr = new int[N + 1][M + 1];
        for(int i = r1 ; i <= r2 ; i++){
            for(int j = c1 ; j <= c2 ; j++){
                temparr[i][j] = averageVal(i, j);
            }
        }

        for(int i = r1 ; i <= r2 ; i++){
            for(int j = c1 ; j <= c2 ; j++){
                arr2D[i][j] = temparr[i][j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); 
        M = sc.nextInt();
        int Q = sc.nextInt();
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= M ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < Q ; i++){
            int r1 = sc.nextInt(), c1 = sc.nextInt(), r2 = sc.nextInt(), c2 = sc.nextInt();
            conFnc(r1, c1, r2, c2);
        }

        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= M ; j++){
                System.out.print(arr2D[i][j] + " ");
            }
            System.out.println();
        }
    }
}