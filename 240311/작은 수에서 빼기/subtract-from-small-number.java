import java.util.*;
public class Main {
    public static int printAns(int a, int b){
        if(a > b){
            return printAns(b, a);
        }
        return a - b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.print(printAns(a, b));
    }
}