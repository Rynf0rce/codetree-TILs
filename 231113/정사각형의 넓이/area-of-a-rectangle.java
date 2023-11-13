import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println((int)Math.pow(n,2));
        if (n<5){
            System.out.print("tiny");
        }
    }
}