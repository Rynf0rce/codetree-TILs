import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if (a%2 == 0){
            a = a / 2;
        }
        if(a%2 == 1){
            a = (a + 1) / 2;
        }
        System.out.print(a);
    }
}