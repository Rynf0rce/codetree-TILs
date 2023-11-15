import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i <= n ; i++){
            if(i % 2 == 0){
                for(int j = 0 ; j < i ; j++){
                    System.out.print("* ");
                }
                System.out.println();
            }
            else{
                System.out.println("*");
            }
        }
    }
}