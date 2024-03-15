import java.util.*;
public class Main {
    public static int MAX_LENGTH = 20;
    public static String[] arr = new String[MAX_LENGTH];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.next();
        }

        Arrays.sort(arr, 0 , n);
        System.out.print(arr[0]);
    }
}