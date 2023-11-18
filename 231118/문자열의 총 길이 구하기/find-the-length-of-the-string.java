import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[10];
        int sum = 0;
        for(int i = 0; i < arr.length ; i++){
            arr[i] = sc.next();
            sum += arr[i].length();
        }
        System.out.println(sum);
    }
}