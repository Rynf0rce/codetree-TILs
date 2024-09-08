import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_EDGE = 1000;
    public static char[][] table = new char[MAX_EDGE + 1][MAX_EDGE + 1];
    public static int[][][] preSum = new int[MAX_EDGE + 1][MAX_EDGE + 1][3]; // a, b, c
    public static int n, m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
       
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= n ; i++){
            String str = br.readLine();
            for(int j = 1 ; j <= m ; j++){
                table[i][j] = str.charAt(j - 1);
                if(table[i][j] == 'a'){
                    preSum[i][j][0] = 1 + preSum[i - 1][j][0] + preSum[i][j - 1][0] - preSum[i - 1][j - 1][0];
                    preSum[i][j][1] = preSum[i - 1][j][1] + preSum[i][j - 1][1] - preSum[i - 1][j - 1][1];
                    preSum[i][j][2] = preSum[i - 1][j][2] + preSum[i][j - 1][2] - preSum[i - 1][j - 1][2];
                }
                else if(table[i][j] == 'b'){
                    preSum[i][j][0] = preSum[i - 1][j][0] + preSum[i][j - 1][0] - preSum[i - 1][j - 1][0];
                    preSum[i][j][1] = 1 + preSum[i - 1][j][1] + preSum[i][j - 1][1] - preSum[i - 1][j - 1][1];
                    preSum[i][j][2] = preSum[i - 1][j][2] + preSum[i][j - 1][2] - preSum[i - 1][j - 1][2];
                }
                else{
                    preSum[i][j][0] = preSum[i - 1][j][0] + preSum[i][j - 1][0] - preSum[i - 1][j - 1][0];
                    preSum[i][j][1] = preSum[i - 1][j][1] + preSum[i][j - 1][1] - preSum[i - 1][j - 1][1];
                    preSum[i][j][2] = 1 + preSum[i - 1][j][2] + preSum[i][j - 1][2] - preSum[i - 1][j - 1][2];
                }
            }
        }
        
        for(int i = 0 ; i < k ; i++){
            st = new StringTokenizer(br.readLine(), " ");

            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            bw.write(preSum[r2][c2][0] + preSum[r1 - 1][c1 - 1][0] - preSum[r2][c1 - 1][0] - preSum[r1 - 1][c2][0] + " ");
            bw.write(preSum[r2][c2][1] + preSum[r1 - 1][c1 - 1][1] - preSum[r2][c1 - 1][1] - preSum[r1 - 1][c2][1] + " ");
            bw.write(preSum[r2][c2][2] + preSum[r1 - 1][c1 - 1][2] - preSum[r2][c1 - 1][2] - preSum[r1 - 1][c2][2] + "\n");
        }

        br.close();
        bw.close();
    }
}