import java.util.*;

public class Main {
    public static int[] arr;
    public static final int MAX_FIELD = 101;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), H = sc.nextInt(), T = sc.nextInt();
        arr = new int[MAX_FIELD];
        for(int i = 1 ; i <= N ; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, 1, N);

        int minVal = 0;
        while(T > 0){
            int curMinVal = Integer.MAX_VALUE;
            int curIdx = 0;
            for(int i = 1 ; i <= N ; i++){
                if(arr[i] > 0 && curMinVal > Math.abs(H - arr[i])){
                    curMinVal = Math.abs(H - arr[i]);
                    curIdx = i;
                }
            }
            arr[curIdx] = -1;
            minVal += curMinVal;
            T--;
        }
        System.out.print(minVal);
    }
}