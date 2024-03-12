import java.util.*;
public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[] arr = new int[MAX_LENGTH + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = n - 1 ; i >= 0 ; i--){
            System.out.print(arr[i] + " ");
        }
    }
}