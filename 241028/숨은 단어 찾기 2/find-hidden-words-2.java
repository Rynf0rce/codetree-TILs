import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 50;
    public static final String TARGET_STRING = "LEE";
    public static char[][] table = new char[MAX_LENGTH][MAX_LENGTH];
    public static int[] arrRow = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
    public static int[] arrCol = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
    public static int N = 0;
    public static int M = 0;

    public static boolean inRange(int row, int col){
        return row >= 0 && col >= 0 && row < N && col < M;
    }

    public static int check(int row, int col){
        if(table[row][col] != 'E'){
            return 0;
        }

        int ans = 0;
        for(int i = 0 ; i < arrRow.length ; i++){
            if(inRange(row + arrRow[i], col + arrCol[i]) && inRange(row + arrRow[(i + 4) % 8], col + arrCol[(i + 4) % 8]) && table[row + arrRow[i]][col + arrCol[i]] == TARGET_STRING.charAt(0) && table[row + arrRow[(i + 4) % 8]][col + arrCol[(i + 4) % 8]] == TARGET_STRING.charAt(2)){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                table[i][j] = str.charAt(j);
            }
        }


        int ans = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M  ; j++){
                ans += check(i , j);
            }
        }
        System.out.print(ans);
    }
}