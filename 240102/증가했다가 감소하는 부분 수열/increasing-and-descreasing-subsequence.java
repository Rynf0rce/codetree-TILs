import java.util.*;

public class Main {
    public static final int MAX_RANGE = 1000;
    public static final int INVAILED = Integer.MIN_VALUE;
    public static int[] arr = new int[MAX_RANGE + 1];
    public static int[] plusDP = new int[MAX_RANGE + 1];
    public static int[] minusDP = new int[MAX_RANGE + 1];

    public static int n;

    public static void initialize(){
        for(int i = 0 ; i < n ; i++){
            plusDP[i] = 1;
            minusDP[i] = 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        initialize();

        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(arr[i] == arr[j] ){
                    continue;
                }

                if((arr[i] > arr[j])){
                    plusDP[i] = Math.max(plusDP[i], plusDP[j] + 1);
                }
                else{
                    minusDP[i] = Math.max(minusDP[i], plusDP[j] + 1);
                    minusDP[i] = Math.max(minusDP[i], minusDP[j] + 1);
                }
            }
        }

        int output = INVAILED;

        for(int i = 1 ; i < n ; i++){
            output = Math.max(output, plusDP[i]);
            output = Math.max(output, minusDP[i]);
            // System.out.println(i + " " + plusDP[i] + " " + minusDP[i]);
        }

        System.out.print(output);
    }
}