import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int output = 0;

        if(b > a && b < c){
            output = 1;
        }
        System.out.print(output);
    }
}