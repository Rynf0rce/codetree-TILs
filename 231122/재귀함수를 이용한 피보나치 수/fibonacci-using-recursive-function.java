import java.util.*;

public class Main {
    public static int fibonacci(int n){
        if(n <= 2){
            return 1;
        }
        else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.print(fibonacci(N));
    }
}