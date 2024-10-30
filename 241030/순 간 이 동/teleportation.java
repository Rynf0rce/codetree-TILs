import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int method1 = Math.abs(B - A);
        int method2 = Math.abs(x - A) + Math.abs(y - B);
        int method3 = Math.abs(y - A) + Math.abs(x - B);

        int minVal = Math.min(method1,Math.min(method2, method3));
        System.out.print(minVal);
    }
}