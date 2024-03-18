import java.util.*;

public class Main {
    public static void recurPrint(int n){
        if(n == 0){
            return;
        }
        System.out.println("Coding is my favorite hobby!");
        recurPrint(n - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        recurPrint(n);
    }
}