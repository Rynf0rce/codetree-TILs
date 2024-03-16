import java.util.*;

public class Main {
    public static double circleArea(int radius){
        return 3.14 * radius * radius;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.printf("%.2f", circleArea(n));
    }
}