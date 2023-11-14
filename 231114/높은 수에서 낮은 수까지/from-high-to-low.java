import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a>=b){
            for(int n = a ; n >= b ; n--){
                System.out.print(n + " ");
            }
        }
        else{
            for(int n = b ; n >= a ; n--){
                System.out.print(n + " ");
            }
        }
    }
}