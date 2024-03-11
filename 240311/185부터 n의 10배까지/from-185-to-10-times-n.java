import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double sum = 0;
        for(int i = 185 ; i <= n * 10 ; i++){
            sum += i;
        }
        System.out.print((int)sum + " ");
        System.out.printf("%.1f", sum /(n * 10 - 185 + 1));
    }
}