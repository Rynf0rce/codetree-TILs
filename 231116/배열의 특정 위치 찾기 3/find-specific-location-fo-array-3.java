import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];
        int i = 0;
        for( ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
            if(arr[i] == 0){
                break;
            }
        }
        System.out.print(arr[i-1] + arr[i-2] + arr[i-3]);
    }
}