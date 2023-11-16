import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int i = 0, sum = 0;
        for(  ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
            if(arr[i] == 0){
                break;
            }
        }
        for(int j = i-1 ; j >= 0 ; j--){
            sum += arr[j];
        }
        System.out.printf("%d %.1f", sum, (double) sum / i);
    }
}