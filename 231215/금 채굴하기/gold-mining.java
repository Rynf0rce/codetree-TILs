import java.util.*;

public class Main {
    public static final int EDGE = 20;
    public static int[][] arr2D = new int[EDGE][EDGE];
    
    public static int diamond(int row, int column, int width){
        int cnt = 0;
        for(int i = row - width ; i <= row + width ; i++){
            for(int j = column - width ; j <= column + width ; j++){
                if( (i < 0) || (j < 0) || (i >= EDGE) || (j >= EDGE) || Math.abs(row - i) + Math.abs(column - j) > width){
                    continue;
                }

                if(arr2D[i][j] == 1){
                    cnt++;
                }
            }
        }

        return cnt;
    }
    
    public static int maxGold(int range, int cost){
        int maxVal = 0;
        for(int i = 0 ; i < range; i++){
            for(int j = 0 ; j < range; j++){
                for(int k = 0 ; k < range ; k++){
                    int gold = diamond(i,j,k);
                    if(gold * cost >= k*k + (k+1) * (k+1)){
                        maxVal = Math.max(maxVal, gold);
                    }
                }
            }
        }
        return maxVal;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), cost = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }

        System.out.println(maxGold(n,m));

    }
}

/* 위의 방법으로는 시간복잡도가 O(n^5)이 되는데 아래 방법으로 하면 시간 복잡도를 O(n^4)으로 줄일 수 있음 이전거 더하기 + 그 다음것 순으로 해서*/
/*
import java.util.Scanner;

public class Main {
    public static final int MAX_NUM = 20;
    
    public static int n, m;
    public static int[][] grid = new int[MAX_NUM][MAX_NUM];
    
    public static int getArea(int k) {
        return k * k + (k+1) * (k+1); 
    }
    
    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
    
    // 주어진 k에 대하여 모서리에서 채굴 가능한 금의 개수를 반환합니다.
    public static int getNumOfGoldInBorder(int row, int col, int k) {
        int numOfGold = 0;
        int[] dx = new int[]{1, 1, -1, -1};
        int[] dy = new int[]{-1, 1, 1, -1}; // 방향에 따라 바뀌는 x와 y의 변화량을 정의합니다.
    
        if(k == 0)
            return grid[row][col];
    
        int currX = row - k, currY = col; // 순회 시작점 설정
    
        for(int currDir = 0; currDir < 4; currDir++) {
            for(int step = 0; step < k; step++) {
                if(inRange(currX, currY)) {
                    numOfGold += grid[currX][currY];
                }
                currX = currX + dx[currDir];
                currY = currY + dy[currDir];
            }
        }
    
        return numOfGold;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxGold = 0;

        n = sc.nextInt();
        m = sc.nextInt();
        for(int row = 0; row < n; row++)
            for(int col = 0; col < n; col++)
                grid[row][col] = sc.nextInt();


        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                int numOfGold = 0;
                for(int k = 0; k <= 2 * (n-1); k++) {
                    // 이전 k까지 구한 금의 개수에
                    // 해당 k의 모서리에 존재하는 금의 개수를 더해줍니다.
                    numOfGold += getNumOfGoldInBorder(row, col, k);

                    if(numOfGold * m >= getArea(k))
                        maxGold = Math.max(maxGold, numOfGold);
                }
            }
        }

        System.out.print(maxGold);
    }
}
*/
