import java.util.*;

public class Main {
    public static final int MAX_RANGE = 1000;
    public static int[] arr = new int[MAX_RANGE + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        arr[2] = 1;
        arr[3] = 1;
        for(int i = 4 ; i <= target ; i++){
            arr[i] = (arr[i - 2] + arr[i - 3]) % 10007;
        }
        System.out.println(arr[target]);
    }
}