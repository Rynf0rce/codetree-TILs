import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 50000;
    public static final int MULTIPLE_VAL = 7;
    public static TreeSet<Integer>[] remainIdxSet = new TreeSet[7];
    public static int[] arr = new int[MAX_LENGTH];
    public static int[] prefixArr = new int[MAX_LENGTH];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for(int i = 0 ; i < N ; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0 ; i < MULTIPLE_VAL ; i++){
            remainIdxSet[i] = new TreeSet<Integer>();
        }

        prefixArr[0] = arr[0];
        for(int i = 1 ; i < N ; i++){
            prefixArr[i] = prefixArr[i - 1] + arr[i];
        }

        for(int i = 0 ; i < N ; i++){
            prefixArr[i] %= MULTIPLE_VAL;
            remainIdxSet[prefixArr[i]].add(i);
        }

        int maxVal = 0;
        for(int i = 0 ; i < MULTIPLE_VAL ; i++){
            if(remainIdxSet[i].size() >= 2){
                maxVal = Math.max(maxVal, remainIdxSet[i].last() - remainIdxSet[i].first());
            }
        }

        System.out.print(maxVal);
    }
}