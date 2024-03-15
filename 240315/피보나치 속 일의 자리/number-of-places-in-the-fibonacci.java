import java.util.*;
public class Main {
    public static final int MAX_LENGTH = 1000;
    public static int[] arr = new int[MAX_LENGTH];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        for(int i = 2 ; i < n ; i++){
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        for(int i = 0 ; i < n ; i++){
            System.out.print(arr[i] % 10 + " ");
        }
    }
}