import java.util.*;

public class Main {
    public static void upper(int n){
        if(n == 0) return;
        upper(n-1);
        System.out.print(n + " ");
    }

    public static void lower(int n ){
        if(n == 0) return;
        System.out.print(n + " ");
        lower(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        upper(N);
        System.out.println();
        lower(N);
    }
}