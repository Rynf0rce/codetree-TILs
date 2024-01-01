import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static int[][] table = new int[MAX_RANGE][MAX_RANGE];
    public static int[][] minTable = new int[MAX_RANGE][MAX_RANGE];
    public static int[][] maxTable = new int[MAX_RANGE][MAX_RANGE];
    public static int n;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                table[i][j] = sc.nextInt();
            }
        }

        minTable[0][0] = table[0][0];
        maxTable[0][0] = table[0][0];

        for(int i = 1 ; i < n ; i++){
            minTable[0][i] = Math.min(table[0][i], minTable[0][i - 1]);
            maxTable[0][i] = Math.max(table[0][i], maxTable[0][i - 1]);
            minTable[i][0] = Math.min(table[i][0], minTable[i - 1][0]);
            maxTable[i][0] = Math.max(table[i][0], maxTable[i - 1][0]);
        }

        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j < n ; j++){
                int minOfMax = Math.max(minTable[i - 1][j], minTable[i][j - 1]);
                if(table[i][j] > minOfMax){
                    minTable[i][j] = minOfMax;
                }
                else{
                    minTable[i][j] = table[i][j];
                }
                
                int maxOfMin = Math.min(maxTable[i - 1][j], maxTable[i][j - 1]);
                if(table[i][j] < maxOfMin){
                    maxTable[i][j] = maxOfMin;
                }
                else{
                    maxTable[i][j] = table[i][j];
                }
            }
        }

        System.out.print(Math.abs(maxTable[n - 1][n - 1] - minTable[n - 1][n - 1]));
    }
}