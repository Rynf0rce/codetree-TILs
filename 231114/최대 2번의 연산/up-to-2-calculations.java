import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        a = a % 2 == 0 ? a / 2 : (a + 1) / 2;
        a = a % 2 == 0 ? a / 2 : (a + 1) / 2;
        System.out.print(a);
    }
}