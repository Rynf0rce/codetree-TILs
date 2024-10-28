import java.util.*;
import java.io.*;

class point{
    int row,col;
    public point(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Main {
    public static int MAX_LENGTH = 15;
    public static boolean[][] table = new boolean[MAX_LENGTH][MAX_LENGTH];
    public static int[][] prefixTable = new int[MAX_LENGTH][MAX_LENGTH];
    public static Queue<point> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < R ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < C ; j++){
                table[i][j] = st.nextToken().charAt(0) == 'W' ? true : false;
                if(table[i][j] != table[0][0]){
                    q.add(new point(i, j));
                }
            }
        }

        if(table[0][0] == table[R - 1][C - 1]){
            System.out.print(0);
            System.exit(0);
        }

        for(int i = 1 ; i < R ; i++){
            for(int j = 1 ; j < C ; j++){
                prefixTable[i][j] = prefixTable[i - 1][j] + prefixTable[i][j - 1] - prefixTable[i - 1][j - 1];
                if(table[i][j] == table[0][0]){
                    prefixTable[i][j]++;
                }
            }
        }

        int ans = 0;
        while(!q.isEmpty()){
            point p = q.poll();
            if(p.row >= R - 1 || p.col >= C - 1){
                continue;
            }
            ans += prefixTable[R - 2][C - 2] - prefixTable[p.row][C - 2] - prefixTable[R - 2][p.col] + prefixTable[p.row][p.col];
        }
        
        System.out.print(ans);
    }
}