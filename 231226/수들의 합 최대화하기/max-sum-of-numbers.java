import java.util.*;

public class Main {
    public static final int MAX_RANGE = 10;
    public static int[][] table = new int[MAX_RANGE][MAX_RANGE];
    public static ArrayList<Integer> vector = new ArrayList<>();
    public static boolean[] arrRow = new boolean[MAX_RANGE];
    public static boolean[] arrCol = new boolean[MAX_RANGE];
    public static int n;
    public static int maxVal = Integer.MIN_VALUE;

    public static int calculate(){
        int output = 0;
        for(int i = 0 ; i < vector.size() ; i++){
            output += vector.get(i);
        }

        return output;
    }
    
    public static void findValue(int row){
        if(vector.size() >= n){
            maxVal = Math.max(maxVal, calculate());
            return;
        }

        for(int i = 0 ; i < n ; i++){
            if(arrCol[i]){
                continue;
            }

            arrCol[i] = true;
            vector.add(table[row][i]);
            findValue(row + 1);
            vector.remove(vector.size() - 1);
            arrCol[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                table[i][j] = sc.nextInt();
            }
        }

        findValue(0);

        System.out.print(maxVal);
    }
}