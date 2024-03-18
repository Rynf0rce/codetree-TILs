import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 20;
    public static int[] DP = new int[MAX_LENGTH + 1];

    public static int fibonacci(int idx){
        if(DP[idx] >= 0){
            return DP[idx];
        }

        return DP[idx] = fibonacci(idx - 1) + fibonacci(idx - 2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i <= n ; i++){
            DP[i] = -1;
        }

        DP[0] = 0;
        DP[1] = 1;

        System.out.print(fibonacci(n));
    }
}