import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            for(int j = 1 - i ; j <= n - i ; j++){
                if(j <= 0){
                    System.out.print("  ");
                }
                else{
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
}