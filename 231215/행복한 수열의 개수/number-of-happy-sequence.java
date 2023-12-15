import java.util.*;

public class Main {
    public static final int EDGE = 100;
    public static int[][] arr2D = new int[EDGE][EDGE];
    public static boolean happySequence(int idx, int range, int condition, boolean direction){
        int num = -1, cnt = 0;
        if(direction){
            for(int i = 0 ; i < range ; i++){
                if(num == arr2D[i][idx]){
                    cnt++;
                }
                else{
                    num = arr2D[i][idx];
                    cnt = 1;
                }
                
                if(cnt >= condition){
                    return true;
                }
            }
        }
        else{
            for(int i = 0 ; i < range ; i++){
                if(num == arr2D[idx][i]){
                    cnt++;
                }
                else{
                    num = arr2D[idx][i];
                    cnt = 1;
                }
                
                if(cnt >= condition){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), cnt = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < 2*n ; i++){
            if(i < n && happySequence(i, n, m, true)){
                cnt++;
            }
            else if(i >= n && happySequence(i%n, n, m, false)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

/*
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100;
    
    public static int n, m;
    public static int[][] grid = new int[MAX_N][MAX_N];
    
    public static int[] seq = new int[MAX_N];
    
    public static boolean isHappySequence(){
        // 주어진 seq가 행복한 수열인지 판단하는 함수입니다.
        int consecutiveCount = 1, maxCcnt = 1;
        for(int i = 1; i < n; i++) {
            if (seq[i - 1] == seq[i])
                consecutiveCount++;
            else
                consecutiveCount = 1;
            
            maxCcnt = Math.max(maxCcnt, consecutiveCount);
        }
        
        // 최대로 연속한 회수가 m이상이면 true를 반환합니다. 
        return maxCcnt >= m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int numHappy = 0;
        
        // 먼저 가로로 행복한 수열의 수를 셉니다.
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                seq[j] = grid[i][j];
            
            if(isHappySequence())
                numHappy++;
        }
        
        // 세로로 행복한 수열의 수를 셉니다.
        for(int j = 0; j < n; j++){
            // 세로로 숫자들을 모아 새로운 수열을 만듭니다.
            for(int i = 0; i < n; i++)
                seq[i] = grid[i][j];
            
            if(isHappySequence())
                numHappy++;
        }

        System.out.print(numHappy);
    }
}
*/
