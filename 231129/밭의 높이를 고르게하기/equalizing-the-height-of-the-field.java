import java.util.*;

public class Main {
    public static int[] arr;
    public static final int MAX_FIELD = 101;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), H = sc.nextInt(), T = sc.nextInt();
        arr = new int[MAX_FIELD];
        for(int i = 1 ; i <= N ; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, 1, N);

        int minVal = Integer.MAX_VALUE;
        for(int i = 1 ; i <= N - T + 1; i++){
            int curVal = 0;
            for(int j = i ; j < i + T ; j++){
                curVal += Math.abs(H - arr[j]);
            }
            minVal = Math.min(minVal, curVal);
        }
        System.out.print(minVal);
    }
}