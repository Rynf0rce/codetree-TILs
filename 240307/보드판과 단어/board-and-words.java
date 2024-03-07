import java.util.*;
import java.io.*;

class trieNode{
    trieNode[] children = new trieNode[26];
    boolean isEnd = false;
    public trieNode(){
        for(int i = 0 ; i < children.length ; i++){
            children[i] = null;
        }
    }
}

public class Main {
    public static final int BOARD_LENGTH = 4;
    public static final int NUM_OF_DIRECTION = 8;
    public static int[][] table = new int[BOARD_LENGTH][BOARD_LENGTH];
    public static boolean[][] visited = new boolean[BOARD_LENGTH][BOARD_LENGTH];
    public static int[] arrRow = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
    public static int[] arrCol = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
    public static trieNode root = new trieNode();
    public static int ans = 0;

    public static boolean inRange(int row, int col){
        return row >= 0 && col >= 0 && row < BOARD_LENGTH && col < BOARD_LENGTH;
    }

    public static void initialize(){
        for(int i = 0 ; i < BOARD_LENGTH ; i++){
            for(int j = 0 ; j < BOARD_LENGTH ; j++){
                visited[i][j] = false;
            }
        }
    }

    public static void findAns(int row, int col, int depth, trieNode t){
        if(visited[row][col]){
            return;
        }

        visited[row][col] = true;
        if(t.isEnd){
            ans = Math.max(ans, depth);
        }

        for(int i = 0 ; i < NUM_OF_DIRECTION ; i++){
            int postRow = row + arrRow[i];
            int postCol = col + arrCol[i];
            if(inRange(postRow, postCol) && t.children[table[postCol][postRow]] != null){
                findAns(postRow, postCol, depth + 1, t.children[table[postCol][postRow]]);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            String str = String.valueOf(st.nextToken());
            trieNode t = root;
            for(int j = 0 ; j < str.length() ; j++){
                int idx = str.charAt(j) - 'a';
                if(t.children[idx] == null){
                    t.children[idx] = new trieNode();
                }
                t = t.children[idx];
            }
            t.isEnd = true;
        }

        for(int i = 0 ; i < BOARD_LENGTH ; i++){
            char[] inArr = String.valueOf(br.readLine()).toCharArray();
            for(int j = 0 ; j < BOARD_LENGTH ; j++){
                table[i][j] = inArr[j] - 'a';
            }
        }

        for(int i = 0 ; i < BOARD_LENGTH ; i++){
            for(int j = 0 ; j < BOARD_LENGTH ; j++){
                initialize();
                findAns(i, j, 0, root);
            }
        }

        System.out.print(ans);
    }
}