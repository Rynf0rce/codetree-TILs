import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfInt = sc.nextInt();
        int[] arr = new int[numOfInt];
        int minVal = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i + 1 ; j < arr.length ; j++){
                if( (arr[j] - arr[i]) < minVal){
                    minVal = arr[j] - arr[i];
                }
            }
        }
        System.out.print(minVal);
    }
}