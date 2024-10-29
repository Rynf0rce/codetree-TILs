import java.util.*;
public class Main {
    public static int[] arr = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int left = b;
        for(int i = 0 ; i < a ; i++){
            left += arr[i];
        }

        int right = d;
        for(int i = 0 ; i < c ; i++){
            right += arr[i];
        }

        System.out.print(Math.abs(right - left + 1));  
    }
}