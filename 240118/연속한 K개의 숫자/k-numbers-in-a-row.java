import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static final int[] inputArr = new int[MAX_LENGTH + 1];
    public static final boolean[] exceptArr = new boolean[MAX_LENGTH + 1];
    public static final int[] prefixSum = new int[MAX_LENGTH + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int B = sc.nextInt();
        
        for(int i = 1 ; i <= N ; i++){
            inputArr[i] = i;
        }

        for(int i = 0 ; i < B ; i++){
            int idx = sc.nextInt();
            exceptArr[idx] = true;
        }

        for(int i = 1 ; i <= N ; i++){
            if(exceptArr[i]){
                prefixSum[i] = prefixSum[i - 1] + 1;
            }
            else{
                prefixSum[i] = prefixSum[i - 1];
            }
        }

        // for(int i = 0 ; i <= N ; i++){
        //     System.out.print(prefixSum[i] + " ");
        // }
        // System.out.println();

        int minVal = MAX_LENGTH;
        for(int i = 1 ; i <= N - K + 1 ; i++){
            // System.out.println( (i + K - 1) + " " + prefixSum[i + K - 1] + " " + prefixSum[i]);
            int exceptValue = prefixSum[i + K - 1] - prefixSum[i];
            if(exceptArr[i]){
                exceptValue++;
            }
            minVal = Math.min(minVal, exceptValue);
        }

        System.out.println(minVal);
    }
}