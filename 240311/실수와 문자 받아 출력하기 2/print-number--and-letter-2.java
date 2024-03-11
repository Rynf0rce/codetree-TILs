import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char s = sc.next().charAt(0);
        double x = sc.nextDouble();
        double y = sc.nextDouble();

        System.out.printf("%.2f\n", y);
        System.out.printf("%.2f\n", x);
        System.out.println(s);
    }
}