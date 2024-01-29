import java.util.*;

public class Main {
    public static final int MAX_INPUT = 10000;
    public static final int MAX_INT = 100000;
    public static int[] arr = new int[MAX_INPUT];

    public static boolean isPossible(int target, int n, int m){
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            cnt += arr[i] / target;
        }
        return cnt >= m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        int start = 1;
        int end = MAX_INT;
        int ans = 0;
        while(start <= end){
            int mid = (end + start) / 2;
            if(isPossible(mid, n, m)){
                start = mid + 1;
                ans = Math.max(ans, mid);
            }
            else{
                end = mid - 1;
            }
        }

        System.out.println(ans);
    }
}