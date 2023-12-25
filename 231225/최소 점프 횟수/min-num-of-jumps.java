import java.util.*;

public class Main {
    public static final int MAX_RANGE = 10;
    public static int[] arr = new int[MAX_RANGE];
    public static int n;
    public static int minVal = Integer.MAX_VALUE;

    public static void jump(int idx, int cnt){
        if(idx > n){
            return;
        }

        if(idx == n){
            minVal = Math.min(minVal, cnt);
        }

        for(int i = arr[idx] ; i > 0 ; i--){
            jump(idx + i, cnt + 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt() - 1;
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        jump(0, 0);

        System.out.println(minVal == Integer.MAX_VALUE ? -1 : minVal);

    }
}