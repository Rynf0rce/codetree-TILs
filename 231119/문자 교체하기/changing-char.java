import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next(), str2 = sc.next();
        System.out.print(str1.substring(0, 2) + str2.substring(2));
    }
}