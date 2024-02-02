import java.util.*;

public class Main {
    public static int MAX_VALUE = 100000;
    public static int[] givenCoin = new int[]{2, 5};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int ans = MAX_VALUE / givenCoin[0] + 1;
        for(int i = n / givenCoin[1] ; i >= 0 ; i--){
            int num = n - i * givenCoin[1];
            if(num % givenCoin[0] == 0){
                ans = Math.min(ans, i + num / givenCoin[0]);
            }
        }

        System.out.print(ans == MAX_VALUE / givenCoin[0] + 1 ? -1 : ans);
    }
}