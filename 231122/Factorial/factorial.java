import java.util.*;

public class Main {
    public static int factorial(int n){
        if(n <= 1){
            return 1;
        }
        else{
            return factorial(n-1) * n;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.print(factorial(N));
    }
}