import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();

        long start = 1;
        long end = 1500000000;
        long ans = 0;
        while(start <= end){
            long mid = (start + end) / 2;
            long sumToMid = (mid * (mid + 1)) / 2;
            if(sumToMid <= s){
                start = mid + 1;
                ans = Math.max(ans, mid);
            }
            else{
                end = mid - 1;
            }
        }
        System.out.print(ans);
    }
}