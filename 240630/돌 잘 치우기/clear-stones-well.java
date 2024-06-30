import java.util.*;

class point{
    int row;
    int col;

    public point(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Main {
    public static final int MAX_RANGE = 100;
    public static final int NUM_DIRECTION = 4;

    public static int[][] table = new int[MAX_RANGE][MAX_RANGE];
    public static int[][] settingTable = new int[MAX_RANGE][MAX_RANGE];
    public static boolean[][] vistied = new boolean[MAX_RANGE][MAX_RANGE];
    public static int[] arrRow = new int[]{-1, 0, 1, 0};
    public static int[] arrCol = new int[]{0, 1, 0, -1};

    public static ArrayList<point> startList = new ArrayList<>();
    public static ArrayList<point> rockList = new ArrayList<>();
    public static ArrayList<Integer> selectedList = new ArrayList<>();
    public static Queue<point> q = new LinkedList<>();

    public static int n;
    public static int bombNum;
    public static int m;
    public static int cnt;
    public static int maxVal = Integer.MIN_VALUE;

    public static void clearVisited(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ;j++){
                vistied[i][j] = false;
            }
        }
    }

    public static void clearSettingTable(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ;j++){
                settingTable[i][j] = table[i][j];
            }
        }
    }

    public static boolean inRange(int row, int col){
        return (row >= 0 && col >= 0 && row < n && col < n);
    }

    public static boolean canGo(int row, int col){
        if(!inRange(row, col)){
            return false;
        }

        if(settingTable[row][col] == 1 || vistied[row][col]){
            return false;
        }

        return true;
    }

    public static void push(int row, int col){
        vistied[row][col] = true;
        q.add(new point(row, col));
        cnt++;
    }

    public static void combination(int num){
        if(selectedList.size() == m){
            clearVisited();
            clearSettingTable();

            for(int i = 0 ; i < selectedList.size() ; i++){
                int removeIdx = selectedList.get(i);
                point removeRock = rockList.get(removeIdx);
                settingTable[removeRock.row][removeRock.col] = 0;
            }

            cnt = 0;

            for(int i = 0 ; i < startList.size() ; i++){
                point startPoint = startList.get(i);
                if(canGo(startPoint.row, startPoint.col)){
                    push(startPoint.row, startPoint.col);
                    BFS();
                }
            }

            maxVal = Math.max(maxVal, cnt);
        }

        for(int i = num ; i < bombNum ; i++){
            selectedList.add(i);
            combination(i + 1);
            selectedList.remove(selectedList.size() - 1);
        }
    }

    public static void BFS(){
        while(!q.isEmpty()){
            point curPoint = q.poll();
            for(int i = 0 ; i < NUM_DIRECTION ; i++){
                int postRow = curPoint.row + arrRow[i];
                int postCol = curPoint.col + arrCol[i];
                if(canGo(postRow, postCol)){
                    push(postRow, postCol);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int k = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                table[i][j] = sc.nextInt();
                if(table[i][j] == 1){
                    rockList.add(new point(i, j));
                }
            }
        }

        bombNum = rockList.size();

        for(int i = 0 ; i < k ; i++){
            int startRow = sc.nextInt() - 1;
            int startCol = sc.nextInt() - 1;
            startList.add(new point(startRow, startCol));
        }

        combination(0);

        System.out.println(maxVal);

    }
}