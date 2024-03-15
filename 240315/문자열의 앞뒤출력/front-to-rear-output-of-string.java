import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = String.valueOf(sc.next());
        System.out.println(str.substring(0, 3));
        System.out.println(str.substring(str.length() - 4 , str.length()));
    }
}