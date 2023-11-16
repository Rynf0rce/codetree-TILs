import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int evenSum = 0, thirdSum = 0, cnt = 0;
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0 ; i < arr.length ; i++){
            if((i + 1) % 2 == 0){
                evenSum += arr[i];
            }
            if((i + 1) % 3 == 0){
                thirdSum += arr[i];
                cnt++;
            }
        }
        System.out.printf("%d %.1f", evenSum, (double)thirdSum / cnt);
    }
}