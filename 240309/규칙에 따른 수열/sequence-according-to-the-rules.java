import java.util.*;

public class Main {
    public static final int MAX_INT = 35;
    public static long[] DP = new long[MAX_INT + 1];

    public static long findVal(int idx){
        if(DP[idx] != 0){
            return DP[idx];
        }

        for(int i = 0 ; i < idx ; i++){
            DP[idx] += findVal(i) * findVal(idx - i - 1);
        }

        return DP[idx];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DP[0] = 1;
        System.out.print(findVal(n));
    }
}