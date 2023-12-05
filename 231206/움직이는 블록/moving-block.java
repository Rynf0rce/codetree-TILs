import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), sum = 0;
        int[] arr = new int[N];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        int average = sum / N, output = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(average > arr[i]){
                output += (average - arr[i]);
            }
        }
        System.out.println(output);
    }
}