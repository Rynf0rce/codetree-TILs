import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sumval = 0;

        for(int i = n ; i <= 100 ; i++){
            sumval += i;
        }
        System.out.print(sumval);
    }
}