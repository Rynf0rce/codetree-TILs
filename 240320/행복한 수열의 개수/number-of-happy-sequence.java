import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[][] table = new int[MAX_LENGTH][MAX_LENGTH];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            int cnt = 0;
            int maxCnt = 0;
            int curVal = -1;
            for(int j = 0 ; j < n ; j++){
                if(curVal != table[i][j]){
                    cnt = 1;
                    curVal = table[i][j];
                }
                else{
                    cnt++;
                }
                maxCnt = Math.max(maxCnt, cnt);
            }

            if(maxCnt >= m){
                ans++;
            }
        }

        for(int j = 0 ; j < n ; j++){
            int cnt = 0;
            int maxCnt = 0;
            int curVal = -1;
            for(int i = 0 ; i < n ; i++){
                if(curVal != table[i][j]){
                    cnt = 1;
                    curVal = table[i][j];
                }
                else{
                    cnt++;
                }
                maxCnt = Math.max(maxCnt, cnt);
            }

            if(maxCnt >= m){
                ans++;
            }
        }

        System.out.print(ans);
    }
}