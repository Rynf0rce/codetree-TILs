import java.util.*;

class shift implements Comparable<shift>{
    int start;
    int end;

    public shift(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(shift s){
        if(this.start == s.start){
            return this.end - s.end;
        }
        else{
            return this.start - s.start;
        }
    }
}

public class Main {
    public static final int MAX_RANGE = 1000;
    public static final int INVALIED = Integer.MIN_VALUE;
    public static shift[] arr = new shift[MAX_RANGE + 1];
    public static int[] DP = new int[MAX_RANGE + 1];
    public static int n;

    public static boolean notFold(shift s1, shift s2){
        return (s1.end < s2.start || s1.start > s2.end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr[0] = new shift(0, 0);

        for(int i = 1 ; i <= n ; i++){
            int start = sc.nextInt();
            int end =  sc.nextInt();
            int pay = sc.nextInt();
            arr[i] = new shift(start, end);
            DP[i] = pay;
        }

        Arrays.sort(arr, 0, n);
        
        for(int i = 1 ; i <= n ; i++){
            int curPay = DP[i];
            for(int j = 0 ; j < i ; j++){
                if(notFold(arr[i], arr[j])){
                    DP[i] = Math.max(DP[i], DP[j] + curPay);
                }
            }
        }

        int output = INVALIED;
        for(int i = 1 ; i <= n ; i++){
            output = Math.max(output, DP[i]);
            // System.out.print(DP[i] + " ");
        }
        System.out.print(output);
    }
}