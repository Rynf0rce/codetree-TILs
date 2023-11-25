import java.util.*;

public class Main {
    public static final int INPUT_MAX = 1000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[INPUT_MAX];
        int N = sc.nextInt(), maxVal = Integer.MIN_VALUE, curVal = 0;
        for(int i = 0 ; i < N ; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 1 ; i < N ; i++){
            curVal = arr[i] - arr[i-1];
            if(curVal > maxVal){
                maxVal = curVal;
            }
        }
        System.out.print(maxVal);
    }
}