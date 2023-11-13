import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        int height = sc.nextInt();
        width += 8; height *= 3;
        System.out.printf("%d\n%d\n%d", width, height, width * height);
    }
}