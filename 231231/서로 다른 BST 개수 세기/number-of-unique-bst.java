import java.util.*;

public class Main {
    public static final int MAX_INPUT = 19;
    public static int[] arr = new int[MAX_INPUT + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr[0] = 1;

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= i ; j++){
                arr[i] += arr[j - 1] * arr[i - j];
            }
        }

        System.out.println(arr[n]);
    }
}