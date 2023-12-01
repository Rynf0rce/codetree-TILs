import java.util.*;

public class Main {
    public static final int NUM_OF_CUP = 3;
    public static boolean[] arr = new boolean[NUM_OF_CUP];
    public static void swap(int a, int b){
        a--;
        b--;
        boolean temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr2D = new int[N][NUM_OF_CUP];
        for(int i = 0 ; i < arr2D.length ; i++){
            for(int j = 0 ; j < arr2D[i].length ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }

        int maxVal = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            Arrays.fill(arr, false);
            arr[i] = true;
            int cnt = 0;
            for(int j = 0 ; j < arr2D.length ; j++){
                swap(arr2D[j][0], arr2D[j][1]);
                if(arr[arr2D[j][2]] == true){
                    cnt++;
                }
            }
            maxVal = Math.max(maxVal , cnt);
        }
        System.out.println(maxVal);
    }
}