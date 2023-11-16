import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;
        int[] arr = new int[n];
        int[] count = new int[7];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
            count[arr[i]]++;
        }
        for(int i = 1; i < count.length ; i++){
            System.out.printf("%d - %d\n", i, count[i]);
        }


    }
}