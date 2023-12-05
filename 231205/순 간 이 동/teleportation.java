import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(), B = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();
        int[] arr = new int[4];
        int formalDistance = Math.abs(B-A);
        int min_A = Math.min(Math.abs(x-A), Math.abs(y-A)), min_B = Math.min(Math.abs(x-B),Math.abs(y-B));
        System.out.println(Math.min(formalDistance, min_A + min_B));
    }
}