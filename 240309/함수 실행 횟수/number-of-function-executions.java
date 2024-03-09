import java.util.*;

public class Main {
    public static final int MOD = 1000000007;
    public static final int MAX_INT = 50;
    public static int n = -1;
    public static int[] DP = new int[MAX_INT + 1];

    public static int codetree(int n){
        if(DP[n] != -1){
            return DP[n];
        }

        if(n < 2){
            return DP[n] = 1;
        }
        else{
            return DP[n] = (1 + codetree(n - 1) + codetree(n - 2))% MOD;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0 ; i <= n ; i++){
            DP[i] = -1;
        }
        codetree(n);
        System.out.print(DP[n]);
    }
}