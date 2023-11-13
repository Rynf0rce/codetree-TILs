import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("-");
        int m = sc.nextInt();
        int d = sc.nextInt();
        int y = sc.nextInt();
        System.out.printf("%d.%d.%d", y, m, d);
    }
}