import java.util.*;

public class Main {
    public static final int MAX_RANGE = 20;
    public static int[][] arr2D = new int[MAX_RANGE][MAX_RANGE];
    public static boolean inRange(int x, int y, int range){
        if(x < 0 || y < 0 || x >= range || y >= range){
            return false;
        }
        return true;
    }

    public static int currentValue(int row, int column, int range){
        int tempRow = row, tempColumn = column, cnt_1 = 0, cnt_2 = 0, maxVal = 0;
        int[] arrRow = new int[]{1, 1, -1, -1};
        int[] arrColumn = new int[]{-1, 1, 1, -1};
        
        for(int i = 1 ; i < range ; i++){

            if(inRange(tempRow + arrRow[0] * i, tempColumn + arrColumn[0] * i, range)){
                cnt_1 = i;
            }
            else{
                break;
            }
            for(int j = 1 ; j < range ; j++){
                int output = 0;
                if(inRange(tempRow + arrRow[0] * i + arrRow[1] * j, tempColumn + arrColumn[0] * i + arrColumn[1] * j, range)){
                    cnt_2 = j;
                }
                else{
                    break;
                }

                int calRow = row, calColumn = column;

                for(int k = 0 ; k < 4 ; k++){
                    boolean triger = false;
                    if(k % 2 == 0){
                        for(int h = 1 ; h <= cnt_1 ; h++){
                            calRow += arrRow[k];
                            calColumn += arrColumn[k];
                            if(inRange(calRow, calColumn, range)){
                                output += arr2D[calRow][calColumn];
                            }
                            else{
                                triger = true;
                                break;
                            }
                            
                        }
                    }
                    else{
                        for(int h = 1 ; h <= cnt_2 ; h++){
                            calRow += arrRow[k];
                            calColumn += arrColumn[k];
                            if(inRange(calRow, calColumn, range)){
                                output += arr2D[calRow][calColumn];
                            }
                            else{
                                triger = true;
                                break;
                            }
                        }  
                    }
                    if(triger){
                        output = 0;
                        break;
                    }
                }
                maxVal = Math.max(maxVal, output);
                // System.out.println(row + " " + column + " " + cnt_1 + " " + cnt_2 + " " + output +"\n");
            }
        }
        return maxVal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), maxVal = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                maxVal = Math.max(maxVal, currentValue(i, j, n));
            }
        }
        System.out.println(maxVal);
    }
}

/*

import java.util.Scanner;

public class Main {
    public static final int DIR_NUM = 4;
    public static final int MAX_N = 20;
    
    public static int n;
    public static int[][] grid = new int[MAX_N][MAX_N];
    
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    
    public static int getScore(int x, int y, int k, int l) {
        int[] dx = new int[]{-1, -1, 1, 1};
        int[] dy = new int[]{1, -1, -1, 1};
        int[] moveNum = new int[]{k, l, k, l};
        
        int sumOfNums = 0;
    
        // 기울어진 직사각형의 경계를 쭉 따라가봅니다.
        for(int d = 0; d < DIR_NUM; d++)
            for(int q = 0; q < moveNum[d]; q++) {
                x += dx[d]; y += dy[d];
                    
                // 기울어진 직사각형이 경계를 벗어나는 경우라면
                // 불가능하다는 의미로 답이 갱신되지 않도록
                // 0을 반환합니다.
                if(!inRange(x, y))
                    return 0;
                
                sumOfNums += grid[x][y];
            }
        
        return sumOfNums;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int ans = 0;
        
        // (i, j)를 시작으로 1, 2, 3, 4 방향
        // 순서대로 길이 [k, l, k, l] 만큼 이동하면 그려지는
        // 기울어진 직사각형을 잡아보는
        // 완전탐색을 진행해봅니다.
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                for(int k = 1; k < n; k++)
                    for(int l = 1; l < n; l++)
                        ans = Math.max(ans, getScore(i, j, k, l));

        System.out.print(ans);
    }
}

*/
