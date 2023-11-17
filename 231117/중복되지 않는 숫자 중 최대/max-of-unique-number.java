import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputVal = sc.nextInt();
        int[] arr = new int[inputVal];
        int pointer = 0,  temp = 0;
        int[] cntArr = new int[1001];
        boolean overlap = false;
        for(int i = 0; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        final int INT_MIN = Integer.MIN_VALUE;
        int maxVal = INT_MIN;

        // arr = new int[]{3, 2, 3, 1};
        
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
            cntArr[maxVal]++;
        }
        // System.out.printf("%d %d %d %d", cntArr[1], cntArr[2], cntArr[3], cntArr[4]);
        for(int i = 0 ; i < arr.length ; i++){
            overlap = true;
            if(cntArr[arr[i]] == 1){
                // System.out.println("current : " + cntArr[arr[i]]);
                overlap = false;
                pointer = arr[i];
                break;
            }
        }
        System.out.print(overlap ? -1 : pointer);
    }
}