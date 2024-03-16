import java.util.*;
public class Main {
    public static int findAns(double a, double b){
        if(a > b){
            return findAns(b, a);
        }

        int cnt = 0;
        a = Math.sqrt(a);
        b = Math.sqrt(b);

        return (int)(b - a);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();

        System.out.print(findAns(a, b));
    }
}