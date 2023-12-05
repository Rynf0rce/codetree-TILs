import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), maxVal = Integer.MIN_VALUE;
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        maxVal = Math.max(arr[n-1] * arr[n-2] * arr[n-3], arr[n-1] * arr[0] * arr[1]);
        System.out.println(maxVal);
    }
}