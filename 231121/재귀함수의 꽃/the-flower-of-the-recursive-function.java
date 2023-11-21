import java.util.*;

public class Main {
    public static void printFnc(int n){
        if(n == 0) return;
        System.out.print(n + " ");
        printFnc(n-1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        printFnc(N);
    }
}