import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 500;
    public static boolean[][] table = new boolean[MAX_LENGTH + 10 + 1][MAX_LENGTH + 10 + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            for(int j = row ; j < row + 10 ; j++){
                for(int k = col ; k < col + 10 ; k++){
                    table[j][k] = true;
                }
            }
        }

        int ans = 0;
        for(int i = 0 ; i < MAX_LENGTH + 10 + 1 ; i++){
            for(int j = 0 ; j < MAX_LENGTH + 10 + 1; j++){
                if(table[i][j]){
                    ans++;
                }
            }
        }
        System.out.print(ans);
    }
}