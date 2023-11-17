import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputVal = sc.nextInt();
        int[] arr = new int[inputVal];
        int pointer = 0,  temp = 0;
        for(int i = 0; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        final int INT_MIN = Integer.MIN_VALUE;
        int maxVal = INT_MIN;
        
        for(int i = 0 ; i < arr.length ; i++ ){
            pointer = i;
            maxVal = INT_MIN;
            for(int j = i ; j < arr.length ; j++){
                if(maxVal < arr[j]){
                    maxVal = arr[j];
                    pointer = j;
                }
            }

            if(pointer != i){
                arr[pointer] = arr[i];
                arr[i] = maxVal;
            }
        }
        System.out.printf("%d %d", arr[0], arr[1]);
    }
}