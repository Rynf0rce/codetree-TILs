import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 20;
    public static boolean[][] table = new boolean[MAX_LENGTH][MAX_LENGTH];
    public static int[] arrRow = new int[]{-1, -1, 1, 1};
    public static int[] arrCol = new int[]{1, -1, -1, 1};
    public static int n = -1;
    public static int m = -1;
    public static int maxVal = -1;

    public static boolean inRange(int row, int col){
        return row >= 0 && col >= 0 && row < n && col < n;
    }

    public static int returnCost(int num){
        return num * num + (num + 1) * (num + 1);
    }

    public static int findGold(int row, int col){
        int calRow = row;
        int calCol = col;
        int k = 0;
        int gold = 0;
        int ans = 0;
        while(returnCost(k) <= maxVal){
            if(k == 0){
                gold += table[row][col] ? 1 : 0;
            }
            else{
                calRow++;
                for(int i = 0 ; i < 4 ; i++){
                    for(int j = 1 ; j <= k ; j++){
                        calRow += arrRow[i];
                        calCol += arrCol[i];
                        if(inRange(calRow, calCol) && table[calRow][calCol]){
                            gold++;
                        }
                    }
                }
            }
            
            if(gold * m >= returnCost(k)){
                ans = Math.max(ans, gold);
            }
            k++;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int numOfGold = 0;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++){
                table[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
                if(table[i][j]){
                    numOfGold++;
                }
            }
        }

        maxVal = m * numOfGold;

        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                ans = Math.max(ans, findGold(i, j));
            }
        }

        System.out.print(ans);
    }
}