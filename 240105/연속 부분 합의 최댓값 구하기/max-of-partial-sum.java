import java.util.*;

public class Main {
    public static final int MAX_NUM = 100000;
    public static final int INVALUED = Integer.MIN_VALUE;
    public static int[] arr = new int[MAX_NUM + 1];
    public static int[] DP = new int[MAX_NUM + 1];
    public static int n;

    public static int setValue(int idx){
        return Math.max(DP[idx - 1] + arr[idx], arr[idx]);
    }

    public static void initialize(){
        DP[0] = 0;
        for(int i = 1 ; i <= n ; i++){
            DP[i] = INVALUED;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i  = 1 ; i <= n ; i++){
            arr[i] = sc.nextInt();
        }

        initialize();

        for(int i = 1 ; i <= n ; i++){
            DP[i] = setValue(i);
        }

        int maxVal = INVALUED;

        for(int i = 1 ; i <= n ; i++){
            maxVal = Math.max(maxVal, DP[i]);
        }

        System.out.println(maxVal);
    }
}