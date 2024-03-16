import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 16;
    public static int[][] table = new int[MAX_LENGTH][MAX_LENGTH];
    public static int[][] DP = new int[MAX_LENGTH][(1 << MAX_LENGTH)];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < (1 << n) ; j++){
                DP[i][j] = -1;
            }
        }

        DP[0][0] = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < (1 << n) ; j++){
                if(DP[i][j] == -1){
                    continue;
                }

                for(int k = 0 ; k < n ; k++){
                    if(((j >> k) & 1) == 1){
                        continue;
                    }

                    DP[i + 1][j + (1 << k)] = Math.max(DP[i + 1][j + (1 << k)], DP[i][j] + table[i][k]);
                }
            }
        }

        System.out.print(DP[n][(1 << n) - 1]);
    }
}