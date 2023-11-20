import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char input1 = sc.next().charAt(0), input2 = sc.next().charAt(0);
        System.out.printf("%d %d", ((int)input1 + (int)input2), Math.abs((int)input1 - (int)input2));
    }
}