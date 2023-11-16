import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = new char[10];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.next().charAt(0);
        }
        System.out.printf("%c %c %c", arr[1], arr[4], arr[7]);
    }
}