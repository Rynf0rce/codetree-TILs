import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static int[] arr = new int[MAX_RANGE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), minVal = 0, output = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        
        for(int i = 0 ; i < 2 * m + 1 ; i++){
            minVal = 0;
            int cnt = 0;
            boolean triger = false;
            for(int j = 0 ; j < n ; j++){
                cnt++;
                if(arr[j] == 1){
                    triger = true;
                }
                if(triger && ( cnt >= 2 * m + 1 || j == n - 1 || ( j < i && cnt == i ))){
                    minVal++;
                    triger = false;
                    cnt = 0;
                }
            }
            output = Math.min(output, minVal);
        }
        System.out.println(output);
    }
}