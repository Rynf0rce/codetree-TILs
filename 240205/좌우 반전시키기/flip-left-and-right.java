import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static boolean[] arr = new boolean[MAX_LENGTH];
    public static int[] arrX = new int[]{-1, 0, 1};

    public static int n;

    public static void reverse(int idx){
        for(int i = 0 ; i < 3 ; i++){
            int curIdx = idx + arrX[i];
            if(curIdx < 0 || curIdx >= n){
                continue;
            }

            if(arr[curIdx]){
                arr[curIdx] = false;
            }
            else{
                arr[curIdx] = true;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            if(num == 1){
                arr[i] = true;
            }
        }

        int cnt = 0;
        for(int i = 1 ; i < n ; i++){
            if(!arr[i - 1]){
                reverse(i);
                cnt++;
            }
        }

        System.out.print(arr[n - 1] ? cnt : -1);
    }
}