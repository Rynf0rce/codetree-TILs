import java.util.*;

public class Main {
    public static final int MAX_COST = 100000;
    public static final int MAX_INT = (int)1e9;
    public static int[] DP = new int[MAX_COST + 1];
    public static int[] coin = new int[]{7, 5, 2, 1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1 ; i <= n ; i++){
            DP[i] = MAX_COST;
            for(int j = 0 ; j < coin.length ; j++){
                if(i - coin[j] >= 0){
                    DP[i] = Math.min(DP[i], DP[i - coin[j]] + 1);
                }
            }
        }
        System.out.print(DP[n]);
    }
}