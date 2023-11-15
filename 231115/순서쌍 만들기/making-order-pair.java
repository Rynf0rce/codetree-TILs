import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = n ; i > 0; i--){
            for(int j = n ; j > 0 ; j--){
                System.out.printf("(%d,%d) ",i, j);
            }
            System.out.println();
        }
    }
}