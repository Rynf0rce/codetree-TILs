import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        final int INT_MAX = Integer.MAX_VALUE, INT_MIN = Integer.MIN_VALUE;
        int minVal = INT_MAX, maxVal = INT_MIN;

        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
            if(arr[i] < 500 && arr[i] > maxVal){
                maxVal = arr[i];
            }
            if(arr[i] > 500 && arr[i] < minVal){
                minVal = arr[i];
            }
        }
        System.out.printf("%d %d", maxVal, minVal);
    }
}