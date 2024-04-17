import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 10;
    public static final int MAX_RANGE = 5;
    public static int[][] table = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];
    public static int[][] preSum = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];
    public static boolean[][] vistied = new boolean[MAX_LENGTH + 1][MAX_LENGTH + 1];
    public static int[] boundary = new int[MAX_RANGE];

    public static int N = -1;
    public static int M = -1;
    public static int C = -1;

    public static int findMaxval(int row, int col, boolean flag){
        for(int j = col ; j <= col + M - 1 ; j++){
            if(vistied[row][j]){
                return 0;
            }
        }

        if(flag){
            return preSum[row][col];
        }

        int ans = 0;
        for(int j = col ; j <= col + M - 1 ; j++){
            vistied[row][j] = true;
        }

        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N - M + 1 ; j++){
                ans = Math.max(ans, preSum[row][col] + findMaxval(i, j, true));
            }
        }

        for(int j = col ; j <= col + M - 1 ; j++){
            vistied[row][j] = false;
        }

        // System.out.println(row + " " + col + " " + ans);
        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= N ; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N - M + 1 ; j++){
                int idx = 0;
                for(int k = j ; k <= j + M - 1 ; k++){
                    boundary[idx++] = table[i][k];
                }

                Arrays.sort(boundary, 0, M);

                int val = 0;
                for(int r = M - 1 ; r >= 0 ; r--){
                    int weight = boundary[r];
                    int cost = boundary[r] * boundary[r];
                    int k = r - 1;
                    for(; k >= 0 ; k--){
                        if(weight + boundary[k] > C){
                            break;
                        }
                        weight += boundary[k];
                        cost += boundary[k] * boundary[k];
                    }
                    
                    for(int l = 0 ; l < k ; l++){
                        if(weight + boundary[l] > C){
                            break;
                        }
                        weight += boundary[l];
                        cost += boundary[l] * boundary[l];
                    }
                    val = Math.max(val, cost);
                }
                preSum[i][j] = val;
            }
        }

        // for(int i = 1 ; i <= N ; i++){
        //     for(int j = 1 ; j <= N ; j++){
        //         System.out.print(preSum[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        int ans = 0;
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N - M + 1 ; j++){
                ans = Math.max(ans, findMaxval(i, j, false));
            }
        }

        System.out.print(ans);


    }
}