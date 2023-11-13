import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("-");
        String front = sc.next();
        String middle = sc.next();
        String back = sc.next();
        System.out.printf("%s-%s-%s",front, back, middle);
    }
}