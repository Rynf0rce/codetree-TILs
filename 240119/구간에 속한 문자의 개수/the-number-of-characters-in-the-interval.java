import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_EDGE = 1000;
    public static char[][] table = new char[MAX_EDGE + 1][MAX_EDGE + 1];
    public static int[][][] preSum = new int[MAX_EDGE + 1][MAX_EDGE + 1][3];
    public static int n, m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int arr[] = new int[st.countTokens()];
        int count=0;

		while(st.hasMoreTokens()) {
			arr[count++] = Integer.parseInt(st.nextToken());
		}
       
        n = arr[0];
        m = arr[1];
        int k = arr[2];

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
            StringTokenizer st1 = new StringTokenizer(br.readLine());
		    int[] condition = new int[st1.countTokens()];

            int idx = 0;

            while(st1.hasMoreTokens()) {
                condition[idx++] = Integer.parseInt(st1.nextToken());
            }

            int r1 = condition[0];
            int c1 = condition[1];
            int r2 = condition[2];
            int c2 = condition[3];

            System.out.print(preSum[r2][c2][0] + preSum[r1 - 1][c1 - 1][0] - preSum[r2][c1 - 1][0] - preSum[r1 - 1][c2][0] + " ");
            System.out.print(preSum[r2][c2][1] + preSum[r1 - 1][c1 - 1][1] - preSum[r2][c1 - 1][1] - preSum[r1 - 1][c2][1] + " ");
            System.out.print(preSum[r2][c2][2] + preSum[r1 - 1][c1 - 1][2] - preSum[r2][c1 - 1][2] - preSum[r1 - 1][c2][2] + "\n");
        }
    }
}