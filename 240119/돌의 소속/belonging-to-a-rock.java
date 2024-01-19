import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100000;
    public static final int MAX_GROUP = 3;
    public static int[][] prefixSum = new int[MAX_GROUP + 1][MAX_RANGE + 1];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        for(int i = 1 ; i <= N ; i++){
            int num = sc.nextInt();
            for(int j = 1 ; j <= MAX_GROUP ; j++){
                prefixSum[j][i] = prefixSum[j][i - 1];
                if(j == num){
                    prefixSum[j][i]++;
                }
                // System.out.println(j + " " + i + " " + prefixSum[j][i]);
            }
            // System.out.println("====");
        }

        for(int i = 0 ; i < Q ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            for(int j = 1 ; j <= MAX_GROUP ; j++){
                System.out.print( (prefixSum[j][b] - prefixSum[j][a - 1]) + " ");
            }
            System.out.println();
        }

    }
}