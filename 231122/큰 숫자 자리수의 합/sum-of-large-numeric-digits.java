import java.util.*;

public class Main {
    public static int sumDigit(int n){
        if(n < 10){
            return n;
        }
        else{
            return sumDigit(n/10) + (n % 10);
        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt(), n2 = sc.nextInt(), n3 = sc.nextInt();
        System.out.print(sumDigit(n1*n2*n3));
    }
}