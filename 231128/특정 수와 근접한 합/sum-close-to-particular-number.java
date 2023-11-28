import java.util.*;

public class Main {
    public static int[] arr;

    public static int exceptSum(int a, int b){
        int sum = 0;
        for(int i = 0; i < arr.length ; i++){
            if(i == a || i == b){
                continue;
            }
            sum += arr[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), S = sc.nextInt(), minVal = Integer.MAX_VALUE;
        arr = new int[N];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        
        for(int i = 0; i < arr.length -1 ; i++){
            for(int j = i + 1 ; j < arr.length; j++){
                minVal = Math.min(minVal, Math.abs(S - exceptSum(i,j)));
            }
        }
        System.out.print(minVal);
    }
}