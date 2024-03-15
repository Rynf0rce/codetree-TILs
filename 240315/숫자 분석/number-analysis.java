import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();
        int sum = 0;
        for(int i = arr.length - 1 ; i >= 0 ; i--){
            System.out.print(arr[i]);
            sum += arr[i] - '0';
        }
        System.out.print(" " + sum);
    }
}