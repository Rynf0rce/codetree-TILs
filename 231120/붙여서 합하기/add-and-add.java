import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next(), B = sc.next();
        String AB = A.concat(B), BA = B.concat(A);
        int sum = Integer.parseInt(AB) + Integer.parseInt(BA);
        System.out.print(sum);
    }
}