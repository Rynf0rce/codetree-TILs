import java.util.*;

public class Main {
    public static int[] arr;
    public static int rangeSum(int start, int end){
        int sumVal = 0;
        for(int i = start ; i < end ; i++){
            sumVal += arr[i];
        }
        return sumVal;
    }
    public static int conFnc(int start, int dividedCnt){
        int minVal = Integer.MAX_VALUE;
        if(dividedCnt <= 0){
            return rangeSum(start, arr.length);
        }
        for(int i = start + 1 ; i <= arr.length - dividedCnt ; i++){
            int currentVal = Math.max(rangeSum(start, i), conFnc(i, dividedCnt - 1));
            minVal = Math.min(minVal, currentVal);
        }
        return minVal;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), minVal = Integer.MAX_VALUE;
        arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print(conFnc(0,m-1));
    }
}