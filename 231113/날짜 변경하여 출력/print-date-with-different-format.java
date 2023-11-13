import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\\."); //  "."은 '모든 단어' 와 같은 의미를 가지고 있어 오류가 발생
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        System.out.printf("%d-%d-%d", m, d, y);
    }
}