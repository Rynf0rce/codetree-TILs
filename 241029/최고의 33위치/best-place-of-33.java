import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 20;
    public static int[][] table = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];
    public static int[][] prefix = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= N ; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
                prefix[i][j] = table[i][j] + prefix[i][j - 1] + prefix[i - 1][j] - prefix[i - 1][j - 1];
            }
        }

        int ans = 0;
        for(int i = 3 ; i <= N ; i++){
            for(int j = 3 ; j <= N ; j++){
                ans = Math.max(ans, prefix[i][j] - prefix[i - 3][j] - prefix[i][j - 3] + prefix[i - 3][j - 3]);
            }
        }
        System.out.print(ans);
    }
}