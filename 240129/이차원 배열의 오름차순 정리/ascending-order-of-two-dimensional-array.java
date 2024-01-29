import java.util.*;

public class Main {
    public static long n, k;
    public static long myIdx(long num){
        long idx = 0;
        for(int i = 1 ; i <= n ; i++){
            if(num > i * n){
                idx += n;
            }
            else{
                idx += num / i;
            }
        }
        return idx;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        k = sc.nextLong();
        long start = 1;
        long end = n * n;
        long mid = 0;
        long ans = n * n + 1;
        while(start <= end){
            mid = (end + start) / 2;
            if(myIdx(mid) >= k){
                end = mid - 1;
                ans = Math.min(ans, mid);
            }
            else{
                start = mid + 1;
            }
        }
        System.out.println(ans);
    }
}