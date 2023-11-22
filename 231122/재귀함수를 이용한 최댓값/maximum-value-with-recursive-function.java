import java.util.*;

public class Main {
    public static int maximum(int[] arr, int n1){
        for(int i = 0 ; i < arr.length ; i++){
            if(n1 < arr[i]){
                return maximum(arr, arr[i]);
            }
        }
        return n1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i = 0; i < num ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print(maximum(arr, Integer.MIN_VALUE));
    }
}