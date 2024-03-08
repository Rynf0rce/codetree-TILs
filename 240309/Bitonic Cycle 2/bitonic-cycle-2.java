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
    public static final long MAX_LONG = (long)1e12;
    public static point[] pointArr = new point[MAX_POINT];
    public static long[][][] DP = new long[2][MAX_POINT][MAX_POINT];
    public static int n = -1;

    public static long calDist(int i, int j){
        return (long)(Math.pow(pointArr[i].x - pointArr[j].x, 2) + Math.pow(pointArr[i].y - pointArr[j].y, 2));
    }

    public static void makeDP(int depth){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                int next = Math.max(i, j) + 1;

                if(next >= n){
                    continue;
                }

                DP[depth][next][j] = Math.min(DP[depth][next][j], DP[depth][i][j] + calDist(i, next));
                DP[depth][i][next] = Math.min(DP[depth][i][next], DP[depth][i][j] + calDist(j, next));

                if(depth == 0){
                    DP[depth + 1][next][j] = Math.min(DP[depth][next][j], DP[depth][i][j]);
                    DP[depth + 1][i][next] = Math.min(DP[depth][i][next], DP[depth][i][j]);
                }
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
                for(int k = 0 ; k < 2 ; k++){
                    DP[k][i][j] = MAX_LONG;
                }
            }
        }

        DP[0][0][0] = 0;
        
        makeDP(0);
        makeDP(1);

        // for(int i = 0 ; i < n ; i++){
        //     for(int j = 0 ; j < n ; j++){
        //         System.out.print(DP[1][i][j] + " ");
        //     }
        //     System.out.println();
        // }


        long ans = MAX_LONG;
        for(int i = 0 ; i < n ; i++){
            ans = Math.min(ans, DP[1][i][n - 1] + calDist(i, n - 1));
            ans = Math.min(ans, DP[0][i][n - 1]);
        }
        System.out.print(ans);

        
    }
}