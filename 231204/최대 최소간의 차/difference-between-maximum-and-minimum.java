import java.util.*;

public class Main {
    public static final int NUM_RANGE = 10000;
    public static int[] arr;
    public static int cost(int start, int end){
        int output = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] < start){
                output += start - arr[i];
            }
            else if(arr[i] > end){
                output += arr[i] - end;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt(), minVal = Integer.MAX_VALUE;
        arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0 ; i < NUM_RANGE ; i++){
            minVal = Math.min(minVal, cost(i, i+k));   
        }
        System.out.println(minVal);
    }
}