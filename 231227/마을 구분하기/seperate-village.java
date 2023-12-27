import java.util.*;

public class Main {
    public static final int MAX_RANGE = 25;
    public static final int GO_METHOD = 4;
    public static int[][] table = new int[MAX_RANGE][MAX_RANGE];
    public static boolean[][] visited = new boolean[MAX_RANGE][MAX_RANGE];
    public static int[] cntArr = new int[MAX_RANGE * MAX_RANGE];
    public static int[] arrR = new int[]{-1, 0, 1, 0};
    public static int[] arrC = new int[]{0, 1, 0, -1};
    public static int n;

    public static boolean inRange(int row, int col){
        return (row >= 0 && col >= 0 && row < n && col < n);
    }

    public static boolean seperate(int row, int col, int idx){
        if(!inRange(row, col) || visited[row][col]){
            return false;
        }

        visited[row][col] = true;
        cntArr[idx]++;
        
        for(int i = 0 ; i < GO_METHOD ; i++){
            int postRow = row + arrR[i];
            int postCol = col + arrC[i];
            if(inRange(postRow, postCol) && !visited[postRow][postCol]){
                seperate(postRow, postCol, idx);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                table[i][j] = sc.nextInt();
                if(table[i][j] == 0){
                    visited[i][j] = true;
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(seperate(i, j, cnt)){
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

        Arrays.sort(cntArr, 0, cnt);

        for(int i = 0 ; i < cnt ; i++){
            System.out.println(cntArr[i]);
        }

        
    }
}