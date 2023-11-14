import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int productVal = 1;
        int i = 0;
        for(i = 1 ; i < 100 ; i++){
            productVal *= i;
            if(productVal >= n){
                break;
            }
        }
        System.out.print(i);
        
    }
}