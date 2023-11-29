import java.util.*;

public class Main {
    public static int[] arr;

    public static int outRange(int num, int N){
        return N - (num + 2);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[3];
        for(int i = 0 ; i < 3 ; i++){
            arr[i] = sc.nextInt();
        }
        int output = (int)Math.pow(N,3);
        int exceptVal = 1;
        for(int i = 0 ; i < 3 ; i++){
            exceptVal *= outRange(arr[i], N);
        }
        System.out.print(output - exceptVal);
    }
}