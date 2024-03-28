import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 19;
    public static int[][] table = new int[MAX_LENGTH][MAX_LENGTH];

    public static boolean inRange(int row, int col){
        return row >= 0 && col >= 0 && row < MAX_LENGTH && col < MAX_LENGTH;
    }

    public static boolean canWin(int row, int col){
        if(table[row][col] == 0){
            return false;
        }

        int cnt = 0;
        for(int i = -2 ; i <= 2 ; i++){
            if(inRange(row + i, col) && table[row][col] == table[row + i][col]){
                cnt++;
            }
            else{
                break;
            }
        }

        if(cnt == 5){
            return true;
        }

        cnt = 0;
        for(int i = -2 ; i <= 2 ; i++){
            if(inRange(row, col + i) && table[row][col] == table[row][col + i]){
                cnt++;
            }
            else{
                break;
            }
        }

        if(cnt == 5){
            return true;
        }

        cnt = 0;
        for(int i = -2 ; i <= 2 ; i++){
            if(inRange(row + i, col + i) && table[row][col] == table[row + i][col + i]){
                cnt++;
            }
            else{
                break;
            }
        }

        if(cnt == 5){
            return true;
        }

        return false;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 0 ; i < MAX_LENGTH ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < MAX_LENGTH ; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < MAX_LENGTH ; i++){
            for(int j = 0 ; j < MAX_LENGTH ; j++){
                if(canWin(i, j)){
                    System.out.println(table[i][j]);
                    System.out.print((i + 1) + " " + (j + 1));
                    System.exit(0);
                }
            }
        }
        System.out.print(0);
    }
}