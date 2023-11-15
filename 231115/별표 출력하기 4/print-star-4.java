import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < 2*n -1 ; i++){
            if(i < n){
                for(int j = n - i ; j > 0 ; j--){
                    System.out.print("* ");
                }
                System.out.println();
            }
            else{
                for(int j = -1 ; j <= i-n ; j++){
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
    }
}