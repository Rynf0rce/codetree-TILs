import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];
        final int INT_MIN = Integer.MIN_VALUE;
        final int INT_MAX = Integer.MAX_VALUE;
        int minVal = INT_MAX, maxVal = INT_MIN, idx = 0;

        for( ; idx < arr.length ; idx++){
            try{
                arr[idx] = sc.nextInt();
                }catch(NoSuchElementException e){
                        break;
                }
        }

        for(int i = 0 ; i < idx ; i++ ){
            if(arr[i] == 999 || arr[i] == -999){
                break;
            }
            if(arr[i] < minVal){
                minVal = arr[i];
            }
            if(arr[i] > maxVal){
                maxVal = arr[i];
            }
        }
        System.out.printf("%d %d", maxVal, minVal);
    }
}