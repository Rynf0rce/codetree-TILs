import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), num = sc.nextInt();
        int[] arr = new int[101];
        int maxVal = Integer.MIN_VALUE;
        for(int i = 0 ; i < num ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            for(int j = a ; j <= b ; j++){
                arr[j]++;
            }
        }

        for(int i = 1 ; i <= N ; i++){
            if(maxVal < arr[i]){
                maxVal = arr[i];
            }
        }
        System.out.print(maxVal);
    }
}