import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputVal = sc.nextInt(), cnt = 0;
        int[] arr = new int[100];
        final int INT_MAX = Integer.MAX_VALUE;
        int minVal = INT_MAX;

        for(int i = 0 ; i < inputVal ; i++){
            arr[i] = sc.nextInt();
            if(minVal > arr[i]){
                minVal = arr[i];
                cnt = 1;
            }
            else if(minVal == arr[i]){
                cnt++;
            }
        }
        System.out.printf("%d %d", minVal, cnt);
    }
}