import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 1000000;
    public static int[] pointArr = new int[MAX_LENGTH + 1];
    public static int[] prefixSum = new int[MAX_LENGTH + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        for(int i = 0 ; i < N ; i++){
            int idx = sc.nextInt();
            pointArr[idx] = 1;
        }

        for(int i = 1 ; i <= MAX_LENGTH ; i++){
            prefixSum[i] = prefixSum[i - 1] + pointArr[i];
        }

        for(int i = 0 ; i < Q ; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            System.out.println(prefixSum[B] - prefixSum[A - 1]);
        }
    }
}