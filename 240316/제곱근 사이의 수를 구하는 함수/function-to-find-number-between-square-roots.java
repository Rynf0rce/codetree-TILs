import java.util.*;
public class Main {
    public static int findAns(double a, double b){
        if(a > b){
            return findAns(b, a);
        }

        int cnt = 0;
        int A = (int)Math.sqrt(a);
        int B = (int)Math.sqrt(b);
        return B - A;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();

        System.out.print(findAns(a, b));
    }
}