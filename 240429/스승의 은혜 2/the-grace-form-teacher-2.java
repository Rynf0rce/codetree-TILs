import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_PEOPLE = 1000;
    public static final int MAX_VAL = (int) 1e9;
    public static int[][] DP = new int[2][MAX_PEOPLE + 1];
    public static int[] arr = new int[MAX_PEOPLE + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, 1, N + 1);

        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j <= N ; j++ ){
                DP[i][j] = MAX_VAL;
            }
        }

        DP[0][0] = 0;
        int ans = 0;
        boolean flag = false;
        for(int j = 1 ; j <= N ; j++){
            for(int i = 0 ; i <= 1 ; i++){
                DP[i][j] = Math.min(DP[i][j], DP[i][j - 1] + arr[j]);
                if(i == 1){
                    DP[i][j] = Math.min(DP[i][j], DP[i - 1][j - 1] + arr[j] / 2);
                    if(DP[i][j] <= B){
                        ans = j;
                    }
                    else{
                        flag = true;
                        break;
                    }
                }
            }

            if(flag){
                break;
            }
        }

        System.out.print(ans);

    }
}