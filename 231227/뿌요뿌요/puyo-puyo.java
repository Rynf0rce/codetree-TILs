import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static final int INPUT_RANGE = 100;
    public static final int MIN_NUM_OF_BOMB = 4;
    public static final int DIR_METHOD = 4;
    public static int[][] table = new int[MAX_RANGE][MAX_RANGE];
    public static boolean[][] visited = new boolean[MAX_RANGE][MAX_RANGE];
    public static int[] arrRow = new int[]{-1, 0, 1, 0};
    public static int[] arrCol = new int[]{0, 1, 0, -1};

    public static int maxBombNum = Integer.MIN_VALUE;
    public static int bombNum;
    public static int n;

    public static void clearVisited(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                visited[i][j] = false;
            }
        }
    }

    public static boolean inRange(int row, int col){
        return (row >= 0 && col >= 0 && row < n && col < n);
    }

    public static boolean canGo(int row, int col, int num){
        if(!inRange(row, col)){
            return false;
        }

        if(table[row][col] != num || visited[row][col]){
            return false;
        }

        return true;
    }

    public static void puyopuyo(int row, int col, int num){
        if(!canGo(row, col, num)){
            return;
        }

        visited[row][col] = true;
        bombNum++;

        for(int i = 0 ; i < DIR_METHOD ; i++){
            int postRow = row + arrRow[i];
            int postCol = col + arrCol[i];
            puyopuyo(postRow, postCol, num);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int maxInput = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                table[i][j] = sc.nextInt();
                maxInput = Math.max(table[i][j], maxInput);
            }
        }

        int bombcnt = 0;

        for(int i = 1 ; i <= maxInput ; i++){
            clearVisited();
            for(int j = 0 ; j < n ; j++){
                for(int k = 0 ; k < n ; k++){
                    bombNum = 0;

                    puyopuyo(j,k,i);

                    if(bombNum >= MIN_NUM_OF_BOMB){
                        bombcnt++;
                    }
                    maxBombNum = Math.max(maxBombNum, bombNum);
                }
            }
        }

        System.out.print(bombcnt + " " + maxBombNum);
    }
}