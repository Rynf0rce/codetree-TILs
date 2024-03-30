import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 20;
    public static boolean[][] table = new boolean[MAX_LENGTH][MAX_LENGTH];
    public static int n = -1;

    public static int findAns(int row, int col){

        if(col + 2 >= n){
            return -100;
        }

        int ans = 0;
        for(int i = 0 ; i < 3 ; i++){
            if(table[row][col + i]){
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++){
                table[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
            }
        }

        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                for(int k = 0 ; k < n ; k++){
                    for(int h = 0 ; h < n ; h++){
                        if(i == k && ((j <= h && h < j + 3) || (j >= h && j < h + 3))){
                            continue;
                        }
                        ans = Math.max(ans, findAns(i, j) + findAns(k, h));
                    }
                }
            }
        }
        System.out.print(ans);
    }
}