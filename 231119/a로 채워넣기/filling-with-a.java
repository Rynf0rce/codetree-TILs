import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char[] arr = input.toCharArray();
        arr[1] = 'a';
        arr[arr.length -2] = 'a';
        input = String.valueOf(arr);
        System.out.print(input);
    }
}