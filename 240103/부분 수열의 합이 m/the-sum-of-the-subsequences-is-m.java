import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static final int MAX_INPUT = 10000;
    public static final int INVALUED = MAX_INPUT + 1;
    public static int[] arr = new int[MAX_RANGE + 1];
    public static int[] DP = new int[MAX_RANGE + 1];
    public static int n, m;

    public static void initialize(){
        for(int i = 1 ; i <= m ; i++){
            DP[i] = INVALUED;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1 ; i <= n ; i++){
            arr[i] = sc.nextInt();
        }

        initialize();

        for(int i = 1 ; i <= n; i++){
            for(int j = m ; j >= 0 ; j--){
                if(j < arr[i] || DP[j - arr[i]] == INVALUED){
                    continue;
                }

                DP[j] = Math.min(DP[j], DP[j - arr[i]] + 1);
            }
        }

        // for(int i = 0 ; i <= m ; i++){
        //     System.out.print(DP[i] + " ");
        // }

        System.out.print(DP[m] == INVALUED ? -1 : DP[m]);
    }
}