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
    public static final int MAX_RANGE = 200;
    public static final int NUM_DIRCTION = 4;

    public static int[][] table = new int[MAX_RANGE][MAX_RANGE];
    public static boolean[][] visited = new boolean[MAX_RANGE][MAX_RANGE];
    public static int[] arrRow = new int[]{-1, 0, 1, 0};
    public static int[] arrCol = new int[]{0, 1, 0, -1};

    public static Queue<point> water = new LinkedList<>();
    public static Queue<point> glacier = new LinkedList<>();

    public static int N;
    public static int M;
    
    public static boolean inRange(int row, int col){
        return (row >= 0 && col >= 0 && row < N && col < M);
    }

    public static boolean canGo(int row, int col){
        if(!inRange(row, col)){
            return false;
        }

        if(visited[row][col] || table[row][col] == 1){
            return false;
        }

        return true;
    }

    public static boolean isBorder(int row, int col){
        if(!inRange(row, col)){
            return false;
        }

        if(table[row][col] == 0 || visited[row][col]){
            return false;
        }
        
        return true;
    }

    public static void push(int row, int col, Queue<point> q){
        visited[row][col] = true;
        q.add(new point(row, col));
    }

    public static void BFS(){
        glacier.clear();
        while(!water.isEmpty()){
            point curPoint = water.poll();
            for(int i = 0 ; i < NUM_DIRCTION ; i++){
                int postRow = curPoint.row + arrRow[i];
                int postCol = curPoint.col + arrCol[i];
                if(canGo(postRow, postCol)){
                    push(postRow, postCol, water);
                }
                
                if(isBorder(postRow, postCol)){
                    push(postRow, postCol, glacier);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                table[i][j] = sc.nextInt();
            }
        }
        
        int numOfMelt = 0;
        int time = 0;

        while(true){
            push(time, time, water);
            BFS();
            if(glacier.isEmpty()){
                break;
            }

            time++;
            numOfMelt = glacier.size();

            while(!glacier.isEmpty()){
                point delPoint = glacier.poll();
                table[delPoint.row][delPoint.col] = 0;
                visited[delPoint.row][delPoint.col] = false;
            }
        }

        System.out.println(time + " " + numOfMelt);
    }
}