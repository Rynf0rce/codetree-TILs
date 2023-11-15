import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = n ; i > 0 ; i--){
                for(int q = i ; q > 0 ; q--){
                    for(int j = i ; j > 0 ; j--){
                    System.out.print("*");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}