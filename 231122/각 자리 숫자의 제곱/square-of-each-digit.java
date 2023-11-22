import java.util.*;

public class Main {
    public static int digitSquare(int n){
        if(n < 10){
            return n * n;
        }
        else
        {
            return digitSquare(n/10) + (n%10)*(n%10);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.print(digitSquare(N));
    }
}