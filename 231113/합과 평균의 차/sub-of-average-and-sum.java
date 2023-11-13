import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = a + b + c;
        System.out.printf("%d\n%d\n%d", d, d/3, d - d/3);
    }
}