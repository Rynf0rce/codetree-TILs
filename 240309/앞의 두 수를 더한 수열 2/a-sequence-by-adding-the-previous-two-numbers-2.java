import java.util.*;

public class Main {
    public static final int MAX_INT = 90;
    public static long[] DP = new long[MAX_INT + 1];
    public static long findAns(int i){
        if(DP[i] != -1){
            return DP[i];
        }

        if(i <= 2){
            return DP[i] = 1;
        }

        return DP[i] = findAns(i - 1) + findAns(i - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1 ; i <= n ; i++){
            DP[i] = -1;
        }
        System.out.print(findAns(n));
    }
}