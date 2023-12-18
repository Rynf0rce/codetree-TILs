import java.util.*;

public class Main {
    public static final int MAX_RANGE = 200;
    public static int[][] area = new int[MAX_RANGE][MAX_RANGE];
    public static boolean inRange (int r, int c, int n){
        return (r >= 0 && c >= 0 && r < n && c < n);
    }

    public static void bomb(int r, int c, int n){
        int[] arrR = new int[]{-1, 0, 1, 0};
        int[] arrC = new int[]{0, 1, 0, -1};
        for(int i = 0 ; i < arrR.length ; i++){
            int cnt = area[r][c] - 1;
            int row = r;
            int column = c;
            while(cnt-- > 0){
                row += arrR[i];
                column += arrC[i];
                if(inRange(row,column, n)){
                    area[row][column] = 0;
                }
                else{
                    break;
                }
            }
        }
        area[r][c] = 0;
    }

    public static void graivity(int n){
        int[][] temp = new int[n][n];
        for(int i = 0 ; i < n ; i ++){
            int idx = n - 1;
            for(int j = n - 1 ; j >= 0 ; j--){
                if(area[j][i] != 0){
                    temp[idx--][i] = area[j][i];
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                area[i][j] = temp[i][j];
            }
        }
    }

    public static void conFnc(int row, int column, int range){
        bomb(row, column, range);
        graivity(range);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                area[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < m ; i++){
            int c = sc.nextInt();
            int idx = -1;
            for(int j = 0 ; j < n ; j++){
                if(area[j][c-1] != 0){
                    conFnc(j, c-1, n);
                    break;
                }
            }
        }
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(area[i][j] + " ");
            }
            System.out.println();
        }
    }
}