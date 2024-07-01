import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

class Pair {
    int x, y;
    public Pair(int x, int y) { 
        this.x = x; 
        this.y = y; 
    } 
}

public class Main {
    public static final int MAX_M = 200;
    public static final int MAX_N = 200;
    public static final int DIR_NUM = 4;
    
    public static final int WATER = 0;
    public static final int GLACIER = 1;
    
    public static int n, m;
    
    public static int[][] a = new int[MAX_N][MAX_M];
    
    public static Queue<Pair> q = new LinkedList<>();
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];
    public static int cnt;
    
    public static Queue<Pair> glaciersToMelt = new LinkedList<>();
    
    public static int[] dx = new int[]{1, -1, 0, 0};
    public static int[] dy = new int[]{0, 0, 1, -1};
    
    public static int elapsedTime, lastMeltCnt;
    
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
    
    public static boolean canGo(int x, int y) {
        return inRange(x, y) && a[x][y] == WATER && !visited[x][y];
    }
    
    public static boolean isGlacier(int x, int y) {
        return inRange(x, y) && a[x][y] == GLACIER && !visited[x][y];
    }
    
    public static void BFS() {
        while(!q.isEmpty()) {
            Pair currPos = q.poll();
            int x = currPos.x, y = currPos.y;
    
            for(int dir = 0; dir < DIR_NUM; dir++) {
                int nx = x + dx[dir], ny = y + dy[dir];
    
                if(canGo(nx, ny)) {
                    q.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                }
                else if(isGlacier(nx, ny)) {
                    glaciersToMelt.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void melt() {
        while(!glaciersToMelt.isEmpty()) {
            Pair pos = glaciersToMelt.poll();
            int x = pos.x, y = pos.y;
    
            a[x][y] = WATER;
        }
    }
    
    public static boolean simulate() {
        BFS();
    
        if((int) glaciersToMelt.size() == 0){
            return false;
        }
            
        elapsedTime++;
        lastMeltCnt = (int) glaciersToMelt.size();
        q = new LinkedList<> (glaciersToMelt);
    
        melt();
    
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                a[i][j] = sc.nextInt();
            }
        }
            
        
        q.add(new Pair(0, 0));
        visited[0][0] = true;

        boolean isGlacierExist = false;

        do {
            isGlacierExist = simulate();
        } while(isGlacierExist);

        System.out.print(elapsedTime + " " + lastMeltCnt);
    }
}