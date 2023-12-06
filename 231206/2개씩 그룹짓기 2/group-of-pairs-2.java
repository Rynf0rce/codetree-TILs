import java.util.*;

public class Main {
    public static final int INPUT_RANGE = 100000;
    public static double[] arr = new double[INPUT_RANGE];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, 0 , n);
    
        double maxVal = Integer.MIN_VALUE;
        for(int i = 0 ; i < n / 2 ; i++){
            maxVal = Math.max(maxVal,(arr[n/2 + i] - arr[i]));
        }
        System.out.println((int)maxVal);
        
    }
}