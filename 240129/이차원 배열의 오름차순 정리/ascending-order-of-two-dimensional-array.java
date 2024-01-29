import java.util.*;

public class Main {
    public static int n, k;
    public static int myIdx(int num){
        int idx = 0;
        for(int i = 1 ; i <= n ; i++){
            idx += Math.min(num, i * n) / i;
        }
        return idx;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int start = 1;
        int end = n * n;
        int mid = 0;
        int ans = n * n + 1;
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