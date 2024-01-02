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
    public static final int MAX_RANGE= 50;
    public static final int INVAILED = Integer.MIN_VALUE; 
    public static int[][] table = new int[MAX_RANGE][MAX_RANGE];
    public static int[][] DP = new int[MAX_RANGE][MAX_RANGE];
    public static Queue<point> q = new LinkedList<>();
    public static int n;
    public static int m;

    public static void initalize(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                DP[i][j] = INVAILED;
            }
        }
        DP[0][0] = 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                table[i][j] = sc.nextInt();
            }
        }

        initalize();

        q.add(new point(0, 0));

        while(!q.isEmpty()){
            point curPoint = q.poll();
            for(int i = curPoint.row + 1; i < n ; i++){
                for(int j = curPoint.col + 1 ; j < m ; j++){
                    if(table[curPoint.row][curPoint.col] >= table[i][j]){
                        continue;
                    }

                    DP[i][j] = Math.max(DP[i][j], DP[curPoint.row][curPoint.col] + 1);
                    q.add(new point(i, j));
                }
            }
        }

        int output = INVAILED;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                output = Math.max(output, DP[i][j]);
                // System.out.print(DP[i][j] + " ");
            }
            // System.out.println();
        }

        System.out.print(output);
        
    }
}