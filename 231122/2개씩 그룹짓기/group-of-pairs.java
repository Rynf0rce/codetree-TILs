import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), maxVal = Integer.MIN_VALUE;
        int[] arr = new int[num*2];
        for(int i = 0; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for(int i = 0 ; i < arr.length / 2 ; i++){
            if(maxVal < arr[i] + arr[arr.length - 1 - i]){
                maxVal = arr[i] + arr[arr.length - 1 - i];
            }
        }
        System.out.print(maxVal);
    }
}