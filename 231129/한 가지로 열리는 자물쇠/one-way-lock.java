import java.util.*;

public class Main {
    public static int[] arr;

    public static int outRange(int num, int N){
        int output = 0;
        for(int i = 1 ; i <= N ; i++){
            if(i >= num - 2 && i <= num + 2){
                continue;
            }
            else{
                output++;
            }
        }
        return output;
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