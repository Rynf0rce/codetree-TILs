import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        str = str.substring(1, str.length()) + str.substring(0,1);
        System.out.print(str);
    }
}