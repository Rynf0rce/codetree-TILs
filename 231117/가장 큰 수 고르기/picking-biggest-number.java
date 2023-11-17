import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        final int INT_MIN = Integer.MIN_VALUE;
        int maxVal = INT_MIN;

        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
            if(maxVal < arr[i]){
                maxVal = arr[i];
            }
        }
        System.out.print(maxVal);
    }
}