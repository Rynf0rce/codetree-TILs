import java.util.*;
public class Main {
    public static int[] arr = new int[9];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            int idx = sc.nextInt();
            arr[idx]++;
        }

        for(int i = 1 ; i <= 8 ; i++){
            System.out.printf("%d - %d\n", i, arr[i]);
        }
    }
}