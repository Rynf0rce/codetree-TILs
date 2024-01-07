import java.util.*;

public class Main {
    public static final int MAX_INPUT = 100;
    public static int[] arr = new int[MAX_INPUT];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 0 ; i < N ; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = N - 1 ; i > 0 ; i--){
            if(arr[i - 1] >= arr[i]){
                System.out.print(i);
                System.exit(0);
            }
        }

        System.out.println(0);
    }
}