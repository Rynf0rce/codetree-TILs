import java.util.*;
import java.io.*;

public class Main {
    public static int MAX_LENGTH = 50;
    public static int[][] origin = new int[MAX_LENGTH][MAX_LENGTH];
    public static int[][] target = new int[MAX_LENGTH][MAX_LENGTH];

    public static int n = -1;
    public static int m = -1;

    public static boolean inRange(int row, int col){
        return row >= 0 && col >= 0 && row < n && col < m;
    }

    public static void reverse(int row, int col){
        for(int i = row - 1 ; i <= row + 1 ; i++){
            for(int j = col - 1 ; j <= col + 1 ; j++){
                if(inRange(i, j)){
                    origin[i][j] = (origin[i][j] == 1 ? 0 : 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < m ; j++){
                origin[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < m ; j++){
                target[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for(int i = 1 ; i < n - 1 ; i++){
            for(int j = 1 ; j < m - 1 ; j++){
                if(origin[i - 1][j - 1] != target[i - 1][j - 1]){
                    ans++;
                    reverse(i, j);
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(origin[i][j] != target[i][j]){
                    System.out.print(-1);
                    System.exit(0);
                }
            }
        }

        System.out.print(ans);
    }
}