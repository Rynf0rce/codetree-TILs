import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[][] table = new int[MAX_LENGTH][MAX_LENGTH];
    public static boolean[][] visited = new boolean[MAX_LENGTH][MAX_LENGTH];
    public static int N = 0;
    public static int INVAILD = (int) -1e9;

    public static void clear(){
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                visited[i][j] = false;
            }
        }
    }


    public static int search(int row, int col, boolean flag){
        int cnt = 0;
        boolean triger = false;
        
        for(int i = col ; i < col + 3 ; i++){
            if(visited[row][i]){
                continue;
            }
            cnt += table[row][i];
            if(!flag){
                visited[row][i] = true;
            }
        }

        if(flag){
            return cnt;
        }

        int maxVal = 0;

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N - 2 ; j++){
                if(visited[i][j]){
                    // System.out.println("check" + " " + i + " " + j);
                    continue;
                }
                maxVal = Math.max(maxVal, search(i, j, true));
                // System.out.println(i + " " + j + " " + search(i, j, true));
            }
        }

        for(int i = col ; i < col + 3 ; i++){
            visited[row][col] = false;
        }

        return cnt + maxVal;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N - 2; j++){
                clear();
                ans = Math.max(ans, search(i, j, false));
                // System.out.println(i + " " + j + " " + ans);
            }
        }

        // System.out.print(search(0, 0, false));
        System.out.print(ans);
    }
}