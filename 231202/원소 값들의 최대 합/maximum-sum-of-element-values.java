import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        int maxVal = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            boolean[] chackArr = new boolean[n];
            int idx = i + 1;
            int sum = 0;
            for(int j = 0 ; j < m ; j++){
                chackArr[idx - 1] = true;
                idx = arr[idx - 1];
            }

            for(int j = 0 ; j < chackArr.length ; j++){
                if(chackArr[j]){
                    sum += arr[j];
                }
            }
            maxVal = Math.max(maxVal, sum);
        }

        System.out.print(maxVal);
    }
}