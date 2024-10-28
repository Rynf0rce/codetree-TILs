import java.util.*;
import java.io.*;
public class Main {
    public static final int MAX_LENGTH = 19;
    public static int[][] table = new int[MAX_LENGTH][MAX_LENGTH];

    public static boolean inRange(int row, int col){
        return row >= 0 && col >= 0 && row < MAX_LENGTH && col < MAX_LENGTH;
    }

    public static int horizontal(int row, int col){
        int ans = 0;
        for(int i = -2 ; i <= 2 ; i++){
            if(!inRange(row, col + i) || table[row][col + i] != table[row][col]){
                return 0;
            }
        }
        return table[row][col];
    }

    public static int vertical(int row, int col){
        int ans = 0;
        for(int i = -2 ; i <= 2 ; i++){
            if(!inRange(row + i, col) || table[row + i][col] != table[row][col]){
                return 0;
            }
        }
        return table[row][col];
    }

    public static int left_diagonal(int row, int col){
        int ans = 0;
        for(int i = -2 ; i <= 2 ; i++){
            if(!inRange(row + i, col + i) || table[row + i][col + i] != table[row][col]){
                return 0;
            }
        }
        return table[row][col];
    }

    public static int right_diagonal(int row, int col){
        int ans = 0;
        for(int i = -2 ; i <= 2 ; i++){
            if(!inRange(row - i, col + i) || table[row - i][col + i] != table[row][col]){
                return 0;
            }
        }
        return table[row][col];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 0 ; i < MAX_LENGTH ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int j = 0;
            while(st.hasMoreTokens()){
                table[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for(int i = 0 ; i < MAX_LENGTH ; i++){
            for(int j = 0 ; j < MAX_LENGTH ; j++){
                ans = Math.max(ans, horizontal(i, j));
                ans = Math.max(ans, left_diagonal(i, j));
                ans = Math.max(ans, right_diagonal(i, j));
                ans = Math.max(ans, vertical(i, j));
                if(ans > 0){
                    System.out.println(ans);
                    System.out.print((i + 1) + " " + (j + 1));
                    System.exit(0);
                }
            }
        }
        System.out.print(0);
    }
}