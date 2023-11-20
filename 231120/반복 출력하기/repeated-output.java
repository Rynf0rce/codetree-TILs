import java.util.*;

public class Main {
    public static void printStr(int i){
        for(int j = 0 ; j < i ; j++){
            System.out.println("12345^&*()_");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printStr(n);
    }
}