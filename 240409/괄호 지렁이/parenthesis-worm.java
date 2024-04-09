import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 5;
    public static boolean[][] table = new boolean[MAX_LENGTH][MAX_LENGTH];
    public static boolean[][] visited = new boolean[MAX_LENGTH][MAX_LENGTH];
    public static int[] arrRow = new int[]{-1, 0, 1, 0};
    public static int[] arrCol = new int[]{0, 1, 0, -1};
    public static Stack<Boolean> s = new Stack<>();
    public static int ans = 0;

    public static int n = -1;
    
    public static boolean inRange(int row, int col){
        return row >= 0 && col >= 0 && row < n && col < n;
    }

    public static void findAns(int row, int col, int hold, boolean triger){
        if(!triger && s.size() == hold * 2){
            ans = Math.max(ans, s.size());
        }

        for(int i = 0 ; i < n ; i++){
            int postRow = row + arrRow[i];
            int postCol = col + arrCol[i];
            if(inRange(postRow, postCol) && !visited[postRow][postCol]){
                visited[postRow][postCol] = true;
                if(s.peek()  && s.peek() == table[postRow][postCol]){
                    s.push(table[postRow][postCol]);
                    findAns(postRow, postCol, hold + 1, true);
                    s.pop();
                }
                else if(s.peek()&& s.peek() != table[postRow][postCol]){
                    s.push(table[postRow][postCol]);
                    findAns(postRow, postCol, hold, false);
                    s.pop();
                }
                else if(!s.peek() && s.peek() == table[postRow][postCol]){
                    s.push(table[postRow][postCol]);
                    findAns(postRow, postCol, hold, false);
                    s.pop();
                }
                visited[postRow][postCol] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < n ; j++){
                if(str.charAt(j) == '('){
                    table[i][j] = true;
                }
            }
        }

        if(table[0][0]){
            s.push(table[0][0]);
            visited[0][0] = true;
            findAns(0, 0, 1, true);
        }
        
        System.out.print(ans);

    }
}