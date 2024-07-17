import java.util.*;

public class Main {
    public static final int INPUT_RANGE = 100000;
    public static double[] arr = new double[INPUT_RANGE * 2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < 2 * n ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, 0 , 2 * n);
    
        double minVal = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            minVal = Math.min(minVal,(arr[n + i] - arr[i]));
        }
        System.out.println((int)minVal);
        
    }
}