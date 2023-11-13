import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter(":");
        int h = sc.nextInt();
        int m = sc.nextInt();
        System.out.printf("%d:%d", h + 1, m);
    }
}