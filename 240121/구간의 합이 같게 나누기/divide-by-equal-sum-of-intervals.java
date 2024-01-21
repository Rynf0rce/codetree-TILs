import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static final int[] arr = new int[MAX_LENGTH];
    public static final int[] leftArr = new int[MAX_LENGTH];
    public static final int[] rightArr = new int[MAX_LENGTH];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        leftArr[0] = arr[0];
        for(int i = 1 ; i < n ; i++){
            leftArr[i] = arr[i] + leftArr[i - 1];
        }

        rightArr[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0 ; i--){
            rightArr[i] = rightArr[i + 1] + arr[i];
        }

        // for(int i = 0 ; i < n ; i++){
        //     System.out.print(leftArr[i] + " ");
        // }
        // System.out.println();

        // for(int i = 0 ; i < n ; i++){
        //     System.out.print(rightArr[i] + " ");
        // }
        // System.out.println();

        int output = 0;

        for(int i = 0 ; i < n - 1 ; i++){
            if(leftArr[i] * 3 == rightArr[i + 1] || leftArr[i] / 3 == rightArr[i + 1]){
                output++;
            }
        }

        System.out.println(output);
    }
}