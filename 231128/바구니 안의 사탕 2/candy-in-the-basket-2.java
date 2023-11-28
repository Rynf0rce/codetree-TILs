import java.util.*;

public class Main {
    public static final int TOTAL_BASKET = 100;
    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt(), currentVal = 0, maxVal = Integer.MIN_VALUE;
        arr = new int[TOTAL_BASKET];
        for(int i = 0 ; i < N ; i++){
            int num = sc.nextInt();
            int location = sc.nextInt();
            arr[location - 1] += num;
        }

        for(int i = 0 ; i < TOTAL_BASKET - 2 * K ; i++){
            currentVal = 0;
            for(int j = 0 ; j <= 2 * K ; j++){
                currentVal += arr[j];
            }
            maxVal = Math.max(maxVal, currentVal);
        }
        System.out.println(maxVal);
    }
}