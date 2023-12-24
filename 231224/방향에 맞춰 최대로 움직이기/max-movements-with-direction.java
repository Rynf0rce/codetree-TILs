import java.util.*;

public class Main {
    public static final int MAX_RANGE = 4;
    public static int[][] area = new int[MAX_RANGE][MAX_RANGE];
    public static int[][] dir = new int[MAX_RANGE][MAX_RANGE];
    public static int[] arrR = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] arrC = new int[]{0, 1, 1, 1, 0, -1, -1 , -1};
    public static int n;
    public static int maxVal = Integer.MIN_VALUE;

    public static boolean inRange(int row, int col){
        return (row >= 0 && col >= 0 && row < n && col < n);
    }

    public static void simulation(int num, int row, int col){
        int direction = dir[row][col];
        int[] locR = new int[n];
        int[] locC = new int[n];
        int idx = 0;
        for(int i = 1 ; i < n ; i++){
            if(!inRange(row + arrR[direction] * i, col + arrC[direction] * i)){
                break;
            }

            if(area[row][col] < area[row + arrR[direction] * i][col + arrC[direction] * i]){
                
                locR[idx] = row + arrR[direction] * i;
                locC[idx++] = col + arrC[direction] * i;
            }
        }
        
        if(idx == 0){
            maxVal = Math.max(maxVal, num);
            return;
        }

        for(int i = 0 ; i < idx ; i++){
            simulation(num + 1, locR[i], locC[i]);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                area[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                dir[i][j] = sc.nextInt() - 1;
            }
        }

        int r = sc.nextInt(), c = sc.nextInt();

        // simulation(0, 0, 0);

        simulation(0, r - 1, c - 1);

        System.out.print(maxVal);
    }
}