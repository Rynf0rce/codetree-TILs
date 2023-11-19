import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int cutline = 2;
        str = str.substring(0,cutline) + str.substring(cutline + 1, str.length() - cutline) + str.substring(str.length() - 1);
        System.out.print(str);
    }
}