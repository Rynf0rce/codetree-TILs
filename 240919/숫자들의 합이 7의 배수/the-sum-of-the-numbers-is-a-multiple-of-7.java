import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 50000;
    public static final int MUTIPLE_VALUE = 7;

    public static int[] arr = new int[MAX_LENGTH + 1];
    public static long[] prefixSum = new long[MAX_LENGTH + 1];
    public static TreeSet<Integer>[] remainIdxSet = new TreeSet[MUTIPLE_VALUE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 1 ; i <= N ; i++){
            arr[i] = sc.nextInt();
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        for(int i = 0 ; i < MUTIPLE_VALUE ; i++){
            remainIdxSet[i] = new TreeSet<Integer>();
        }

        for(int i = 0 ; i <= N ; i++){
            prefixSum[i] %= MUTIPLE_VALUE;
        }

        for(int i = 0 ; i <= N ; i++){
            remainIdxSet[(int)prefixSum[i]].add(i);
        }

        int maxVal = 0;
        for(int i = 0 ; i < MUTIPLE_VALUE ; i++){
            if(remainIdxSet[i].size() >= 2){
                // System.out.println(remainIdxSet[i].first() + " " + remainIdxSet[i].last());
                maxVal = Math.max(remainIdxSet[i].last() - remainIdxSet[i].first(), maxVal);
            }
        }
        System.out.print(maxVal);
    }
}