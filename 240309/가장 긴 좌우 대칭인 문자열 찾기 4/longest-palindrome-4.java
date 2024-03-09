import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 5000;
    public static String str = " ";
    public static int n = -1;
    public static boolean[][] DP = new boolean[MAX_LENGTH + 1][MAX_LENGTH + 1];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = String.valueOf(br.readLine());
        n = str.length();
        str = "#" + str;

        for(int i = 1 ; i <= n ; i++){
            DP[i][i] = true;
        }

        for(int i = 1 ; i < n ; i++){
            if(str.charAt(i) == str.charAt(i + 1)){
                DP[i][i + 1] = true;
            }
        }

        for(int gap = 3 ; gap <= n ; gap++){
            for(int i = 1 ; i <= n - gap + 1; i++){
                int j = i + gap - 1;

                if(DP[i + 1][j - 1] && str.charAt(i) == str.charAt(j)){
                    DP[i][j] = true;
                }
            }
        }

        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            for(int j = i ; j <= n ; j++){
                if(DP[i][j]){
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        System.out.print(ans);

    }
}