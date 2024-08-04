import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_INT = 50;
    public static char[][] table = new char[MAX_INT][MAX_INT];
    public static int[] arrR = new int[]{-1, -1, -1, 0, 1, 1 , 1, 0};
    public static int[] arrC = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};

    public static int N = -1;
    public static int M = -1;

    public static boolean inRange(int row, int col){
        return row >= 0 && col >= 0 && row < N && col < M;
    }
    
    public static int findCnt(int row, int col){
        if(table[row][col] != 'L'){
            return 0;
        }
        int ans = 0;

        for(int i = 0 ; i < arrR.length ; i++){
            int cnt = 0;
            for(int j = 1 ; j <= 2 ; j++){
                if(inRange(row + arrR[i] * j, col + arrC[i] * j) && table[row + arrR[i] * j][col + arrC[i] * j] == 'E'){
                    cnt++;
                }
            }

            if(cnt == 2){
                ans++;
            }
        }
        
        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < N ; i++){
            String str = String.valueOf(br.readLine());
            for(int j = 0 ; j < M ; j++){
                table[i][j] = str.charAt(j);
            }
        }

        int ans = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                ans += findCnt(i, j);
            }
        }

        System.out.print(ans);
    }
}