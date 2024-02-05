import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_EDGE = 100;
    public static final int NUM_VISITED = 5;
    public static boolean[][] table = new boolean[MAX_EDGE][MAX_EDGE];
    public static int[] arrRow = new int[]{-1, 0, 1, 0, 0};
    public static int[] arrCol = new int[]{0, 1, 0, -1, 0};
    public static int n;

    public static void reverse(int row, int col){
        for(int i = 0 ; i < NUM_VISITED ; i++){
            int curRow = row + arrRow[i];
            int curCol = col + arrCol[i];

            if(curRow >= 0 && curCol >= 0 && curRow < n && curCol < n){
                if(table[curRow][curCol]){
                    table[curRow][curCol] = false;
                }
                else{
                    table[curRow][curCol] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    table[i][j] = true;
                }
            }
        }
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!table[i - 1][j]){
                    reverse(i, j);
                    cnt++;
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            if(!table[n - 1][i]){
                System.out.print(-1);
                System.exit(0);
            }
        }

        System.out.print(cnt);
    }
}