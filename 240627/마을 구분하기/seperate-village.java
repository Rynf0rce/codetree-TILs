import java.util.*;

public class Main {
    public static final int MAX_RANGE = 25;
    public static final int GO_METHOD = 4;
    public static int[][] table = new int[MAX_RANGE][MAX_RANGE];
    public static boolean[][] visited = new boolean[MAX_RANGE][MAX_RANGE];
    public static ArrayList<Integer> vector = new ArrayList<>();
    public static int[] arrR = new int[]{-1, 0, 1, 0};
    public static int[] arrC = new int[]{0, 1, 0, -1};
    public static int n;
    public static int peopleNums = 0;

    public static boolean inRange(int row, int col){
        return (row >= 0 && col >= 0 && row < n && col < n);
    }

    public static boolean canGo(int row, int col){
        if(!inRange(row, col)){
            return false;
        }

        if(table[row][col] == 0 || visited[row][col]){
            return false;
        }

        return true;
    }

    public static void seperate(int row, int col){
        if(!canGo(row, col)){
            return;
        }

        visited[row][col] = true;
        peopleNums++;
        
        for(int i = 0 ; i < GO_METHOD ; i++){
            int postRow = row + arrR[i];
            int postCol = col + arrC[i];
            seperate(postRow, postCol);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                table[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                peopleNums = 0;
                seperate(i,j);
                if(peopleNums != 0){
                    vector.add(peopleNums);
                }
            }
        }

        Collections.sort(vector);

        System.out.println(vector.size());

        for(int i = 0 ; i < vector.size() ; i++){
            System.out.println(vector.get(i));
        } 
    }
}