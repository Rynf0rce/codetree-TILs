import java.util.*;
import java.io.*;

class tuple implements Comparable<tuple>{
    int x, y;
    public tuple(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int compareTo(tuple t){
        if(this.x == t.x){
            return this.y - t.y;
        }
        return this.x - t.x;
    }
}

public class Main {
    public static final int MAX_POINT = 1000;
    public static final int MAX_INT = (int) 1e9;
    public static final long MAX_LONG = (long) 1e11;
    public static int[][] table = new int[MAX_POINT][MAX_POINT];
    public static long[][] DP = new long[MAX_POINT][MAX_POINT];
    public static tuple[] tupleArr = new tuple[MAX_POINT];
    public static int n = -1;

    public static long bitonic(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ;  j < n ; j++){
                DP[i][j] = MAX_LONG;
            }
        }

        DP[0][0] = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                int next = Math.max(i, j) + 1;

                if(next == n){
                    continue;
                }

                DP[next][j] = Math.min(DP[next][j], DP[i][j] + table[i][next]);
                DP[i][next] = Math.min(DP[i][next], DP[i][j] + table[j][next]);
            }
        }

        long ans = MAX_LONG;
        for(int i = 0 ; i < n ; i++){
            ans = Math.min(ans, DP[i][n - 1] + table[i][n - 1]);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tupleArr[i] = new tuple(x, y);
        }

        Arrays.sort(tupleArr, 0, n);
        for(int i = 0 ; i < n  ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == j){
                    table[i][j] = MAX_INT;
                }
                table[i][j] = (int)Math.pow((tupleArr[i].x - tupleArr[j].x), 2) + (int)Math.pow((tupleArr[i].y - tupleArr[j].y), 2);
            }
        }

        System.out.print(bitonic());
    }
}