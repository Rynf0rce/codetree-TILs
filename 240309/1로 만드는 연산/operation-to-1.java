import java.util.*;

public class Main {
    public static final int MAX_INT = 1000000;
    public static final int[] DP = new int[MAX_INT + 1];
    public static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 2 ; i <= n ; i++){
            DP[i] = MAX_INT;

            if(i % 2 == 0){
                DP[i] = Math.min(DP[i], DP[i / 2] + 1);
            }

            if(i % 3 == 0){
                DP[i] = Math.min(DP[i], DP[i / 3] + 1);
            }

            DP[i] = Math.min(DP[i], DP[i - 1] + 1);
        }

        System.out.print(DP[n]);  
    }
}