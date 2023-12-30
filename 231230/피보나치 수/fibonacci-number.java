import java.util.*;

public class Main {
    public static final int INPUT_RANGE = 45;
    public static int[] arr = new int[INPUT_RANGE + 1];

    public static int fibonacci(int n){ // Top-Down Approach
        if(arr[n] != -1){
            return arr[n];
        }
        else if(n <= 2){
            arr[n] = 1;
        }
        else{
            arr[n] = fibonacci(n -1) + fibonacci(n - 2);
        }
        return arr[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 1 ; i <= N ; i++){
            arr[i] = -1;
        }

        /* tabluation (Bottom-up)

        int[] tabulationArr = new int[N + 1];
        tabulationArr[1] = 1;
        tabulationArr[2] = 1;

        for(int i = 3 ; i <= N ; i++){
            tabulationArr[i] = tabulationArr[i - 1] +  tabulationArr[i - 2];
        }

        System.out.println(tabulationArr[N]);

        */

        System.out.println(fibonacci(N));
    }
}