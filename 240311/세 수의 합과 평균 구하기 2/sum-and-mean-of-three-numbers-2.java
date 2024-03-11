import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        
        int sum = x + y + z;
        int avg = sum / 3;
        System.out.printf("avg %d\nsum %d", avg, sum);
    }
}