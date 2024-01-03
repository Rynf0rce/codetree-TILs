import java.util.*;

public class Main {
    public static final int MAX_ELEMENT = 100;
    public static final int MAX_SUM = 10000;
    public static int[] elementArr = new int[MAX_ELEMENT];
    public static boolean[] DP = new boolean[MAX_SUM + 1];
    public static int n, m;

    public static void initialization(){
        DP[0] = true;
        for(int i = 1 ; i <= m ; i++){
            DP[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            elementArr[i] = sc.nextInt();
        }

        initialization();

        for(int i = 0 ; i < n ; i++){
            for(int j = m ; j >= 0 ; j--){
                if(j < elementArr[i] || !DP[j - elementArr[i]]){
                    continue;
                }

                DP[j] = true;
            }
        }

        // for(int i = 0 ; i <= m ; i++){
        //     System.out.print(DP[i] ? "Yes" : "No");
        // }

        System.out.print(DP[m] ? "Yes" : "No");
    }
}