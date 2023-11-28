import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt(), maxVal = Integer.MIN_VALUE;
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0 ; i < arr.length - 2 ; i++){
            int currentVal = arr[i] + arr[i+1] + arr[i+2];
            maxVal = Math.max(maxVal,currentVal);
        }
        System.out.print(maxVal);
    }
}