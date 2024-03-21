import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 15;
    public static boolean[][] table = new boolean[MAX_LENGTH][MAX_LENGTH];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < m ; j++){
                if(String.valueOf(st.nextToken()).charAt(0) == 'B'){
                    table[i][j] = true;
                }
            }
        }

        int ans = 0;
        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j < m ; j++){
                if(table[0][0] == table[i][j]){
                    continue;
                }

                for(int k = i + 1 ; k < n - 1 ; k++){
                    for(int h = j + 1 ; h < m - 1 ; h++){
                        if(table[i][j] == table[k][h] || table[k][h] == table[n - 1][m - 1]){
                            continue;
                        }
                        ans++;
                    }
                }
            }
        }
        System.out.print(ans);
    }
}