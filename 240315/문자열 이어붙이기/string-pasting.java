import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String front = sc.next();
        String back = sc.next();
        System.out.print(back.substring(0, 3) + front);
    }
}