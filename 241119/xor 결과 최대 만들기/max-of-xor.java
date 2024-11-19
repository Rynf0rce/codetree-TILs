import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[] input;
    public static int maxVal = Integer.MIN_VALUE;


    public static void combination(int idx, int cnt, int currVal){
        if(cnt >= m){
            maxVal = Math.max(maxVal, currVal);
            return;
        }

        if(idx >= n){
            return;
        }
        
        combination(idx + 1, cnt, currVal);

        combination(idx + 1, cnt + 1, currVal ^ input[idx]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        input = new int[n];

        for(int i = 0 ; i < n ; i++){
            input[i] = sc.nextInt();
        }

        combination(0, 0, 0);
        System.out.print(maxVal);
    }
}