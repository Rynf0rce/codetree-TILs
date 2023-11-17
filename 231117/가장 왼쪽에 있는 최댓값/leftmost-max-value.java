import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int maxVal = 0, pointer = 0, idx = arr.length;
        for(int i = 0; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        while(true){
            maxVal = 0;
            for(int i = 0 ; i < idx ; i++){
                if(arr[i] > maxVal){
                    maxVal = arr[i];
                    pointer = i;
                }
            }

            System.out.print(pointer + 1 + " ");
            idx = pointer;

            if(idx > 0){
                continue;
            }
            else{
                break;
            }
        }   
    }
}