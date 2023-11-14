import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int output = 0;

        output = a>=b ? 1 : 0;
        System.out.println(output);
        output = a>b ? 1 : 0;
        System.out.println(output);
        output = a<=b ? 1 : 0;
        System.out.println(output);
        output = a<b ? 1 : 0;
        System.out.println(output);
    }
}