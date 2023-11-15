import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), value = 0;
        for(int i = 1 ; i <= n ; i++){
            value = 8 + 2 * i;
            for(int j = 1 ; j <= n ; j++){
                System.out.print(value + (2*j - 1) + " ");
            }
            System.out.println();
        }
    }
}