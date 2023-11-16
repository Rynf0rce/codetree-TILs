import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int sum = 0, cnt = 0;
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 1 ; i < arr.length ; i += 2){
            sum += arr[i];
            cnt++;
        }
        System.out.printf("%d %.1f", sum, (double)sum / cnt);
    }
}