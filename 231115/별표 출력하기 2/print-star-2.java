import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for( ; n > 0 ; n--){
            for(int i = n ; i > 0 ; i --){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}