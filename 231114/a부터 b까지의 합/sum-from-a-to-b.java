import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sumval = 0;

        for(int i = a ; i <= b ; i++){
            sumval += i;
        }
        System.out.print(sumval);
    }
}