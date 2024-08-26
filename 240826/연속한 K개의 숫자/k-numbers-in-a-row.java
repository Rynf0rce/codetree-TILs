import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static final int[] exceptArr = new int[MAX_LENGTH + 1];
    public static final int[] prefixSum = new int[MAX_LENGTH + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int B = sc.nextInt();
    
        for(int i = 0 ; i < B ; i++){
            int idx = sc.nextInt();
            exceptArr[idx] = 1;
        }

        for(int i = 1 ; i <= N ; i++){
            prefixSum[i] = prefixSum[i - 1] + exceptArr[i];
        }

        int minVal = MAX_LENGTH;
        for(int i = 1 ; i <= N - K + 1 ; i++){
            int exceptValue = prefixSum[i + K - 1] - prefixSum[i - 1];
            minVal = Math.min(minVal, exceptValue);
        }
        System.out.println(minVal);
    }
}