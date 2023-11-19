import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        String A_B = A + B, B_A = B + A;
        System.out.print(A_B.equals(B_A) ? "true" : "false");
    }
}