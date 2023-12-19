import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static int[][] arr2D = new int[MAX_RANGE][MAX_RANGE];
    public static int[] arrR = new int[]{1, 0, -1, 0};
    public static int[] arrC = new int[]{0, -1, 0, 1};
    public static int n;
    public static boolean inRange(int row, int column){
        return (row >= 0 && column >= 0 && row < n && column < n);
    }
    
    public static int reflect(int row, int column, int dir){
        if(arr2D[row][column] == 2){
            return Math.abs(3 - dir);
        }
        else if(arr2D[row][column] == 1){
            if(dir % 2 == 0){
                dir++;
            }
            else{
                dir--;
            }
        }
        return dir;
    }

    public static int conFnc(int dir, int idx){
        int row = 0, column = 0, output = 0;
        switch(dir){
            case 0 :
                row = 0;
                column = idx;
                break;
            case 1 :
                row = idx;
                column = n - 1;
                break;
            case 2 :
                row = n - 1;
                column = n - 1 - idx;
                break;
            case 3 :
                row = n - 1 - idx;
                column = 0;
                break;
        }

        output++;
        while(inRange(row, column)){
            dir = reflect(row, column, dir);
            row += arrR[dir];
            column += arrC[dir];
            output++;
        }
        
        return output;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }

        int maxVal = 0;
        for(int i = 0 ; i < n * 4 ; i++){
            maxVal = Math.max(maxVal, conFnc(i / n, i % n));
        }

        System.out.print(maxVal);

    }
}