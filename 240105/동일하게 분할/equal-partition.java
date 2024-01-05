import java.util.*;

public class Main {
    public static final int MAX_NUM = 100;
    public static final int MAX_INT = 1000;

    public static int[] arr = new int[MAX_NUM];
    public static boolean[] DP = new boolean[MAX_NUM * MAX_INT + 1];
    
    public static int n, total;

    public static void initialize(){
        DP[0] = true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        initialize();

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = total ; j >= 0 ; j--){
                if(j - arr[i] < 0 || !DP[j - arr[i]]){
                    continue;
                }

                DP[j] = true;
            }
        }

        for(int i = 1 ; i <= total / 2 ; i++){
            if(DP[i] && total - 2 * i == 0){
                System.out.print("Yes");
                System.exit(0);
            }
        }

        System.out.print("No");
        
    }
}