import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
    
        int maxVal = Integer.MIN_VALUE;
        int calVal = 0;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr.length ; j++){
                if( !(j >= (i-1) && j <= (i+1)) ){
                    calVal = arr[i] + arr[j];
                    maxVal = Math.max(maxVal, calVal);
                }
            }
        }
        System.out.print(maxVal);
    }
}