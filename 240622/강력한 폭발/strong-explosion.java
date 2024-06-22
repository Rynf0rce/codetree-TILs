import java.util.*;

public class Main {
    public static final int MAX_RANGE = 20;
    public static boolean[][] arr2D = new boolean[MAX_RANGE][MAX_RANGE];
    public static boolean[][] temp2D = new boolean[MAX_RANGE][MAX_RANGE];
    public static ArrayList<boolean[][]> list = new ArrayList<boolean[][]>();
    public static int[] arrR = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] arrC = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    public static int n;
    public static int numOfBoom = 0;


    // https://stackoverflow.com/questions/1564832/how-do-i-do-a-deep-copy-of-a-2d-array-in-java
    public static boolean[][] deepCopy(boolean[][] original) {
        if (original == null) {
            return null;
        }

        final boolean[][] result = new boolean[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }

    public static boolean inRange(int row, int column){
        return (row >= 0 && column >= 0 && row < n && column < n);
    }

    public static int explodedArea(){
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(list.get(list.size() -1)[i][j]){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void resetArea(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                temp2D[i][j] = false;
            }
        }
    }

    public static void stickBoom(int row, int col){
        resetArea();
        temp2D = deepCopy(list.get(list.size() - 1));

        for(int i = -2 ; i <= 2 ; i++){
            if(inRange(row + arrR[3] * i, col)){
                temp2D[row + arrR[3] * i][col] = true;
            }
        }
        list.add(deepCopy(temp2D));
    }

    public static void crossBoom(int row, int col){
        resetArea();
        temp2D = deepCopy(list.get(list.size() - 1));
        temp2D[row][col] = true;
        for(int i = 0 ; i < arrR.length ; i += 2){
            if(inRange(row + arrR[i], col + arrC[i])){
                temp2D[row + arrR[i]][col + arrC[i]] = true;
            }
        }
        list.add(deepCopy(temp2D));
    }

    public static void diagonalBoom(int row, int col){
        resetArea();
        temp2D = deepCopy(list.get(list.size() - 1));
        temp2D[row][col] = true;
        for(int i = 1 ; i < arrR.length ; i += 2){
            if(inRange(row + arrR[i], col + arrC[i])){
                temp2D[row + arrR[i]][col + arrC[i]] = true;
            }
        }
        list.add(deepCopy(temp2D));
    }

    public static int conFnc(int row, int col){

        int maxVal = 0;
        if(col >= n){
            row++;
            col = 0;
        }

        if(list.size() >= numOfBoom + 1){
            int wreaked = explodedArea();
            return wreaked;
        }

        if(arr2D[row][col]){
            stickBoom(row, col);
            maxVal = Math.max(maxVal, conFnc(row, col+1));
            list.remove(list.size() - 1);
            
            crossBoom(row, col);
            maxVal = Math.max(maxVal, conFnc(row, col+1));
            list.remove(list.size() - 1);

            diagonalBoom(row, col);
            maxVal = Math.max(maxVal, conFnc(row, col+1));
            list.remove(list.size() - 1);
        }
        else{
            maxVal = Math.max(maxVal, conFnc(row, col+1));
        }

        return maxVal;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                int input = sc.nextInt();
                if(input == 1){
                    arr2D[i][j] = true;
                    numOfBoom++;
                }
            }
        }

        list.add(deepCopy(arr2D));
        
        System.out.println(conFnc(0,0));
    }
}