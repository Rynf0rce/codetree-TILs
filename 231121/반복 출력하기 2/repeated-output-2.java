import java.util.*;

public class Main {
    public static void printHW(int i){
        if(i == 0){
            return;
        }
        printHW(i-1);
        System.out.println("HelloWorld");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        printHW(N);
    }
}