import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 1000;
    public static int[] arr = new int[MAX_LENGTH + 1];
    public static int[] prefixSum = new int[MAX_LENGTH + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int i = 1 ; i <= n ; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 1 ; i <= n ; i++){
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int cnt = 0;
        for(int i = 0 ; i <= n ; i++){
            for(int j = i + 1 ; j <= n ; j++){
                if(k == prefixSum[j] - prefixSum[i]){
                    cnt++;
                }
            }
        }

        System.out.print(cnt);
    }
}