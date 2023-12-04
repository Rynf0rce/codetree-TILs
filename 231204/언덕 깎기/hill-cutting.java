import java.util.*;

public class Main {
    public static final int MAX_HEIGHT = 100;
    public static int[] arr;
    public static int cost(int start, int end){
        int output = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] < start){
                output += (start - arr[i]) * (start - arr[i]); 
            }
            else if(arr[i] > end){
                output += (end - arr[i]) * (end - arr[i]);
            }
        }
        return output;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), minVal = Integer.MAX_VALUE;
        arr = new int[N];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0 ; i <= MAX_HEIGHT - 17 ; i++){
            minVal = Math.min(minVal , cost(i, i+17));
        }
        System.out.print(minVal);
    }
}