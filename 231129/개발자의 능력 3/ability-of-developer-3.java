import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0 , num = 6, minVal = Integer.MAX_VALUE;
        int[] arr = new int[num];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        for(int i = 0 ; i < arr.length - 2; i++){
            for(int j = i + 1 ; j < arr.length - 1 ; j++){
                for(int h = j + 1 ; h < arr.length ; h++){
                    minVal = Math.min(minVal, Math.abs(sum - 2 * (arr[i] + arr[j] + arr[h])));
                }
            }
        }
        System.out.print(minVal);
    }
}