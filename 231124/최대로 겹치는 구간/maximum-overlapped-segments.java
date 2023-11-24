import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), maxVal = Integer.MIN_VALUE;
        int[] arr = new int[201];
        for(int i = 0 ; i < num ; i++){
            int a = sc.nextInt() + 100;
            int b = sc.nextInt() + 100;
            for(int j = a ; j < b ; j++){
                arr[j]++;
            }
        }
        for(int i = 1 ; i < arr.length ; i++){
            if(maxVal < arr[i]){
                maxVal = arr[i];
            }
        }
        System.out.print(maxVal);
    }
}