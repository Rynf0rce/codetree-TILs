import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int maxGap = Integer.MIN_VALUE;
        for(int i = 1 ; i < arr.length ; i++){
            maxGap = Math.max(maxGap, arr[i] - arr[i-1]);
        }
        System.out.println(maxGap-1);
    }
}