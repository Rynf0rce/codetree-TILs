import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width = 4 * sc.nextInt();
        int height = sc.nextInt() + 3;
        System.out.println(width);
        System.out.println(height);
        System.out.println(width * height);
    }
}