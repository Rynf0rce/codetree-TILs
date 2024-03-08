import java.util.*;
import java.io.*;

class point implements Comparable<point>{
    int x, y;
    public point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(point p){
        return this.x - p.x;
    }
}

public class Main {
    public static final int MAX_POINT = 1000;
    public static final int MAX_INT = (int)1e9;
    public static point[] pointArr = new point[MAX_POINT];
    public static int[][] table = new int[MAX_POINT][MAX_POINT];
    public static int[][] DP = new int[MAX_POINT][MAX_POINT];
    public static int[][] maxDP = new int[MAX_POINT][MAX_POINT];

    public static int n = -1;

    public static int dist(point p1, point p2){
        return (int)(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
    public static void makeDP(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                DP[i][j] = MAX_INT;
            }
        }

        DP[0][0] = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                int next = Math.max(i, j) + 1;
                
                if(next >= n){
                    continue;
                }

                DP[next][j] = Math.min(DP[next][j], DP[i][j] + table[i][next]);
                DP[i][next] = Math.min(DP[i][next], DP[i][j] + table[j][next]);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pointArr[i] = new point(x, y);
        }

        Arrays.sort(pointArr, 0, n);

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                table[i][j] = dist(pointArr[i], pointArr[j]);
            }
        }

        makeDP();

        // for(int i = 0 ; i < n ; i++){
        //     for(int j = 0 ; j < n ; j++){
        //         System.out.print(table[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // System.out.println();

        // for(int i = 0 ; i < n ; i++){
        //     for(int j = 0 ; j < n ; j++){
        //         System.out.print(DP[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        int ans = MAX_INT;
        for(int i = 0 ; i < n ; i++){
            ans = Math.min(ans, DP[i][n - 1]);
        }
        System.out.println(ans);
        
    }
}