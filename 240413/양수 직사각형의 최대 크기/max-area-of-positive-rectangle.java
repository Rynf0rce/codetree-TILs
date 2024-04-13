import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 20;
    public static int[][] table = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];
    public static int[][] condition = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];
    public static int n = -1;
    public static int m = -1;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= m ; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1; j <= m ; j++){
                condition[i][j] = condition[i - 1][j] + condition[i][j - 1] - condition[i - 1][j - 1];
                if(table[i][j] <= 0){
                    condition[i][j]++;
                }
            }
        }

        int ans = -1;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                for(int k = i ; k <= n ; k++){
                    for(int h = j ; h <= m ; h++){
                        int flag = condition[k][h] - condition[i - 1][h] - condition[k][j - 1] + condition[i - 1][j - 1];
                        if(flag == 0){
                            ans = Math.max(ans, (k - i + 1) * (h - j + 1));
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}