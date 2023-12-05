import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), maxVal = Integer.MIN_VALUE;
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0 ; i < arr.length - 2 ; i++){
            for(int j = i + 1 ; j < arr.length - 1 ; j++){
                for(int k = j + 1 ; k < arr.length ; k++){
                    maxVal = Math.max(maxVal, arr[i]*arr[j]*arr[k]);
                }
            }
        }
        System.out.println(maxVal);
    }
}