import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 200;
    public static final int MAX_INT = 1000;
    public static int[][] table = new int[MAX_LENGTH][MAX_LENGTH];

    public static void main(String[] args) throws IOException{
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
        for(int i = 0 ; i < n - 1; i++){
            for(int j = 0 ; j < m - 1 ; j++){
                int sum = 0;
                int minVal = MAX_INT;
                for(int k = i ; k < i + 2 ; k++){
                    for(int h = j ; h < j + 2 ; h++){
                        sum += table[k][h];
                        minVal = Math.min(minVal, table[k][h]);
                    }
                }
                ans = Math.max(ans, sum - minVal);
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m - 1 ; j++){
                int sum = 0;
                for(int k = i ; k < Math.min(i + 3, n) ; k++){
                    sum += table[k][j];
                }

                ans = Math.max(ans, sum);

                sum = 0;
                for(int k = j ; k < Math.min(j + 3, m) ; k++){
                    sum += table[i][k];
                }

                ans = Math.max(ans, sum);
            }
        }

        System.out.print(ans);
    }
}