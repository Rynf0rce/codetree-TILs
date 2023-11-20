import java.util.*;

public class Main {
    public static boolean con_fuc(int n){
        char[] arr = String.valueOf(n).toCharArray();
        int sum = 0;
        for(int i = 0 ; i < arr.length ; i++){
            sum += arr[i] - '0';
        }
        return (n%2 == 0) && (sum%5 == 0) ? true : false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(con_fuc(n) ? "Yes" : "No");
    }
}