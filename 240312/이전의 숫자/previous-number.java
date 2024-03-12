import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[] arr = new int[MAX_LENGTH + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int idx = 0;
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
            if(arr[i] == 0){
                idx = i;
                break;
            }
        }

        int sum = 0;
        for(int i = idx - 1 ; i >= idx - 5 ; i--){
            sum += arr[i];
        }
        System.out.print(sum);
    }
}