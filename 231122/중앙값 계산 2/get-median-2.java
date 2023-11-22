import java.util.*;

public class Main {
    public static void median(int[] arr, int length){
        int[] currentArr = Arrays.copyOf(arr, length);
        Arrays.sort(currentArr);
        System.out.print(currentArr[length / 2] + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), input = 0;
        int[] arr = new int[num];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
            if((i+1) % 2 == 1){
                median(arr, i+1);
            }
        }
    }
}