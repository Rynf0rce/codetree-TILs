import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i = 1 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        int maxVal = Integer.MIN_VALUE;
        for(int i = 1 ; i < arr.length ; i++){
            int[] chackArr = new int[n+1];
            int idx = i;
            int sum = 0;
            for(int j = 0 ; j < m ; j++){
                chackArr[idx]++;
                idx = arr[idx];
            }

            for(int j = 1 ; j < chackArr.length ; j++){
                sum += arr[j] * chackArr[j];
            }
            maxVal = Math.max(maxVal, sum);
        }

        System.out.print(maxVal);
    }
}