import java.util.*;

public class Main {
    public static final int NUM_OF_PIGEON = 10;
    public static int[][] arr2D;
    public static int[] rightArr = new int[NUM_OF_PIGEON + 1];
    public static int[] leftArr = new int[NUM_OF_PIGEON + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr2D = new int[N][2];
        for(int i = 0 ; i < arr2D.length ; i++){
            arr2D[i][0] = sc.nextInt();
            arr2D[i][1] = sc.nextInt();
        }

        for(int i = 0 ; i < arr2D.length ; i++){
            if(arr2D[i][1] == 0 && leftArr[arr2D[i][0]] < rightArr[arr2D[i][0]] + 1){
                leftArr[arr2D[i][0]]++;
            }
            else if(arr2D[i][1] == 1 && rightArr[arr2D[i][0]] < leftArr[arr2D[i][0]] + 1){
                rightArr[arr2D[i][0]]++;
            }
        }

        int sum = 0;
        for(int i = 1 ; i <= NUM_OF_PIGEON ; i++){
            sum += Math.min(rightArr[i], leftArr[i]);
        }
        System.out.println(sum);
    }
}