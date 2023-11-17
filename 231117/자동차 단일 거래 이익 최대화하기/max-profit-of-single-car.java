import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfInt = sc.nextInt();
        int[] arr = new int[numOfInt];
        int minVal = Integer.MAX_VALUE, idxMin = 0, maxVal = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
            if(arr[i] < minVal){
                minVal = arr[i];
                idxMin = i;
            }
        }
        for(int i = idxMin ; i < arr.length ; i++){
            if(arr[i] > maxVal){
                maxVal = arr[i];
            }
        }

        System.out.print(maxVal - minVal);
        
    }
}