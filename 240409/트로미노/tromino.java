import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 200;
    public static int[][] table = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];
    public static int[][] prefix = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= m ; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
                prefix[i][j] = table[i][j] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }

        int ans = 0;
        for(int i = 2 ; i <= n ; i++){
            for(int j = 2 ; j <= m ; j++){
                int square = prefix[i][j] - prefix[i - 2][j] - prefix[i][j - 2] + prefix[i - 2][j - 2];
                
                for(int k = 0 ; k <= 1 ; k++){
                    for(int h = 0 ; h <= 1 ; h++){
                        ans = Math.max(ans, square - table[i - k][j - h]);
                    }
                }
            }
        }

        for(int i = 3 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                ans = Math.max(ans, prefix[i][j] - prefix[i - 3][j] - prefix[i][j - 1] + prefix[i - 3][j - 1]);
            }
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = 3 ; j <= m ; j++){
                ans = Math.max(ans, prefix[i][j] - prefix[i - 1][j] - prefix[i][j - 3] + prefix[i - 1][j - 3]);
            }
        }

        System.out.println(ans);
    }
}