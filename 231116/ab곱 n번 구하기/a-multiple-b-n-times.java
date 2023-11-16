import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0, b = 0, prod = 1;
        for(int i = 0 ; i < n ; i++){
            a = sc.nextInt(); b= sc.nextInt();
            prod = 1;
            for(int j = a ; j <= b ; j++){
                prod *= j;
            }
            System.out.println(prod);
        }
    }
}