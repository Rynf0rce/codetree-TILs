import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static int[] arr = new int[MAX_RANGE];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0 ; i < N ; i++){
            arr[i] = sc.nextInt();
        }
        int totalcnt = N - 1;
        for(int i = N - 1 ; i >= 1 ; i--){
            if(arr[i] - arr[i-1] == 1){
                totalcnt--;
            }
        }
        System.out.println(totalcnt);
    }
}